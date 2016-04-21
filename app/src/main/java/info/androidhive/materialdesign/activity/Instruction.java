package info.androidhive.materialdesign.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import info.androidhive.materialdesign.R;
import info.androidhive.materialdesign.activity.Simulation.FWGStart;
import info.androidhive.materialdesign.activity.Simulation.FWGStop;

/**
 * Created on 2/21/2016.
 */
public class Instruction extends AppCompatActivity {

    private ImageView imgStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_instruction);

        final String tag = getIntent().getStringExtra("tag");

        imgStart = (ImageView) findViewById(R.id.imgStart);

        if (tag.equalsIgnoreCase("Start")) {
            imgStart.setImageResource(R.drawable.start);
        } else if (tag.equalsIgnoreCase("Stop")) {
            imgStart.setImageResource(R.drawable.stop);
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                imgStart.setVisibility(View.GONE);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        if (tag.equalsIgnoreCase("Start")) {
                            Intent i = new Intent(Instruction.this, FWGStart.class);
                            startActivity(i);
                            finish();
                        } else if (tag.equalsIgnoreCase("Stop")) {
                            Intent i = new Intent(Instruction.this, FWGStop.class);
                            startActivity(i);
                            finish();
                        }
                    }
                }, 10000);
            }
        }, 5000);



    }

    @Override
    public void onBackPressed() {

    }
}
