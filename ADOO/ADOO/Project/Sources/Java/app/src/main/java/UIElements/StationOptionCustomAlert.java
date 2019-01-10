package UIElements;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.example.erick.adooproject.R;
import com.example.erick.adooproject.activity_station_info;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;

import MapUtilities.MakeARoute;
import Objects.Station;

public class StationOptionCustomAlert {

    //Constants
    private static final String TAG = "StationOptionCustomAlert.java";

    //Variables
    private Activity activity;

    //Constructor
    public StationOptionCustomAlert(Activity activity){
        this.activity = activity;
    }

    @SuppressLint("LongLogTag")
    public void showDialog(final LatLng origin, final LatLng destination,
                           final Station station, final GoogleMap googleMap){
        Log.d(TAG, "showDialog() called with: origin = [" + origin + "], " +
                "destination = [" + destination + "], station = [" + station + "], " +
                "googleMap = [" + googleMap + "]");
        //Probably we catch an exception
        try{
            LayoutInflater inflater = LayoutInflater.from(activity);
            View view = inflater.inflate(R.layout.station_option_alert, null);
            final AlertDialog alertDialog = new AlertDialog.Builder(activity).create();

            Button BTN_path = view.findViewById(R.id.BTN_station_option_path);
            Button BTN_station_info = view.findViewById(R.id.BTN_station_option_show_info);
            Button BTN_dismiss = view.findViewById(R.id.BTN_station_option_alert_i_got_it);
            BTN_path.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(origin != null){
                        MakeARoute makeARoute = new MakeARoute(activity, origin,
                                destination, googleMap);
                        alertDialog.dismiss();
                    } else
                        Snackbar.make(v, activity.getString(R.string.gps_problems), Snackbar.LENGTH_LONG).show();
                }
            });

            BTN_station_info.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(activity, activity_station_info.class);
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("station", station);
                    intent.putExtras(bundle);
                    activity.startActivity(intent);
                    alertDialog.dismiss();
                }
            });

            BTN_dismiss.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    alertDialog.dismiss();
                }
            });

            alertDialog.setView(view);
            alertDialog.show();
        } catch (Exception e){
            Log.e(TAG, "showDialog: ", e);
        }
    }
}
