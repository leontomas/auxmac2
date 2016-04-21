package info.androidhive.materialdesign.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import info.androidhive.materialdesign.R;
import info.androidhive.materialdesign.activity.Simulation.FWGStart;
import info.androidhive.materialdesign.activity.Simulation.FWGStop;

public class MainActivity extends AppCompatActivity implements View.OnClickListener /*AppCompatActivity implements FragmentDrawer.FragmentDrawerListener*/ {

    /*private static String TAG = MainActivity.class.getSimpleName();

    private Toolbar mToolbar;
    private FragmentDrawer drawerFragment;*/

    ImageView btnLesson, btnModel, btnSimulation, btnVideo, btnDictionary, btnScore, btnAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main_activity);

        /*mToolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        drawerFragment = (FragmentDrawer)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), mToolbar);
        drawerFragment.setDrawerListener(this);

        // display the first navigation drawer view on app launch
        displayView(0);*/

        btnLesson = (ImageView) findViewById(R.id.btnLesson);
        btnLesson.setOnClickListener(this);

        btnModel = (ImageView) findViewById(R.id.btnModel);
        btnModel.setOnClickListener(this);

        btnSimulation = (ImageView) findViewById(R.id.btn_simulation);
        btnSimulation.setOnClickListener(this);

        btnVideo = (ImageView) findViewById(R.id.btnVideo);
        btnVideo.setOnClickListener(this);

        btnDictionary = (ImageView) findViewById(R.id.btnDictionary);
        btnDictionary.setOnClickListener(this);

        btnScore = (ImageView) findViewById(R.id.btn_score);
        btnScore.setOnClickListener(this);

        btnAbout = (ImageView) findViewById(R.id.btnAbout);
        btnAbout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Intent i = null;

        if (v.getId() == R.id.btnLesson) {

            i = new Intent(MainActivity.this, LessonList.class);
            startActivity(i);
            finish();
        } else if (v.getId() == R.id.btnModel) {

            i = new Intent(MainActivity.this, Model.class);
            startActivity(i);
            finish();
        } else if (v.getId() == R.id.btn_simulation) {

            showSimulation();
        } else if (v.getId() == R.id.btnDictionary) {

            i = new Intent(MainActivity.this, DictionaryActivity.class);
            startActivity(i);
            finish();
        } else if (v.getId() == R.id.btnVideo) {

            i = new Intent(MainActivity.this, Video.class);
            startActivity(i);
            finish();
        } else if (v.getId() == R.id.btn_score) {

            i = new Intent(MainActivity.this, ScoreBoard.class);
            startActivity(i);
            finish();
        } else if (v.getId() == R.id.btnAbout) {

            i = new Intent(MainActivity.this, About.class);
            startActivity(i);
            finish();
        }

    }

    private void showSimulation() {

        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setIcon(R.drawable.icon);
        alertDialogBuilder.setTitle("Alfa Laval Fresh Water Generator");
        alertDialogBuilder.setMessage("");

        alertDialogBuilder.setPositiveButton("Start Procedure", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {

                Intent i = new Intent(MainActivity.this, Instruction.class);
                i.putExtra("tag", "Start");
                startActivity(i);
//                finish();
            }
        });
        alertDialogBuilder.setNegativeButton("Stop Procedure", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {

                Intent i = new Intent(MainActivity.this, Instruction.class);
                i.putExtra("tag", "Stop");
                startActivity(i);
//                finish();
            }
        });

//        alertDialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//
//                dialog.dismiss();
//            }
//        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    private void quit() {
        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setIcon(R.drawable.icon);
        alertDialogBuilder.setTitle("Quit Application");
        alertDialogBuilder.setMessage("Do you want to quit application?");

        alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int arg1) {

                finish();
            }
        });

        alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int arg1) {

                dialog.dismiss();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    @Override
    public void onBackPressed() {

        quit();
    }
}

