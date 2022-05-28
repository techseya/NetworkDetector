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
        @SuppressLint({"RestrictedApi", "UseCompatLoadingForDrawables"})
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
    public static void ProgressDetector(Context context,Activity activity,String title,String message){
        ConnectivityManager manager=(ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo anetwork=manager.getActiveNetworkInfo();
        ProgressDialog progress = new ProgressDialog(activity);
        if (null==anetwork){
            progress.setTitle(title);
            progress.setMessage(message);
            Sprite doubleBounce = new WanderingCubes();
            progress.setIndeterminateDrawable(doubleBounce);
            progress.setCancelable(false);
            progress.show();
            if (manager.isActiveNetworkMetered()){
                progress.dismiss();
            }
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }




}
