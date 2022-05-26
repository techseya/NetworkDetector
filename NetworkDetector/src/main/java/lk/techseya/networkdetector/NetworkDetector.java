package lk.techseya.networkdetector;

import static com.google.android.material.resources.MaterialResources.getDrawable;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import com.google.android.material.theme.overlay.MaterialThemeOverlay;

public class NetworkDetector {
    @SuppressLint("RestrictedApi")
    public static void Detector(Context context, Activity activity, String title, String message){
        ConnectivityManager manager=(ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo anetwork=manager.getActiveNetworkInfo();
        ProgressDialog progress = new ProgressDialog(activity);
        if (null==anetwork){
            progress.setTitle(title);
            progress.setIcon(R.drawable.wifi);
            progress.setMessage(message);
            progress.setCancelable(false);
            progress.show();
        }else {
            Toast.makeText(context, "Connected via "+anetwork.getTypeName(), Toast.LENGTH_SHORT).show();
        }

    }




}
