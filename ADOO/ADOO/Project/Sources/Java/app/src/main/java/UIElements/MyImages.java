package UIElements;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;

import com.example.erick.adooproject.R;

import Objects.Station;

public class MyImages {

    //Constants
    private static String TAG = "MyImages.java";
    //Variables
    private Activity activity;

    //Constructor
    public MyImages(Activity activity) {
        //Log.d(TAG, "MyImages() called with: activity = [" + activity + "]");
        //Initializing variables
        this.activity = activity;
    }

    /**
     * This method uses two images to fusing them
     * This method receive just an argument. This
     * argument is an String and this string is
     * the id of an station, so we can find the image
     * of our resources.
     * This method return a Bitmap object with our
     * images fused
     **/
    public Bitmap createIconMarker(String idStation, String line) {
        //Log.d(TAG, "createIconMarker() called with: idStation = [" + idStation + "]");
        //Getting the id of our resource 1 (station|event logo)
        idStation = "ic_"+idStation;
        //Log.i(TAG, "createIconMarker: " + idStation);
        int imageRes1 = activity.getResources()
                .getIdentifier(idStation,
                        "mipmap", activity.getPackageName());
        //Getting the id of our resource 2 (marker draw)
        int imageRes2 = activity.getResources()
                .getIdentifier("ic_marker",
                        "drawable", activity.getPackageName());

        //Creating a drawables using an ID
        Drawable drawable1 = activity.getResources().getDrawable(imageRes1);
        Drawable drawable2 = activity.getResources().getDrawable(imageRes2);

        //We cast drawable object to bitmap
        Bitmap bitmap1 = ((BitmapDrawable) drawable1).getBitmap();
        Bitmap bitmap2 = ((BitmapDrawable) drawable2).getBitmap();

        //We set an specific size of our images
        //Bitmap small1 = Bitmap.createScaledBitmap(bitmap1, 70, 70, true);
        Bitmap small2 = Bitmap.createScaledBitmap(bitmap2, 250, 250, false);
        Bitmap small1 = Bitmap.createScaledBitmap(bitmap1, small2.getWidth()-110, small2.getHeight()-110, false);
        //We need to paint our marker in a different color
        int[] pixels = new int[small2.getHeight() * small2.getWidth()];
        small2.getPixels(pixels, 0, small2.getWidth(), 0, 0,
                small2.getWidth(), small2.getHeight());
        for (int i = 0; i < pixels.length; i++) {
            if (pixels[i] == Color.BLACK)
                pixels[i] = Color.parseColor(new ChangeStyle(activity).getLineColor(line));
        }
        small2.setPixels(pixels, 0, small2.getWidth(), 0, 0, small2.getWidth(), small2.getHeight());
        Bitmap bresult = Bitmap.createBitmap(small2.getWidth(), small2.getHeight(), small2.getConfig());
        Canvas canvas = new Canvas();
        canvas.setBitmap(bresult);

        canvas.drawBitmap(small2, 0f, 0f, null);
        canvas.drawBitmap(small1, 55f, 45f, null);
        return bresult;
    }

    public void getNameImg(Station station, String type) {
        //Log.d(TAG, "getNameImg() called with: station = [" + station + "], type = [" + type + "]");
        String str_replace = "LM";
        if (type.equals("Metrobus")) str_replace = "LMB";
        String resource = "ic_" + station.getName().replace(" ", "_metro_" + station.getLine().replace(str_replace, ""));
        //Log.i(TAG, "getNameImg: resource name " + resource);
        //return "";
    }
}
