package UIElements;


import android.app.Activity;
import android.app.AlertDialog;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.example.erick.adooproject.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import MapUtilities.MLatLng;
import Objects.Event;
import Objects.Exit;
import Objects.Service;
import Objects.Station;

import static UIElements.EventsUtilities.*;

import static DataBases.Firebase.FirebaseReferences.*;

public class EventsReports {
    //Constants
    private static final String TAG = "EventsReports.java";
    //Variables
    private Activity activity;


    //Constructor
    public EventsReports(Activity activity) {
        Log.d(TAG, "EventsReports() called with: activity = [" + activity + "]");
        this.activity = activity;
    }

    //This method shows the alert dialog in display
    public void showDialog(final Event event) {
        Log.d(TAG, "showDialog() called with: event = [" + event + "]");
        try {
            //This object contains information about an event
            LayoutInflater inflater = LayoutInflater.from(activity);
            View view = inflater.inflate(R.layout.activity_events, null);

            final AlertDialog alertDialog = new AlertDialog.Builder(activity).create();

            Button BTN_accident = view.findViewById(R.id.event_accident);
            BTN_accident.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.i(TAG, "onClick: ACCIDENT");
                    event.setType(ACCIDENT);
                    sendEvent(event);
                    Toast.makeText(activity, activity.getString(R.string.event_sent), Toast.LENGTH_LONG).show();
                    alertDialog.dismiss();
                }
            });

            Button BTN_crime = view.findViewById(R.id.event_crime);
            BTN_crime.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.i(TAG, "onClick: CRIME");
                    //Event event = new Event(CRIME, "Erick", "12:00", new LatLng(-1.342432, 1.3423));
                    event.setType(CRIME);
                    sendEvent(event);
                    Toast.makeText(activity, activity.getString(R.string.event_sent), Toast.LENGTH_LONG).show();
                    alertDialog.dismiss();
                }
            });

            Button BTN_failure = view.findViewById(R.id.event_failure);
            BTN_failure.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.i(TAG, "onClick: FAILURE");
                    //Event event = new Event(FAILURE, "Erick", "12:00", new LatLng(-1.342432, 1.3423));
                    event.setType(FAILURE);
                    sendEvent(event);
                    Toast.makeText(activity, activity.getString(R.string.event_sent), Toast.LENGTH_LONG).show();
                    alertDialog.dismiss();
                }
            });

            Button BTN_natural = view.findViewById(R.id.event_natural);
            BTN_natural.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.i(TAG, "onClick: NATURAL");
                    //Event event = new Event(NATURAL, "Erick", "12:00", new LatLng(-1.342432, 1.3423));
                    event.setType(NATURAL);
                    sendEvent(event);
                    Toast.makeText(activity, activity.getString(R.string.event_sent), Toast.LENGTH_LONG).show();
                    alertDialog.dismiss();
                }
            });

            Button BTN_by_users = view.findViewById(R.id.event_by_users);
            BTN_by_users.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.i(TAG, "onClick: BY USERS");
                    //Event event = new Event(ACCIDENT, "Erick", "12:00", new LatLng(-1.342432, 1.3423));
                    event.setType(BY_USER);
                    sendEvent(event);
                    Toast.makeText(activity, activity.getString(R.string.event_sent), Toast.LENGTH_LONG).show();
                    alertDialog.dismiss();
                }
            });

            Button BTN_close = view.findViewById(R.id.BTN_close_events);
            BTN_close.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.i(TAG, "onClick: CLOSE");
                    alertDialog.dismiss();
                }
            });
            alertDialog.setView(view);
            alertDialog.show();
        } catch (Exception ex) {
            Log.e(TAG, "showDialog: an Exception has occurred ", ex);
        }
    }

    /**
     * This method sends to our remote database using FireBase service
     * Receive: An object type Event
     * returns: nothing
     **/
    private void sendEvent(@NonNull final Event event) {
        Log.d(TAG, "sendEvent() called with: event = [" + event + "]");
        /**DataBases db = new DataBases(this.activity);
        db.insertStation("observatorio_LM1", testing());
        ArrayList<Station> stations = db.getStations();
        for (int i = 0; i < stations.size(); i++) {
            Log.i(TAG, " >>>>> sendEvent: " + stations.get(i).getName());
        }**/
         //We make instance of a FirebaseDatabase  object to create our database
         FirebaseDatabase database = FirebaseDatabase.getInstance();
         //We need to pass the name of our database and
         final DatabaseReference events = database.getReference(DB_REFERENCE)
         .child(EVENT_REFERENCE);
         events.push().setValue(event);

    }


    private Station testing() {
        Station station;
        ArrayList<Service> services = new ArrayList<>();
        ArrayList<Exit> exists = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            services.add(new Service("Name", "description"));
            exists.add(new Exit("Name", "Streets"));
        }

        ArrayList<MLatLng> next = new ArrayList<>();
        ArrayList<MLatLng> previous = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            next.add(new MLatLng(1.23, 1.43));
            previous.add(new MLatLng(5.21, 5.14));
        }
        MLatLng position = new MLatLng(10.42, 11.425);
        station = new Station("OBSERVATORIO", "LM1", position, services, exists, /**next, previous,**/ null);
        return station;
    }

}
