package com.example.erick.adooproject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import Objects.User;
import Preferences.SubgueyPreferences;
import UIElements.CustomNickAlert;

import static DataBases.Firebase.FirebaseReferences.DB_REFERENCE;
import static DataBases.Firebase.FirebaseReferences.USER_REFERENCE;
import static Preferences.Utilities.*;



public class Login extends AppCompatActivity implements OnConnectionFailedListener {

    private static final String TAG = "Login.java";
    private static final int RC_SIGN_IN = 9001;
    private GoogleSignInClient googleSignInClient;
    //This is our own object, here we store information about this user
    private User user;
    //To revoke access
    private boolean button_state = false;
    //We gonna use preferences so we make an instance of this object
    SubgueyPreferences preferences = new SubgueyPreferences(Login.this);
    SignInButton signInButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate() called with: savedInstanceState = [" + savedInstanceState + "]");
        setContentView(R.layout.activity_login);

        if (preferences.getIsSigned()) {
            Intent intent = new Intent(this, Main.class);
            startActivity(intent);
        }

        /*We create a GoogleSignInOptions to configure Google Sign-in to request users ID
        and get basic information using the DEFAULT_SIGN_IN parameter*/
        GoogleSignInOptions googleSignInOptions = new GoogleSignInOptions.Builder
                (GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestProfile()
                .requestEmail()
                .build();

        /*We create a GoogleSignInClient to set different options already
         * specified in the googleSignInOptions object*/
        googleSignInClient = GoogleSignIn.getClient(this, googleSignInOptions);

        /*Making an instance of our button to sign in an user*/
        signInButton = findViewById(R.id.btn_sign_in_button);
        //Setting size
        signInButton.setSize(SignInButton.SIZE_STANDARD);
        /*Setting on click listener event*/
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Here we set the action when SignInButton is pressed*/
                Snackbar.make(v, getString(R.string.login_please_wait), Snackbar.LENGTH_LONG).show();
                revokeAccess();

                /*if(!button_state)*/ signIn();
                //else revokeAccess();
                signInButton.setEnabled(false);
            }
        });

        //DON'T ERASE THIS
        /*We create a Button to revoke access*/
        Button button = findViewById(R.id.BTN_revoke);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Revoke access", Snackbar.LENGTH_LONG).show();
                revokeAccess();
            }
        });

    }

    @Override
    protected void onStart() {
        Log.d(TAG, "onStart() called");
        super.onStart();
        Log.d(TAG, "onStart() called");
        try {
            /*Here we check if an user is already signed in our app.
             * if someone is already signed the GoogleSignInAccount will be non-null*/
            GoogleSignInAccount googleSignInAccount = GoogleSignIn.getLastSignedInAccount(this);
            if (googleSignInAccount != null) {
                Log.i(TAG, "onStart: An user has been found " + googleSignInAccount.getDisplayName());
                //getAccountData(googleSignInAccount);
            } else {
                Log.i(TAG, "onStart: I don't found a user");
                //preferences.cleanPreferences();
            }
        } catch (Exception e) {
            Log.e(TAG, "onStart: ", e);
        }
    }

    /**
     * signIn method
     * Description: this method start a new Intent with startActivityForResult
     * Parameters: none
     * Returns: Anything
     **/
    private void signIn() {
        Log.d(TAG, "signIn() called");
        //Creating an Intent object
        Intent signInIntent = googleSignInClient.getSignInIntent();
        signInButton.setEnabled(true);
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    /**
     * handleSignInResult method
     * Description: this method makes changes if the user signs-in successfully
     * Parameters: Task<GoogleSignInAccount>
     * Returns: anything
     **/
    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        Log.d(TAG, "handleSignInResult() called with: completedTask = [" + completedTask + "]");
        try {
            /*This object (GoogleSignInAccount) contains information about the
             * signed user*/
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);
            /**Signed in successfully we can update the UI**/
            if (account != null) {
                try {
                    String user_name = account.getDisplayName();
                    String user_given_name = account.getGivenName();
                    String user_family_name = account.getFamilyName();
                    String user_email = account.getEmail();
                    String user_id = account.getId();
                    Uri user_photo = account.getPhotoUrl();
                    String str_photo;
                    try {
                        str_photo = user_photo.toString();
                    } catch (Exception e) {
                        str_photo = "empty";
                    }

                    //User data
                    user = new User(user_name, user_email, user_given_name,
                            1.0f, 10.0f, str_photo,
                             1);

                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    final DatabaseReference users = database.getReference(DB_REFERENCE).child(USER_REFERENCE);
                    users.addListenerForSingleValueEvent(new ValueEventListener() {
                        boolean bool = false;

                        @Override
                        public void onDataChange(DataSnapshot snapshot) {
                            for (DataSnapshot objSnapshot : snapshot.getChildren()) {
                                final User actual = objSnapshot.getValue(User.class);
                                if (user.getEmail().equals(actual.getEmail())) {
                                    bool=true;
                                    Toast.makeText(Login.this, "La cuenta de correo " + user.getEmail() + " ya se encuentra asociada, Subgüey usará estos datos", Toast.LENGTH_LONG).show();
                                    preferences.savePreference(NICK_USER, actual.getNick_name());
                                    preferences.savePreference(EMAIL, actual.getEmail());
                                    preferences.savePreference(SIGNED, true);
                                    preferences.savePreference(NAME_USER, actual.getName());
                                    preferences.savePreference(IMG_PROFILE, actual.getProfile_img());
                                    Intent intent= new Intent(Login.this,Main.class);
                                    startActivity(intent);

                                }
                            }
                            if(!bool){
                                CustomNickAlert nick_alert= new CustomNickAlert(Login.this);
                                nick_alert.showDialog(user);
                            }
                        }
                        @Override
                        public void onCancelled(DatabaseError firebaseError) {
                            Log.e("Read failed", firebaseError.getMessage());
                        }
                    });
                    Log.i(TAG, "handleSignInResult: " + user_name + " " + user_given_name + " "
                            + user_family_name + " " + user_email + " " + user_id + " " + user_photo);
                    //Getting account data and storing in preferences

                    //getAccountData(account);
                } catch (Exception e) {
                    Log.e(TAG, "handleSignInResult: ", e);
                }
            } else {
                Log.e(TAG, "handleSignInResult: we can't get the account");
            }
        } catch (ApiException e) {
            Log.e(TAG, "handleSignInResult: ", e);

        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d(TAG, "onActivityResult() called with: requestCode = [" + requestCode + "], " +
                "resultCode = [" + resultCode + "], data = [" + data + "]");
        super.onActivityResult(requestCode, resultCode, data);
        /*Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);*/
        if (requestCode == RC_SIGN_IN) {
            /*The task returned from this call is always completed, no need to attach a listener*/
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }

    private void revokeAccess() {
        Log.d(TAG, "revokeAccess() called");
        googleSignInClient.revokeAccess()
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(getApplicationContext(), getString(R.string.attepting), Toast.LENGTH_LONG).show();
                        Log.i(TAG, "onComplete: Cleaning preferences...");
                        preferences.cleanPreferences();
                        signIn();
                    }
                });
    }

    @SuppressLint("ResourceType")
    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Log.d(TAG, "onConnectionFailed() called with: connectionResult = [" + connectionResult + "]");
        Toast.makeText(getApplicationContext(), getString(R.id.no_connection), Toast.LENGTH_LONG).show();
    }

}
