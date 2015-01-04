package jonty.com.mojocar;

import android.os.AsyncTask;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;

import jonty.com.mojocar.model.Trip;

/**
 * Created by bharatkc on 1/3/15.
 */
class EventTask extends AsyncTask<String, Void, Integer> {

    @Override
    protected Integer doInBackground(String... params) {
        String url = params[0];
        HttpClient httpclient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(url);
        httpGet.addHeader("Content-Type", "application/json");
        httpGet.addHeader("MojioApiToken", MainActivity.API_KEY);

        try {
            HttpResponse httpResponse = httpclient.execute(httpGet);
            String result = Utility.inputStreamToString(httpResponse.getEntity().getContent()).toString();

            JSONObject object = new JSONObject(result);
            System.out.println(object.get("TotalRows"));
            ObjectMapper objectMapper = new ObjectMapper();
            Trip trip = objectMapper.readValue(result, Trip.class);

            int rows = trip.getTotalRows();
            System.out.printf("accident ===== "+rows);
            return rows;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}