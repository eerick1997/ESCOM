package MapUtilities;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.AsyncTask;
import android.util.Log;

import com.example.erick.adooproject.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PolylineOptions;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MakeARoute {
    //Constants
    private static final String TAG = "MakeARoute.java";
    //Variables
    private Activity activity;
    private GoogleMap googleMap;
    private LatLng origin, destination;
    private ProgressDialog progressDialog;
    private JSONParser jsonParser = new JSONParser();
    //Constructor
    public MakeARoute(Activity activity, LatLng origin, LatLng destination, GoogleMap googleMap){
        Log.d(TAG, "MakeARoute() called with: activity = [" + activity + "], " +
                "origin = [" + origin + "], destination = [" + destination + "], googleMap = [" + googleMap + "]");
        this.activity = activity;
        this.origin = origin;
        this.destination = destination;
        this.googleMap = googleMap;
        new downloadTask().execute(getURLDirections());
    }

    private String getURLDirections(){
        String str_origin = "origin=" + origin.latitude + "," + origin.longitude;
        String str_destin = "destination=" + destination.latitude + "," + destination.longitude;
        String sensor = "sensor=false";
        String parameters = str_origin + "&" + str_destin + "&" + sensor;
        String output = "json";
        String url = "https://maps.googleapis.com/maps/api/directions/" + output + "?"
                + parameters + "&avoid=highways&mode=transit";
        return url;
    }

    private String downloadURL(String str_url) throws IOException{
        String data = "";
        InputStream inputStream = null;
        HttpURLConnection urlConnection = null;
        try{
            URL url = new URL(str_url);
            urlConnection = (HttpURLConnection)url.openConnection();
            urlConnection.setConnectTimeout(10000);
            urlConnection.connect();
            if(urlConnection.getResponseCode() == 200){
                inputStream = urlConnection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuffer stringBuffer = new StringBuffer();
                String line = "";
                while((line = reader.readLine()) != null)
                    stringBuffer.append(line);
                data = stringBuffer.toString();
                reader.close();
            } else {
                return "0";
            }
        } catch (Exception e){
            Log.e(TAG, "downloadURL: ", e);
        } finally {
            inputStream.close();
            urlConnection.disconnect();
        }
        return data;
    }

    private class downloadTask extends AsyncTask<String, Void, String>{

        @Override
        protected String doInBackground(String... url) {
            String data = "";
            try{
                data = downloadURL(url[0]);
            } catch (Exception e){
                Log.e(TAG, "doInBackground: ", e);
            }
            return data;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                new ParserTask().execute(s);
            } catch (Exception e){
                Log.e(TAG, "onPostExecute: ", e);
            }
        }
    }

    private class ParserTask extends AsyncTask<String, Integer, List<List<HashMap<String, String>>>>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            try{
                progressDialog = new ProgressDialog(activity);
                progressDialog.setTitle(activity.getString(R.string.title_progress_download));
                progressDialog.setMessage(activity.getString(R.string.message_progress_download));
                progressDialog.setIndeterminate(true);
                progressDialog.setCancelable(false);
                progressDialog.show();
            }catch (Exception e){
                Log.e(TAG, "onPreExecute: ", e);
            }
        }

        @Override
        protected List<List<HashMap<String, String>>> doInBackground(String... jsonData) {
            List<List<HashMap<String, String>>> route = null;
            try{
                JSONObject jsonObject;
                jsonObject = new JSONObject(jsonData[0]);
                route = jsonParser.parse(jsonObject);
            } catch (Exception e){
                Log.e(TAG, "doInBackground: ", e);
            }
            return route;
        }

        @Override
        protected void onPostExecute(List<List<HashMap<String, String>>> lists) {
            super.onPostExecute(lists);
            ArrayList<LatLng> user_path = new ArrayList<>();
            try{
                for(int i = 0; i < lists.size(); i++){
                    List<HashMap<String, String>> path = lists.get(i);
                    for (int j = 0; j < path.size(); j++){
                        HashMap<String, String> point = path.get(j);
                        String lat = point.get("lat");
                        String lng = point.get("lng");
                        Log.i(TAG, "onPostExecute: lat = [" + lat + "] lng = [" + lng + "]");
                        user_path.add(new LatLng(Double.parseDouble(lat), Double.parseDouble(lng)));
                        PolylineOptions polylineOptions = new PolylineOptions();
                        polylineOptions.addAll(user_path);
                        polylineOptions.color(Color.BLACK);
                        googleMap.addPolyline(polylineOptions);
                    }
                }
            } catch (Exception e){
                Log.e(TAG, "onPostExecute: ", e);
            }finally {
                progressDialog.dismiss();
            }

        }
    }
}
