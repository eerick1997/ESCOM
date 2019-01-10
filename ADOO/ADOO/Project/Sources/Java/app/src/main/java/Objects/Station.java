package Objects;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
//import android.util.Log;

import com.google.android.gms.maps.model.LatLng;

import java.io.Serializable;
import java.util.ArrayList;

import MapUtilities.MLatLng;

/**
 * This object contains information about an Station
 **/
public class Station implements Parcelable, Serializable {

    //Constants
    private static final String TAG = "Station.java";
    //Variables
    private MLatLng position;
    private String name, line;
    //Here we store information about different services into each station
    private ArrayList<Service> services;
    //Here we store information about different exits into each station
    private ArrayList<Exit> exits;
    //Here we store information about different points in the neighborhood map
    private ArrayList<MLatLng> neighborhood;
    /*Here we store information about different the points of the path to go to the
    next station*/
    //private ArrayList<MLatLng> next;
    //private ArrayList<MLatLng> previous;

    public Station() {

    }
    //Constructor
    public Station(String name, String line, MLatLng position,
                   ArrayList<Service> services, ArrayList<Exit> exits,
                   /**ArrayList<MLatLng> next, ArrayList<MLatLng> previous,**/
                   ArrayList<MLatLng> neighborhood) {
        /*Log.d(TAG, "Station() called with: name = [" + name + "], line = [" + line + "], " +
                "position = [" + position + "], services = [" + services + "], " +
                "exits = [" + exits + "], neighborhood = [" + neighborhood + "]");*/
        this.name = name;
        this.line = line;
        this.position = position;
        this.services = services;
        this.exits = exits;
        //this.next = next;
        //this.previous = previous;
        this.neighborhood = neighborhood;
    }

    /**
     * --------------- GETTERS ---------------
     **/

    public String getName() {
        //Log.d(TAG, "getName() called");
        //Log.d(TAG, "getName() returned: " + this.name);
        return this.name;
    }

    public String getLine() {
        //Log.d(TAG, "getLine() called");
        //Log.d(TAG, "getLine() returned: " + this.line);
        return this.line;
    }

    public MLatLng getPosition() {
        //Log.d(TAG, "getPosition() called");
        //Log.d(TAG, "getPosition() returned: " + this.position);
        return this.position;
    }

    public ArrayList<Service> getServices() {
        //Log.d(TAG, "getServices() called");
        //Log.d(TAG, "getServices() returned: " + this.services);
        return this.services;
    }

    public ArrayList<Exit> getExits() {
        //Log.d(TAG, "getExits() called");
        //Log.d(TAG, "getExits() returned: " + this.exits);
        return this.exits;
    }

    public ArrayList<Object> getElelments() {
        //Log.d(TAG, "getNeighborhood() called");
        ArrayList<Object> elements = new ArrayList<>();
        elements.addAll(getExits());
        elements.addAll(getServices());
        System.out.println(elements);
        return elements;
    }

    /**public ArrayList<MLatLng> getNext() {
        //Log.d(TAG, "getNext() called");
        return this.next;
    }

    public ArrayList<MLatLng> getPrevious() {
        //Log.d(TAG, "getPrevious() called");
        return previous;
    }

    public ArrayList<MLatLng> getNeighborhood() {
        //Log.d(TAG, "getNeighborhood() called");
        //Log.d(TAG, "getNeighborhood() returned: " + this.neighborhood);
        return this.neighborhood;
    }

    /**
     * --------------- Other methods ----------------
     **/

    public LatLng getLatLng() {
        //Log.d(TAG, "getLatLng() called");
        return new LatLng(position.getLatitude(), position.getLongitude());
    }

    /**public ArrayList<LatLng> getNextLatLng(){
        //Log.d(TAG, "getNextLatLng() called");
        ArrayList<LatLng> nextLatLng = new ArrayList<>();
        for(int i = 0; i < next.size(); i++){
            nextLatLng.add(new LatLng(next.get(i).getLatitude(), next.get(i).getLongitude()));
        }
        return nextLatLng;
    }

    public ArrayList<LatLng> getPreciousLatLng(){
        //Log.d(TAG, "getPreciousLatLng() called");
        ArrayList<LatLng> previousLatLng = new ArrayList<>();
        for(int i = 0; i < previous.size(); i++){
            previousLatLng.add(new LatLng(previous.get(i).getLatitude(), previous.get(i).getLongitude()));
        }
        return previousLatLng;
    }**/
    
    public ArrayList<LatLng> getNeighborhoodLatLng(){
        //Log.d(TAG, "getNeighborhoodLatLng() called");
        ArrayList<LatLng> neighborhoodLatLng = new ArrayList<>();
        for(int i = 0; i < neighborhood.size(); i++){
            neighborhoodLatLng.add(new LatLng(neighborhood.get(i).getLatitude(), neighborhood.get(i).getLongitude()));
        }
        //Log.d(TAG, "getNeighborhoodLatLng() returned: " + neighborhoodLatLng);
        return neighborhoodLatLng;
    }

    /**
     * --------------- PARCEL METHODS ---------------
     **/


    protected Station(Parcel in) {
        position = in.readParcelable(MLatLng.class.getClassLoader());
        name = in.readString();
        line = in.readString();
        services = in.createTypedArrayList(Service.CREATOR);
        exits = in.createTypedArrayList(Exit.CREATOR);
        //next = in.createTypedArrayList(MLatLng.CREATOR);
        //previous = in.createTypedArrayList(MLatLng.CREATOR);
        neighborhood = in.createTypedArrayList(MLatLng.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(position, flags);
        dest.writeString(name);
        dest.writeString(line);
        dest.writeTypedList(services);
        dest.writeTypedList(exits);
        //dest.writeTypedList(next);
        //dest.writeTypedList(previous);
        dest.writeTypedList(neighborhood);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Station> CREATOR = new Creator<Station>() {
        @Override
        public Station createFromParcel(Parcel in) {
            return new Station(in);
        }

        @Override
        public Station[] newArray(int size) {
            return new Station[size];
        }
    };


}
