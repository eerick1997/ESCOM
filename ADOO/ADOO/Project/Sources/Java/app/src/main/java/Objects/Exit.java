package Objects;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import java.io.Serializable;

/**
 * This class contains information about
 * the possible exits in each station
 **/
public class Exit implements Parcelable, Serializable{

    //Constants
    private static final String TAG = "Exit.java";
    //Variables
    private String name, streets;

    //Constructor
    public Exit(String name, String streets) {
        //Initializing our global variables
        this.name = name;
        this.streets = streets;
    }

    /**
     * --------------- GETTERS --------------
     **/
    public String getName() {
        Log.d(TAG, "getName() called");
        Log.d(TAG, "getName() returned: " + this.name);
        return this.name;
    }

    public String getStreets() {
        Log.d(TAG, "getStreets() called");
        Log.d(TAG, "getStreets() returned: " + this.streets);
        return this.streets;
    }

    /** --------------- PARCEL METHODS ---------------**/

    protected Exit(Parcel in) {
        name = in.readString();
        streets = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(streets);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Exit> CREATOR = new Creator<Exit>() {
        @Override
        public Exit createFromParcel(Parcel in) {
            return new Exit(in);
        }

        @Override
        public Exit[] newArray(int size) {
            return new Exit[size];
        }
    };


}
