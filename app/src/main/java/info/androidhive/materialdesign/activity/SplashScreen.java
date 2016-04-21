package info.androidhive.materialdesign.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import info.androidhive.materialdesign.R;

/**
 * Created on 2/21/2016.
 */
public class SplashScreen extends Activity {

    private static int TIMER = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_splash_screen);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent i = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        }, TIMER);
    }

    @Override
    public void onBackPressed() {
        /* do your code here */
    }
}
