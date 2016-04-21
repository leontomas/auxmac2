package info.androidhive.materialdesign.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import info.androidhive.materialdesign.R;

/**
 * Created on 2/21/2016.
 */
public class About extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_about);
    }

    @Override
    public void onBackPressed() {

        Intent i = new Intent(About.this, MainActivity.class);
        startActivity(i);
        finish();
    }
}
