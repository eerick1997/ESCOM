package UIElements;

import android.app.AlertDialog;
import android.content.Context;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.erick.adooproject.R;

import Objects.Event;
import de.hdodenhof.circleimageview.CircleImageView;

import static UIElements.EventsUtilities.*;

/**This class contains the code to show a custom alert dialog
 * which show us information about an event, the information provided is:
 * Who publish it
 * When (Hour)
 * **/
public class EventInfo {

    //Constants
    private static final String TAG = "EventInfo.java";
    //Variables
    private Context context;

    //Constructor
    public EventInfo(Context context){
        //Initializing our global variable context
        this.context = context;
    }

    /**This method show an customized alert dialog, so we need some data
     * that we go to use to display information, (Probably we can use an
     * Event object instead all this parameters)**/
    public void showDialog(Event event){
        //As we said in the description we gonna use an Alert Dialog
        final AlertDialog alertDialog;
        //Probably we catch an exception
        try{
            //We need to inflate a layout to customize an Alert Dialog
            LayoutInflater inflater = LayoutInflater.from(context);
            /**Method inflate(here_we_have_the_name_of_the_layout_to_inflate, view_group)**/
            View view = inflater.inflate(R.layout.dialog_event_info, null);
            //We make an instance of an alertDialog
            alertDialog = new AlertDialog.Builder(context).create();
            TextView txt_name_event = view.findViewById(R.id.TXT_dialog_event_name);
            TextView txt_publisher = view.findViewById(R.id.TXT_dialog_event_user);
            TextView txt_hour = view.findViewById(R.id.TXT_dialog_event_hour);
            TextView txt_message = view.findViewById(R.id.TXT_dialog_message);
            Button btn_got_it = view.findViewById(R.id.BTN_alert_dialog_i_got_it);
            CircleImageView circleImageView = view.findViewById(R.id.circle_image_view_events);
            txt_publisher.setText(event.getUser());
            btn_got_it.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Snackbar.make(v, "Button pressed", Snackbar.LENGTH_SHORT).show();
                    alertDialog.dismiss();
                }
            });

            txt_hour.setText(event.getHour());
            if(event.getType() == ACCIDENT) {
                txt_name_event.setText(context.getString(R.string.accident_title));
                circleImageView.setImageResource(R.drawable.event_accident);
                txt_message.setText(context.getString(R.string.accident_message));
            }else if(event.getType() == CRIME) {
                txt_name_event.setText(context.getString(R.string.crime_title));
                circleImageView.setImageResource(R.drawable.event_crime);
                txt_message.setText(context.getString(R.string.crime_message));
            }else if(event.getType() == FAILURE) {
                txt_name_event.setText(context.getString(R.string.failure_title));
                circleImageView.setImageResource(R.drawable.event_failure);
                txt_message.setText(context.getString(R.string.failure_message));
            }else if(event.getType() == NATURAL) {
                txt_name_event.setText(context.getString(R.string.natural_title));
                circleImageView.setImageResource(R.drawable.event_natural);
                txt_message.setText(context.getString(R.string.accident_message));
            }else if(event.getType() == BY_USER) {
                txt_name_event.setText(context.getString(R.string.by_user_title));
                circleImageView.setImageResource(R.drawable.event_by_user);
                txt_message.setText(context.getString(R.string.by_user_message));
            }
            //We add all the elements in our Alert Dialog
            alertDialog.setView(view);
            alertDialog.show();
        } catch (Exception e) {
            Log.e(TAG, "showDialog: an Exception has occurred ", e);
        }
    }
}
