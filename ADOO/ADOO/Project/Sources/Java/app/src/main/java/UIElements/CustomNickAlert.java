package UIElements;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.erick.adooproject.Main;
import com.example.erick.adooproject.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import Objects.User;
import Preferences.SubgueyPreferences;

import static DataBases.Firebase.FirebaseReferences.DB_REFERENCE;
import static DataBases.Firebase.FirebaseReferences.USER_REFERENCE;
import static Preferences.Utilities.EMAIL;
import static Preferences.Utilities.IMG_PROFILE;
import static Preferences.Utilities.NAME_USER;
import static Preferences.Utilities.NICK_USER;
import static Preferences.Utilities.SIGNED;

public class CustomNickAlert {

    //Constants
    private static final String TAG = "CustomNickAlert.java";
    //Variables
    //private Context context;
    private Activity activity;
    private SubgueyPreferences preferences;
    private AlertDialog alertDialog;

    //Constructor
    public CustomNickAlert(Activity activity) {
        Log.d(TAG, "CustomNickAlert() called with: activity = [" + activity + "]");
        //Initializing variables
        this.activity = activity;
        //this.context = context;
        preferences = new SubgueyPreferences(this.activity);
    }

    /**This method show an customized alert dialog. We don't need
     * extra information to send data to an user                **/
    public void showDialog(final User user) {

        changeActivity();
        //As we said in the description we gonna use an Alert Dialog
        //final AlertDialog alertDialog;
        //Probably we catch an exception
        try{
            //We need to inflate a layout to customize an Alert Dialog
            LayoutInflater inflater = LayoutInflater.from(activity);
            /**Method inflate(here_we_have_the_name_of_the_layout_to_inflate, view_group)**/
            View view = inflater.inflate(R.layout.nick_alert, null);
            //We make an instance of an alertDialog
            alertDialog = new AlertDialog.Builder(activity).create();
            final EditText TXTNickName = view.findViewById(R.id.TXT_nick_alert);
            final Button button = view.findViewById(R.id.BTN_dialog_nick_alert);
            button.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {
                    button.setEnabled(false);
                    String nick_user = TXTNickName.getText().toString();
                    if(!nick_user.trim().isEmpty()) {
                        user.setNick_name(nick_user.trim());
                        Log.i("VALOR: ", "" + user.getNick_name());
                        register(user);
                        button.setEnabled(true);
                    } else if(nick_user.length() < 5){
                        Snackbar.make(v, activity.getString(R.string.username_size), Snackbar.LENGTH_LONG).show();
                    } else {
                        Snackbar.make(v, activity.getString(R.string.not_null_username), Snackbar.LENGTH_LONG).show();
                    }

                }
            });
            //We add all the elements in our Alert Dialog
            alertDialog.setView(view);
            alertDialog.show();
        } catch (Exception e){
            Log.e(TAG, "showDialog: ", e);
        }
    }

    /**
     * Description: This method send data to our database and verify if a user
     * already exists in the FireBase database
     * Parameters: An User object, as we know FireBase database is a oriented
     * object database, so we can send a complete object and It'll be registered
     * Returns: nothing
     **/
    private void register(@NonNull final User user) {
        Log.d(TAG, "register() called with: user = [" + user + "]");

        //We make an instance of a FirebaseDatabase object to create our database
        /*FirebaseDatabase database = FirebaseDatabase.getInstance();
        //We need to pass the name of our database and child to we need to use or create
        final DatabaseReference usuarios = database.getReference(FirebaseReferences.DB_REFERENCE).child(FirebaseReferences.USER_REFERENCE);
        //put Object on database's child User
        usuarios.push().setValue(user);*/

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference users = database.getReference(DB_REFERENCE).child(USER_REFERENCE);
        users.addListenerForSingleValueEvent(new ValueEventListener() {
            boolean bool1 = false;
            boolean bool2 = false;

            @Override
            public void onDataChange(DataSnapshot snapshot) {
                for (DataSnapshot objSnapshot : snapshot.getChildren()) {
                    final User actual = objSnapshot.getValue(User.class);
                    if (user.getEmail().equals(actual.getEmail())) {
                        bool1 = true;
                        Toast.makeText(activity, "La cuenta de correo gmail: " + user.getEmail() + " ya se encuentra asociada", Toast.LENGTH_LONG).show();
                    }
                    if (user.getNick_name().equals(actual.getNick_name())) {
                        bool2 = true;
                        Toast.makeText(activity, "El Nick " + user.getNick_name() + " ya se encuentra en uso, intente con otro ", Toast.LENGTH_LONG).show();
                    }
                }
                if ((!bool1) && (!bool2)) {
                    try {
                        getAccountData(user);
                        users.push().setValue(user);
                    } catch (Exception e) {
                        Log.e(TAG, "onDataChange: ", e);
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError firebaseError) {
                Log.e("Read failed", firebaseError.getMessage());
            }
        });
        //getAccountData(account); //line 168
    }

    private void getAccountData(User user) throws Exception {
        Log.d(TAG, "getAccountData() called with: user = [" + user + "]");

        /**String user_name = account.getDisplayName();
         String user_given_name = account.getGivenName();
         String user_family_name = account.getFamilyName();
         String user_email = account.getEmail();
         String user_id = account.getId();
         Uri user_photo = account.getPhotoUrl();
         String str_photo = "empty";
         try {
         str_photo = user_photo.toString();
         } catch (Exception e) {
         str_photo = "empty";
         }**/

        //We save the information of the user in our preferences
        //To save the last state
        preferences.savePreference(SIGNED, true);
        //To save the nickName
        preferences.savePreference(NICK_USER, user.getNick_name());
        //To save the name of this user
        preferences.savePreference(NAME_USER, user.getName());
        //To save the email
        preferences.savePreference(EMAIL, user.getEmail());
        //To save img_profile
        preferences.savePreference(IMG_PROFILE, user.getProfile_img());

        //Now we go to the next activity
        changeActivity();
    }

    /**
     * changeActivity method
     * Description: Verify if the user has already signed
     * Returns: Nothing
     **/
    private void changeActivity() {

        try {
            if (preferences.getIsSigned()) {
                Intent intent = new Intent(activity, Main.class);
                activity.startActivity(intent);
                alertDialog.dismiss();
            }
        } catch (Exception e) {
            Log.e(TAG, "changeActivity: ", e);
            preferences.cleanPreferences();
        }
    }

}
