package UIElements;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;

import com.example.erick.adooproject.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class customMarkerEvent {

    //Constants
    private static final String TAG = "customMarkerEvent.java";
    //Variables
    private Context context;
    private GoogleMap googleMap;

    public customMarkerEvent(Context context, GoogleMap googleMap){
        Log.d(TAG, "customMarkerEvent() called with: context = [" + context + "], googleMap = [" + googleMap + "]");
        this.context = context;
        this.googleMap = googleMap;
    }

    public void set(LatLng position){

        Bitmap.Config b_config = Bitmap.Config.ARGB_8888;
        Bitmap bitmap = Bitmap.createBitmap(80,80,b_config);
        Canvas canvas = new Canvas(bitmap);
        Paint color = new Paint();
        color.setTextSize(35);
        color.setColor(Color.BLACK);

        canvas.drawBitmap(BitmapFactory.decodeResource(context.getResources(),
                R.drawable.nav_subway), 0,0, color);
        canvas.drawText("User Name!", 30, 40, color);


        Marker marker = googleMap.addMarker(new MarkerOptions()
            .position(position)
            .title("Somewhere")
            .snippet("Something")
            .icon(BitmapDescriptorFactory.fromBitmap(bitmap))
            .anchor(0.5f, 1));

    }

}
