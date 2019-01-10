package MapUtilities;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import java.io.Serializable;

public class MLatLng implements Parcelable, Serializable {

    //Constants
    private static final String TAG = "MLatLng";

    //Variables
    private Double latitude;
    private Double longitude;

    //Constructors
    public MLatLng() {

    }

    public MLatLng(Double latitude, Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    protected MLatLng(Parcel in) {
        if (in.readByte() == 0) {
            latitude = null;
        } else {
            latitude = in.readDouble();
        }
        if (in.readByte() == 0) {
            longitude = null;
        } else {
            longitude = in.readDouble();
        }
    }

    public static final Creator<MLatLng> CREATOR = new Creator<MLatLng>() {
        @Override
        public MLatLng createFromParcel(Parcel in) {
            return new MLatLng(in);
        }

        @Override
        public MLatLng[] newArray(int size) {
            return new MLatLng[size];
        }
    };

    /**
     * ------------ GETTERS ------------
     **/
    public Double getLatitude() {
        Log.d(TAG, "getLatitude() called");
        Log.d(TAG, "getLatitude() returned: " + this.latitude);
        return this.latitude;
    }

    public Double getLongitude() {
        Log.d(TAG, "getLongitude() called");
        Log.d(TAG, "getLongitude() called " + this.longitude);
        return this.longitude;
    }

    /**
     * ------------ SETTERS ------------
     **/

    public void setLatitude(Double latitude) {
        Log.d(TAG, "setLatitude() called with: latitude = [" + latitude + "]");
        this.latitude = latitude;
    }

    public void setLongitude(Double longitude) {
        Log.d(TAG, "setLongitude() called with: longitude = [" + longitude + "]");
        this.longitude = longitude;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (latitude == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(latitude);
        }
        if (longitude == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(longitude);
        }
    }
}
