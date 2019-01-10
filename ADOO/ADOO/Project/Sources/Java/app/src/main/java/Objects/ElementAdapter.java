package Objects;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import java.io.Serializable;

public class ElementAdapter implements Parcelable, Serializable{

    //Constants
    private static final String TAG = "ElementAdapter.java";
    //Variables
    private String title, description;

    public ElementAdapter(String title, String description){
        //Initializing our global variables
        this.title = title;
        this.description = description;
    }

    /** ------------- GETTERS --------------- **/
    public String getTitle(){
        Log.d(TAG, "getTitle() called");
        Log.d(TAG, "getTitle() returned: " + this.title);
        return this.title;
    }
    
    public String getDescription(){
        Log.d(TAG, "getDescription() called");
        Log.d(TAG, "getDescription() returned: " + this.description);
        return this.description;
    }

    /** -------------- PARCELABLE METHODS ----------------- **/

    protected ElementAdapter(Parcel in) {
        title = in.readString();
        description = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(description);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ElementAdapter> CREATOR = new Creator<ElementAdapter>() {
        @Override
        public ElementAdapter createFromParcel(Parcel in) {
            return new ElementAdapter(in);
        }

        @Override
        public ElementAdapter[] newArray(int size) {
            return new ElementAdapter[size];
        }
    };
}
