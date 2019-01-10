package MapUtilities;

import android.Manifest;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.erick.adooproject.R;

public abstract class PermissionUtils {

    private Context context;
    public PermissionUtils(Context context){
        this.context = context;
    }

    /**Requests the fine location permission. If rationale with an additional explanation should
     * be shown to the user, displays a dialog that triggers the request                    **/
    public static void requestPermission(AppCompatActivity activity, int requestId,
                                         String permission, boolean finishActivity){
        if(ActivityCompat.shouldShowRequestPermissionRationale(activity, permission)){
            //Display a dialog with rational
            PermissionUtils.RationaleDialog.newInstance(requestId, finishActivity).show(activity.getFragmentManager(), "dialog");
        } else {
            //Location permission hasn't been granted yet, request it
            ActivityCompat.requestPermissions(activity, new String[]{permission}, requestId);
        }
    }

    /**Checks if the result contains{@link PackageManager#PERMISSION_GRANTED} result
     * for a permission from a runtime permissions request**/
    public static boolean isPermissionGranted(String[] grantPermissions, int[] grantResults,
                                              String permission){
        for(int i = 0; i < grantPermissions.length; i++){
            if(permission.equals(grantPermissions[i])){
                return grantResults[i] == PackageManager.PERMISSION_GRANTED;
            }
        }
        return false;
    }

    /**A dialog  that displays a permission denied message**/
    public static class PermissionDeniedDialog extends DialogFragment{
        private static final String ARGUMENT_FINISH_ACTIVITY = "finish";
        private boolean mfinishActivity = false;

        /**Creates a new instance of this dialog and optionally
         * finishes the calling Activity when the Ok button is clicked**/
        public static PermissionDeniedDialog newInstance(boolean finishActivity){
            Bundle arguments = new Bundle();
            arguments.putBoolean(ARGUMENT_FINISH_ACTIVITY, finishActivity);
            PermissionDeniedDialog dialog = new PermissionDeniedDialog();
            dialog.setArguments(arguments);
            return dialog;
        }

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState){
            mfinishActivity = getArguments().getBoolean(ARGUMENT_FINISH_ACTIVITY);

            return new AlertDialog.Builder(getActivity())
                    .setMessage(R.string.location_permission_denied)
                    .setPositiveButton(android.R.string.ok, null)
                    .create();
        }

        @Override
        public void onDismiss(DialogInterface dialog){
            super.onDismiss(dialog);
            if(mfinishActivity){
                Toast.makeText(getActivity(), R.string.permission_required_toast,
                        Toast.LENGTH_SHORT).show();
                getActivity().finish();
            }
        }
    }

    public static class RationaleDialog extends DialogFragment{
        private static final String ARGUMENT_PERMISSION_REQUEST_CODE = "requestCode";
        private static final String ARGUMENT_FINISH_ACTIVITY = "finish";
        private boolean mfinishActivity = false;

        /**
         * Creates a new instance of a dialog displaying the rationale for the use of the location
         * permission.
         * <p>
         * The permission is requested after clicking 'ok'.
         *
         * @param requestCode    Id of the request that is used to request the permission. It is
         *                       returned to the
         *                       {@link android.support.v4.app.ActivityCompat.OnRequestPermissionsResultCallback}.
         * @param finishActivity Whether the calling Activity should be finished if the dialog is
         *                       cancelled.
         */
        public static RationaleDialog newInstance(int requestCode, boolean finishActivity){
            Bundle arguments = new Bundle();
            arguments.putInt(ARGUMENT_PERMISSION_REQUEST_CODE, requestCode);
            arguments.putBoolean(ARGUMENT_FINISH_ACTIVITY, finishActivity);
            RationaleDialog dialog = new RationaleDialog();
            dialog.setArguments(arguments);
            return dialog;
        }

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState){
            Bundle arguments = getArguments();
            final int requestCode = arguments.getInt(ARGUMENT_PERMISSION_REQUEST_CODE);
            mfinishActivity = arguments.getBoolean(ARGUMENT_FINISH_ACTIVITY);

            return new AlertDialog.Builder(getActivity())
                    .setMessage(R.string.permission_rationale_location)
                    .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //After click on Ok, request the permission
                            ActivityCompat.requestPermissions(getActivity(),
                                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                                    requestCode);
                            //Do not finish the activity while requesting permission
                            mfinishActivity = false;
                        }
                    })
                    .setNegativeButton(android.R.string.cancel, null)
                    .create();
        }

        @Override
        public void onDismiss(DialogInterface dialog){
            super.onDismiss(dialog);
            if(mfinishActivity){
                Toast.makeText(getActivity(),
                        R.string.permission_required_toast,
                        Toast.LENGTH_SHORT).show();
                getActivity().finish();
            }
        }
    }


}
