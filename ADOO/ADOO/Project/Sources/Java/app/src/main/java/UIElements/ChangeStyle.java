package UIElements;

import android.app.Activity;
import android.graphics.Color;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

public class ChangeStyle {

    //Constants
    private static final String TAG = "ChangeStyle.java";
    //Variables
    private Activity activity;

    public ChangeStyle(Activity activity) {
        //Log.d(TAG, "ChangeStyle() called with: activity = [" + activity + "]");
        this.activity = activity;
    }

    /**
     * This method changes the color of our collapsing toolbar
     * Receive:
     * color = An String that contains the line format
     * Returns: Nothing
     **/
    public void setColorCollapsingToolbar(String color, CollapsingToolbarLayout collapsingT) {
        Log.d(TAG, "setColorCollapsingToolbar() called with:" +
                "color = [" + color + "], " +
                "collapsingT = [" + collapsingT + "]");
        collapsingT.setContentScrimColor(Color.parseColor(getLineColor(color)));
    }

    /**
     *
     * **/
    public void setColorWindow(String color, Window window) {
        Log.d(TAG, "setColorWindow() called with:" +
                "color = context.getString(R.string.LM1); color = [" + color + "], " +
                "window = [" + window + "]");
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(Color.parseColor(getLineColor(color)));
    }

    public void setColorToolbar(String color, Toolbar toolbar) {
        Log.d(TAG, "setColorToolbar() called with: color = [" + color + "], toolbar = [" + toolbar + "]");
        toolbar.setBackgroundColor(Color.parseColor(getLineColor(color)));
    }

    public String getColor(String ID) {
        Log.d(TAG, "getColor() called with: ID = [" + ID + "]");
        int color = activity.getResources()
                .getIdentifier(ID, "string", activity.getPackageName());
        Log.i(TAG, "getColor: color " + color);
        Log.d(TAG, "getColor() returned: " + activity.getString(color));
        return activity.getString(color);
    }

    public String getLineColor(String str_line){
        //Log.d(TAG, "getLineColor() called with: str_line = [" + str_line + "]");
        String str_color = str_line.replace(" ", "_");

        //Log.i(TAG, "getLineColor: str_color " + str_color);
        int color = activity.getResources()
                .getIdentifier(str_color, "string", activity.getPackageName());
        //Log.d(TAG, "getLineColor() returned: " + activity.getString(color));
        return activity.getString(color);
    }

    public String getStationId(String nameStation, String line){
        //Log.d(TAG, "getStationId() called with: nameStation = [" + nameStation + "], line = [" + line + "]");
        String result = nameStation + "_" + line;
        result = result.replace("á", "a");
        result = result.replace("Á", "A");
        result = result.replace("é", "e");
        result = result.replace("É", "É");
        result = result.replace("í", "i");
        result = result.replace("Í", "I");
        result = result.replace("ó", "o");
        result = result.replace("Ó","O");
        result = result.replace("ú", "u");
        result = result.replace("Ú", "U");
        result = result.replace("ñ", "ni");
        result = result.replace(" ", "_");
        result = result.replace("-", "_");
        result = result.replace("/", "_");
        Log.d(TAG, "withoutSpecialCharacters() returned: " + result.toLowerCase());
        return result.toLowerCase();
    }

}
