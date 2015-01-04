package jonty.com.mojocar;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

import jonty.com.mojocar.model.Statistics;
import jonty.com.mojocar.model.Trip;


public class MainActivity extends Activity {

    public static final String TAG = "LoginActivity";
    public static final String TRIP_URL = "https://api.moj.io:443/v1/Trips?limit=10&offset=0&sortBy=StartTime&desc=false";
    public static final String EVENT_URL = "https://api.moj.io:443/v1/Events?limit=10&offset=0&sortBy=Time&desc=true&criteria=EventType%3d";

    public static final String API_KEY = "64841b18-f856-4159-b8cf-3c85093ca9a5";
    private ListView listView;
    private String []statistics = {"Accident", "FenceEntered", "Speed"}; // speed = excessive speed

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.listView);
        String[] stringArray = getResources().getStringArray(R.array.listElements);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, stringArray);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0 ) {
                    AsyncTask<String, Void, Trip> loginTask = new TripTask().execute(TRIP_URL);
                    try {
                        Trip trip = loginTask.get();
                        Intent intent = new Intent(MainActivity.this, TripActivity.class);
                        intent.putExtra("trip", trip);
                        startActivity(intent);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                } else if (position == 1) {
                    Statistics statistics1 = new Statistics();
                    for (int i =0 ; i< statistics.length ; i++) {

                        AsyncTask<String, Void, Integer> eventTask = new EventTask().execute(EVENT_URL+statistics[i]);
                        try {
                            Integer val = eventTask.get();
                            switch (i) {
                                case 0 :
                                    statistics1.setAccident(val);
                                    break;
                                case 1:
                                    statistics1.setFenceEntered(val);
                                    break;
                                case 2:
                                    statistics1.setExcessiveSpeed(val);
                                    break;
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } catch (ExecutionException e) {
                            e.printStackTrace();
                        }
                    }
                    Intent intent = new Intent(MainActivity.this, StatisticsActivity.class);
                    intent.putExtra("event", statistics1);
                    startActivity(intent);
                }

            }
        });





    }

    class TripTask extends AsyncTask<String, Void, Trip> {

        @Override
        protected Trip doInBackground(String... params) {
            String url = params[0];
            HttpClient httpclient = new DefaultHttpClient();
            HttpGet httpGet = new HttpGet(url);
            httpGet.addHeader("Content-Type", "application/json");
            httpGet.addHeader("MojioApiToken", API_KEY);

            try {
                HttpResponse httpResponse = httpclient.execute(httpGet);
                String result = Utility.inputStreamToString(httpResponse.getEntity().getContent()).toString();

                JSONObject object = new JSONObject(result);
                System.out.println(object.get("TotalRows"));
                ObjectMapper objectMapper = new ObjectMapper();
                Trip trip = objectMapper.readValue(result, Trip.class);

                System.out.println("rows ====== "+trip.getTotalRows());
                System.out.println(trip.getData().size());

                System.out.println(result);
                return trip;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

    }
}
