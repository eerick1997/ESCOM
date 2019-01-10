package Objects;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.nio.file.Path;
import java.util.ArrayList;

import MapUtilities.MLatLng;

public class Line implements Parcelable, Serializable {

    //Constanta
    private static final String TAG = "Line.java";
    //Variables
    private String line;
    //As we know each line contains stations, so
    private ArrayList<Station> stations;

    //Constructor
    public Line(String line, ArrayList<Station> stations) {
        Log.d(TAG, "Line() called with: line = [" + line + "], stations = [" + stations + "]");
        //Initializing out global variables
        this.line = line;
        this.stations = stations;
    }

    /**
     * --------------- GETTERS ---------------
     **/
    public String getWhichLine() {
        Log.d(TAG, "getWhichLine() called");
        Log.d(TAG, "getWhichLine() returned: " + this.line);
        return this.line;
    }

    public ArrayList<Station> getStations() {
        Log.d(TAG, "getStations() called");
        Log.d(TAG, "getStations() returned: " + this.stations);
        return this.stations;
    }

    /**
     * ---------- PARCELABLE METHODS ----------
     **/

    protected Line(Parcel in) {
        line = in.readString();
        stations = in.createTypedArrayList(Station.CREATOR);
    }

    public static final Creator<Line> CREATOR = new Creator<Line>() {
        @Override
        public Line createFromParcel(Parcel in) {
            return new Line(in);
        }

        @Override
        public Line[] newArray(int size) {
            return new Line[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(line);
        dest.writeTypedList(stations);
    }
}
