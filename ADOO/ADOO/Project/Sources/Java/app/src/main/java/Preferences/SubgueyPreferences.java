package Preferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import static Preferences.Utilities.EMAIL;
import static Preferences.Utilities.IMG_PROFILE;
import static Preferences.Utilities.NAME_PREFERENCES;
import static Preferences.Utilities.NAME_USER;
import static Preferences.Utilities.NICK_USER;
import static Preferences.Utilities.SIGNED;

/**This class is created to get and set preferences of our application
 * in this case we can get preferences about the login of a user**/
public class SubgueyPreferences {

    //Constants
    private static final String TAG = "SubgueyPreferences.java";
    //Variables
    private Context context;
    //To get access to out preferences
    private SharedPreferences sharedPreferences;

    /**Constructor
     * The constructor needs the context of the activity which we're trying to
     * make an instance, then we initialize our global variable context and
     * finally we create a new object type SharedPreferences which we gonna
     * use in all methods inside this class**/
    public SubgueyPreferences(Context context) {
        Log.d(TAG, "SubgueyPreferences() called with: context = [" + context + "]");
        this.context = context;
    }



    /**savePreference method
     * Description: This method change the value of a variable inside our file to preferences
     * Parameters: First a String which is the name of the variable to change
     *             Second is an object, we gonna use it to save a new value
     * Returns: nothing                                                                     **/
    public void savePreference(String key, Object data){
        Log.d(TAG, "savePreference() called with: key = [" + key + "], data = [" + data + "]");
        //Probably we catch an Exception
        try{
            //We gonna edit a value
            SharedPreferences.Editor editor = sharedPreferences.edit();
            //Maybe the object is a Boolean type
            if (key.equals(SIGNED))
                editor.putBoolean(key, (Boolean)data);
            //The object is an String
            else
                editor.putString(key, (String)data);
            //We save the changes
            editor.apply();
        } catch (Exception e){
            Log.e(TAG, "savePreference: an exception has occurred ", e);
        }
    }

    /**--------------- GETTERS ---------------**/
    public String getNameUser(){
        Log.d(TAG, "getNameUser() called");
        sharedPreferences = context.getSharedPreferences(NAME_PREFERENCES, Context.MODE_PRIVATE);
        return sharedPreferences.getString(NAME_USER, "");
    }

    public String getNickUser() {
        Log.d(TAG, "getNickUser() called");
        sharedPreferences = context.getSharedPreferences(NAME_PREFERENCES, Context.MODE_PRIVATE);
        return sharedPreferences.getString(NICK_USER, "");
    }
    public String getEmail(){
        Log.d(TAG, "getEmail() called");
        sharedPreferences = context.getSharedPreferences(NAME_PREFERENCES, Context.MODE_PRIVATE);
        return sharedPreferences.getString(EMAIL, "");
    }

    public String getProfileURIIMG(){
        Log.d(TAG, "getProfileURIIMG() called");
        sharedPreferences = context.getSharedPreferences(NAME_PREFERENCES, Context.MODE_PRIVATE);
        return sharedPreferences.getString(IMG_PROFILE, "");
    }
    public Boolean getIsSigned(){
        Log.d(TAG, "getIsSigned() called");
        sharedPreferences = context.getSharedPreferences(NAME_PREFERENCES, Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(SIGNED, false);
    }

    /**--------------- END GETTERS ---------------**/

    /**cleanPreferences method
     * Description: This method delete all the values inside our preferences
     * Parameters: None
     * Returns: Nothing                                                     **/
    public void cleanPreferences(){
        Log.d(TAG, "cleanPreferences() called");
        //Probably we catch en exception
        try{
            sharedPreferences = context.getSharedPreferences(NAME_PREFERENCES, 0);
            //We gonna edit preferences
            SharedPreferences.Editor editor = sharedPreferences.edit();
            //We clean the preference NICK_USER
            editor.putString(NICK_USER, "");
            //We clean the preference NAME_USER
            editor.putString(NAME_USER, "");
            //We clean the preference EMAIL
            editor.putString(EMAIL, "");
            //We change the state to false
            editor.putBoolean(SIGNED, false);
            //We save the changes
            editor.apply();
        } catch (Exception e){
            Log.e(TAG, "cleanPreferences: an Exception has occurred", e);
        }
    }
}
