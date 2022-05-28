package lk.techseya.networkdetector;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.WanderingCubes;
import com.github.ybq.android.spinkit.style.Wave;




public class NetworkDetector extends Activity {
    @SuppressLint({"RestrictedApi", "UseCompatLoadingForDrawables"})
    public static void Detector(Context context, String title, String message){
        ConnectivityManager manager=(ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo anetwork=manager.getActiveNetworkInfo();
        if (null==anetwork){
            Dialog dialog = new Dialog(context);
            dialog.setContentView(R.layout.bg2);
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            dialog.getWindow().setBackgroundDrawableResource(R.drawable.background);
            dialog.setCancelable(false);
            ProgressBar progressBar = dialog.findViewById(R.id.spin_kit);
            Sprite doubleBounce = new Wave();
            progressBar.setIndeterminateDrawable(doubleBounce);
            TextView ttitle=dialog.findViewById(R.id.title);
            TextView tmsg=dialog.findViewById(R.id.message);
            Button ok=dialog.findViewById(R.id.btn_okay);
            Button cancel=dialog.findViewById(R.id.btn_cancel);
            ttitle.setText(title);
            tmsg.setText(message);
            ok.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                        context.startActivity(new Intent(android.provider.Settings.Panel.ACTION_INTERNET_CONNECTIVITY));
                    }
                }
            });
            cancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    System.exit(0);
                }
            });
            dialog.show();


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
            progress.setCancelable(false);
            Sprite doubleBounce = new WanderingCubes();
            progress.setIndeterminateDrawable(doubleBounce);
            progress.show();
            
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
