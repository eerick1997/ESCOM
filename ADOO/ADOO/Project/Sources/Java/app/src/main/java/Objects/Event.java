package Objects;

//import android.util.Log;

import com.google.android.gms.maps.model.LatLng;

import MapUtilities.MLatLng;

public class Event {

    //Constants
    private static final String TAG = "Event.java";

    //Variables
    private int type;
    private String user, hour;
    private MLatLng position;

    public Event() {
    }

    public Event(int type, String user, String hour, MLatLng position) {
        //Log.d(TAG, "Event() called with: type = [" + type + "], user = [" + user + "], hour = [" + hour + "]");
        this.type = type;
        this.user = user;
        this.hour = hour;
        this.position = position;
    }

    /**
     * -------------- GETTERS ---------------
     **/
    public int getType(){
        //Log.d(TAG, "getType() called");
        //Log.d(TAG, "getType() returned: " + this.type);
        return this.type;
    }

    public String getUser() {
        //Log.d(TAG, "getUser() called");
        //Log.d(TAG, "getUser() returned: " + this.user);
        return this.user;
    }

    public String getHour(){
        //Log.d(TAG, "getHour() called");
        //Log.d(TAG, "getHour() returned: " + hour);
        return this.hour;
    }

    public LatLng getPosition() {
        //Log.d(TAG, "getPosition() called");
        //Log.d(TAG, "getPosition() returned: " + this.position);
        return new LatLng(position.getLatitude(), position.getLongitude());
    }

    /**
     * -------------- SETTERS ---------------
     **/

    public void setType(int type) {
        //Log.d(TAG, "setType() called with: type = [" + type + "]");
        this.type = type;
    }

    public void setUser(String user) {
        //Log.d(TAG, "setUser() called with: user = [" + user + "]");
        this.user = user;
    }

    public void setHour(String hour) {
        //Log.d(TAG, "setHour() called with: hour = [" + hour + "]");
        this.hour = hour;
    }

    public void setPosition(MLatLng position) {
        //Log.d(TAG, "setPosition() called with: position = [" + position + "]");
        this.position = position;
    }

}
