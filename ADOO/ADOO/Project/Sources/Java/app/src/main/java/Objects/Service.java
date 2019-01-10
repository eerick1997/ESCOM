package Objects;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import java.io.Serializable;

/**
 * As we know in each station we have different services so,
 * this class was created to get this information
 * **/
public class Service implements Parcelable, Serializable{

    //Constants
    private static final String TAG = "Service.java";
    //Variables
    private String name, description;

    //Constructor
    public Service(String name, String description) {
        //Initializing global variables
        this.name = name;
        this.description = description;
    }

    protected Service(Parcel in) {
        name = in.readString();
        description = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(description);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Service> CREATOR = new Creator<Service>() {
        @Override
        public Service createFromParcel(Parcel in) {
            return new Service(in);
        }

        @Override
        public Service[] newArray(int size) {
            return new Service[size];
        }
    };

    /**--------------- GETTERS ----------------**/
    public String getName(){
        Log.d(TAG, "getName() called");
        Log.d(TAG, "getName() returned: " + this.name);
        return this.name;
    }

    public String getDescription(){
        Log.d(TAG, "getSchedule() called");
        Log.d(TAG, "getSchedule() returned: " + this.description);
        return this.description;
    }
}
