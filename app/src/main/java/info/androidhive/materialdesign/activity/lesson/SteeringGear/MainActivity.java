package info.androidhive.materialdesign.activity.lesson.SteeringGear;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.Locale;

import info.androidhive.materialdesign.R;
import info.androidhive.materialdesign.activity.LessonList;
import info.androidhive.materialdesign.activity.PlayVideo;
import info.androidhive.materialdesign.activity.SlidingTabLayout;
import info.androidhive.materialdesign.activity.SteeringGear_ViewPagerAdapter;
import info.androidhive.materialdesign.sqldatabase.DatabaseHelper;

/**
 * Created on 1/3/2016.
 */
public class MainActivity extends AppCompatActivity {

    // Declaring Your View and Variables

    Toolbar toolbar;
    ViewPager pager;
    SteeringGear_ViewPagerAdapter adapter;
    SlidingTabLayout tabs;
    CharSequence Titles[]={
            "Slide 1","Slide 2","Slide 3","Slide 4","Slide 5","Slide 6","Slide 7", "Slide 8", "Slide 9", "Slide 10",
            "Slide 11","Slide 12","Slide 13","Slide 14","Slide 15","Slide 16","Slide 17", "Slide 18", "Slide 19", "Slide 20",
            "Test"
    };
    int Numboftabs = 21;

    FloatingActionButton fabVideo;
    private TextToSpeech tts;
    String sound;

    DatabaseHelper databaseHelper;
    DatabaseHelper db = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_steering_gear);

        String query = "select * from " + DatabaseHelper.TBL_SOUND;
        db.dbase = db.getWritableDatabase();
        Cursor cursor = db.dbase.rawQuery(query, null);

        if(cursor!=null) {
            if(cursor.moveToFirst()) {
                do{
                    sound = cursor.getString(1);
                }while(cursor.moveToNext());
            }
        }

        tts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status!=TextToSpeech.ERROR) {
                    tts.setLanguage(Locale.UK);
                }
            }
        });

        // Creating The Toolbar and setting it as the Toolbar for the activity

        /*toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/

        // Creating The ViewPagerAdapter and Passing Fragment Manager, Titles fot the Tabs and Number Of Tabs.
        adapter =  new SteeringGear_ViewPagerAdapter(getSupportFragmentManager(),Titles,Numboftabs);

        // Assigning ViewPager View and setting the adapter
        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(adapter);

        // Assiging the Sliding Tab Layout View
        /*tabs = (SlidingTabLayout) findViewById(R.id.tabs);
        tabs.setDistributeEvenly(true); // To make the Tabs Fixed set this true, This makes the tabs Space Evenly in Available width

        // Setting Custom Color for the Scroll bar indicator of the Tab View
        tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(R.color.textWhite);
            }
        });

        // Setting the ViewPager For the SlidingTabsLayout
        tabs.setViewPager(pager);*/

        String topic = getIntent().getStringExtra("topic");

        if (topic.equalsIgnoreCase("SteeringGear")) {

            pager.setCurrentItem(0);
        } else {

            if (topic.equalsIgnoreCase("Rudder Arrangement")) {
                pager.setCurrentItem(2);
            } else if (topic.equalsIgnoreCase("Actuator working principles")) {
                pager.setCurrentItem(8);
            } else if (topic.equalsIgnoreCase("Actuator main parts")) {
                pager.setCurrentItem(10);
            } else if (topic.equalsIgnoreCase("Steering and control system")) {
                pager.setCurrentItem(18);
            } else if (topic.equalsIgnoreCase("Steering Gear")) {
                pager.setCurrentItem(0);
            } else if (topic.equalsIgnoreCase("Torque")) {
                pager.setCurrentItem(2);
            } else if (topic.equalsIgnoreCase("Flap Rudder")) {
                pager.setCurrentItem(2);
            } else if (topic.equalsIgnoreCase("Half Spade Rudder")) {
                pager.setCurrentItem(2);
            } else if (topic.equalsIgnoreCase("Standard Model")) {
                pager.setCurrentItem(3);
            } else if (topic.equalsIgnoreCase("Ram")) {
                pager.setCurrentItem(3);
            } else if (topic.equalsIgnoreCase("Actuator")) {
                pager.setCurrentItem(3);
            } else if (topic.equalsIgnoreCase("Engine Control room")) {
                pager.setCurrentItem(4);
            } else if (topic.equalsIgnoreCase("Wheel House")) {
                pager.setCurrentItem(4);
            } else if (topic.equalsIgnoreCase("Steering gear compartment")) {
                pager.setCurrentItem(4);
            } else if (topic.equalsIgnoreCase("Steering modes")) {
                pager.setCurrentItem(4);
            } else if (topic.equalsIgnoreCase("Assessment")) {
                pager.setCurrentItem(20);
            }
        }

        fabVideo = (FloatingActionButton) findViewById(R.id.fabVideo);
        fabVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String title = "SteeringGear";
                String credit = "Steering Gear(Animated Marine Workshop) by Nur Amira Yahja";

                Intent i = new Intent(MainActivity.this, PlayVideo.class);
                i.putExtra("title", title);
                i.putExtra("credit", credit);
                startActivity(i);
                finish();
            }
        });

        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                String content = "";

                if (position == 0) {

                    if ("On".equalsIgnoreCase(sound)) {

                        content = getResources().getString(R.string.lesson5_title);
                    } else if ("Off".equalsIgnoreCase(sound)) {

                        tts.stop();
                    }
                } else if (position == 1) {

                    if ("On".equalsIgnoreCase(sound)) {

                        content = getResources().getString(R.string.lesson5_page1);
                    } else if ("Off".equalsIgnoreCase(sound)) {

                        tts.stop();
                    }
                } else if (position == 2) {

                    if ("On".equalsIgnoreCase(sound)) {

                        content = getResources().getString(R.string.lesson5_page2);
                    } else if ("Off".equalsIgnoreCase(sound)) {

                        tts.stop();
                    }
                } else if (position == 3) {

                    if ("On".equalsIgnoreCase(sound)) {

                        content = getResources().getString(R.string.lesson5_page3);
                    } else if ("Off".equalsIgnoreCase(sound)) {

                        tts.stop();
                    }
                } else if (position == 4) {

                    if ("On".equalsIgnoreCase(sound)) {

                        content = getResources().getString(R.string.lesson5_page4);
                    } else if ("Off".equalsIgnoreCase(sound)) {

                        tts.stop();
                    }
                }

                tts.speak(content, TextToSpeech.QUEUE_FLUSH, null);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        tts.shutdown();
    }

    @Override
    public void onBackPressed() {

        Intent i = new Intent(MainActivity.this, LessonList.class);
        startActivity(i);
        finish();
    }
}
