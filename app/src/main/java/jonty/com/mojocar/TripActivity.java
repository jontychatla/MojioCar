package jonty.com.mojocar;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jonty.com.mojocar.model.Data;
import jonty.com.mojocar.model.Trip;
import android.view.*;
import android.widget.*;

/**
 * Created by bharatkc on 1/3/15.
 */
public class TripActivity extends Activity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trip_layout);
        Trip trip = (Trip)getIntent().getSerializableExtra("trip");
        if(trip != null ) {
            TripAdapter tripAdapter = new TripAdapter(this, trip.getData());
            listView = (ListView)findViewById(R.id.tripListView);
            listView.setAdapter(tripAdapter);
        }

    }


    class TripAdapter extends ArrayAdapter<Data> {
        private List<Data> data = new ArrayList<Data>();
        private Context context;
        private LayoutInflater layoutInflater;

        public TripAdapter(Context context, List<Data> orderItems) {
            super(context, R.layout.trip_row_layout, orderItems);
            this.context = context;
            this.data = orderItems;
            layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = layoutInflater.inflate(R.layout.trip_row_layout, null);
            }
            TextView startTime = (TextView) convertView.findViewById(R.id.startTimeValue);
            TextView endTime = (TextView) convertView.findViewById(R.id.endTimeValue);
            TextView maxSpeed = (TextView) convertView.findViewById(R.id.maxSpeedValue);
            TextView distance = (TextView) convertView.findViewById(R.id.distanceValue);
            Data data = this.data.get(position);
            startTime.setText(data.getStartTime());
            endTime.setText(data.getEndTime());
            maxSpeed.setText(data.getMaxSpeed()+"");
            distance.setText(data.getDistance()+" mile");
            return convertView;
        }
    }

}
