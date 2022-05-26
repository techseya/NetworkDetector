package lk.techseya.networkdetector;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        NetworkDetector.Detector(this,MainActivity.this,"Searching for Network","Network connection not found...");
    }
}