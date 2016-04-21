package info.androidhive.materialdesign.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import info.androidhive.materialdesign.R;

/**
 * Created on 1/2/2016.
 */
public class PlayVideo extends Activity {

    private TextView txtCredits;
    private VideoView mVideoView;
    private String path = "";
    String title, txtcredit, sCredit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_play_video);

        title = getIntent().getStringExtra("title");
        sCredit = getIntent().getStringExtra("credit");

        txtCredits = (TextView) findViewById(R.id.txtCredits);
        mVideoView = (VideoView) findViewById(R.id.videoView);

        if (title.equalsIgnoreCase("explanation_of_boiler_feed_water")) {
            path = "android.resource://" + getPackageName() + "/" + R.raw.explanation_of_boiler_feed_water;
            txtcredit = sCredit;

        } else if (title.equalsIgnoreCase("feed_water_pump")) {
            path = "android.resource://" + getPackageName() + "/" + R.raw.feed_water_pump;
            txtcredit = sCredit;

        } else if (title.equalsIgnoreCase("fresh_water_generator")) {
            path = "android.resource://" + getPackageName() + "/" + R.raw.fresh_water_generator;
            txtcredit = sCredit;

        } else if (title.equalsIgnoreCase("steam_turbine_operation")) {
            path = "android.resource://" + getPackageName() + "/" + R.raw.steam_turbine_operation;
            txtcredit = sCredit;

        } else if (title.equalsIgnoreCase("steering_gear")) {
            path = "android.resource://" + getPackageName() + "/" + R.raw.steering_gear;
            txtcredit = sCredit;

        } else if (title.equalsIgnoreCase("AuxBoiler")) {
            path = "android.resource://" + getPackageName() + "/" + R.raw.steam_turbine_operation;
            txtcredit = sCredit;

        } else if (title.equalsIgnoreCase("FreshWaterGen")) {
            path = "android.resource://" + getPackageName() + "/" + R.raw.fresh_water_generator;
            txtcredit = sCredit;

        } else if (title.equalsIgnoreCase("OperationOfGen")) {
            path = "android.resource://" + getPackageName() + "/" + R.raw.principle_of_operation_of_a_dc_generator;
            txtcredit = sCredit;

        } else if (title.equalsIgnoreCase("SteeringGear")) {
            path = "android.resource://" + getPackageName() + "/" + R.raw.steering_gear;
            txtcredit = sCredit;
        }

        txtCredits.setText(txtcredit);
        mVideoView.setVideoPath(path);

        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(mVideoView);
        mVideoView.setMediaController(mediaController);

        mVideoView.start();
    }

    @Override
    public void onBackPressed() {

        Intent i;

        if (title.equalsIgnoreCase("AuxBoiler")) {

            i = new Intent(PlayVideo.this, info.androidhive.materialdesign.activity.lesson.AuxBoilerOperation.MainActivity.class);
            i.putExtra("topic", "AuxBoiler");
        } else if (title.equalsIgnoreCase("FreshWaterGen")) {

            i = new Intent(PlayVideo.this, info.androidhive.materialdesign.activity.lesson.FreshWaterGenerator.MainActivity.class);
            i.putExtra("topic", "FreshWaterGen");
        } else if (title.equalsIgnoreCase("OperationOfGen")) {

            i = new Intent(PlayVideo.this, info.androidhive.materialdesign.activity.lesson.OperationOfGenerator.MainActivity.class);
            i.putExtra("topic", "OperationOfGen");
        } else if (title.equalsIgnoreCase("SteeringGear")) {

            i = new Intent(PlayVideo.this, info.androidhive.materialdesign.activity.lesson.SteeringGear.MainActivity.class);
            i.putExtra("topic", "OperationOfGen");
        } else {

            i = new Intent(PlayVideo.this, Video.class);
        }

        startActivity(i);
        finish();
    }
}
