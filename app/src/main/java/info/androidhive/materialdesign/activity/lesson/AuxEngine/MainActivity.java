package info.androidhive.materialdesign.activity.lesson.AuxEngine;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import java.util.Locale;

import info.androidhive.materialdesign.R;
import info.androidhive.materialdesign.activity.AuxEngine_ViewPagerAdapter;
import info.androidhive.materialdesign.activity.LessonList;
import info.androidhive.materialdesign.activity.SlidingTabLayout;
import info.androidhive.materialdesign.sqldatabase.DatabaseHelper;

/**
 * Created by leo-pc on 1/4/2016.
 */
public class MainActivity extends AppCompatActivity {

    // Declaring Your View and Variables

    Toolbar toolbar;
    ViewPager pager;
    AuxEngine_ViewPagerAdapter adapter;
    SlidingTabLayout tabs;
    CharSequence Titles[]={
            "Slide 1","Slide 2","Slide 3","Slide 4","Slide 5","Slide 6","Slide 7","Slide 8","Slide 9","Slide 10",
            "Test"};
    int Numboftabs = 10;

    private TextToSpeech tts;
    String sound;

    DatabaseHelper databaseHelper;
    DatabaseHelper db = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_aux_engine);

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
        adapter =  new AuxEngine_ViewPagerAdapter(getSupportFragmentManager(),Titles,Numboftabs);

        // Assigning ViewPager View and setting the adapter
        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(adapter);

        // Assiging the Sliding Tab Layout View
        //tabs = (SlidingTabLayout) findViewById(R.id.tabs);
        //tabs.setDistributeEvenly(true); // To make the Tabs Fixed set this true, This makes the tabs Space Evenly in Available width

        // Setting Custom Color for the Scroll bar indicator of the Tab View
       /* tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(R.color.textWhite);
            }
        });*/

        // Setting the ViewPager For the SlidingTabsLayout
        //tabs.setViewPager(pager);

        String topic = getIntent().getStringExtra("topic");

        if (topic.equalsIgnoreCase("AuxEngine")) {

            pager.setCurrentItem(0);
        } else {

            if (topic.equalsIgnoreCase("Hazards and Safety precautions") || topic.equalsIgnoreCase("AuxEngine")) {
                pager.setCurrentItem(2);
            } else if (topic.equalsIgnoreCase("Start and Stop routines") || topic.equalsIgnoreCase("AuxEngine")) {
                pager.setCurrentItem(3);
            } else if (topic.equalsIgnoreCase("Auto Stop") || topic.equalsIgnoreCase("AuxEngine")) {
                pager.setCurrentItem(7);
            } else if (topic.equalsIgnoreCase("Manual Stop") || topic.equalsIgnoreCase("AuxEngine")) { // Aux Engine
                pager.setCurrentItem(6);
            } else if (topic.equalsIgnoreCase("Auxiliary Engine") || topic.equalsIgnoreCase("AuxEngine")) { // Aux Engine
                pager.setCurrentItem(0);
            } else if (topic.equalsIgnoreCase("Hazards") || topic.equalsIgnoreCase("AuxEngine")) { // Aux Engine
                pager.setCurrentItem(2);
            } else if (topic.equalsIgnoreCase("Fire Hazards") || topic.equalsIgnoreCase("AuxEngine")) { // Aux Engine
                pager.setCurrentItem(6);
            } else if (topic.equalsIgnoreCase("Electrical hazards") || topic.equalsIgnoreCase("AuxEngine")) { // Aux Engine
                pager.setCurrentItem(7);
            } else if (topic.equalsIgnoreCase("Thermal hazards") || topic.equalsIgnoreCase("AuxEngine")) { // Aux Engine
                pager.setCurrentItem(3);
            } else if (topic.equalsIgnoreCase("Noise hazards") || topic.equalsIgnoreCase("AuxEngine")) { // Aux Engine
                pager.setCurrentItem(3);
            } else if (topic.equalsIgnoreCase("Operation Surveillance") || topic.equalsIgnoreCase("AuxEngine")) { // Aux Engine
                pager.setCurrentItem(3);
            } else if (topic.equalsIgnoreCase("Fuel Oil System") || topic.equalsIgnoreCase("AuxEngine")) { // Aux Engine
                pager.setCurrentItem(4);
            } else if (topic.equalsIgnoreCase("Lubricating Oil System") || topic.equalsIgnoreCase("AuxEngine")) { // Aux Engine
                pager.setCurrentItem(4);
            } else if (topic.equalsIgnoreCase("Cool Water Leakage") || topic.equalsIgnoreCase("AuxEngine")) { // Aux Engine
                pager.setCurrentItem(6);
            } else if (topic.equalsIgnoreCase("Assessment")) {
                pager.setCurrentItem(9);
            }
        }

        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                String content = "";

                if (position == 0) {

                    if ("On".equalsIgnoreCase(sound)) {

                        content = getResources().getString(R.string.lesson2_title);
                    } else if ("Off".equalsIgnoreCase(sound)) {

                        tts.stop();
                    }
                } else if (position == 1) {

                    if ("On".equalsIgnoreCase(sound)) {

                        content = getResources().getString(R.string.lesson2_page2);
                    } else if ("Off".equalsIgnoreCase(sound)) {

                        tts.stop();
                    }
                } else if (position == 2) {

                    if ("On".equalsIgnoreCase(sound)) {

                        content = getResources().getString(R.string.lesson2_page3);
                    } else if ("Off".equalsIgnoreCase(sound)) {

                        tts.stop();
                    }
                } else if (position == 3) {

                    if ("On".equalsIgnoreCase(sound)) {

                        content = getResources().getString(R.string.lesson2_page4);
                    } else if ("Off".equalsIgnoreCase(sound)) {

                        tts.stop();
                    }
                } else if (position == 4) {

                    if ("On".equalsIgnoreCase(sound)) {

                        content = getResources().getString(R.string.lesson2_page5);
                    } else if ("Off".equalsIgnoreCase(sound)) {

                        tts.stop();
                    }
                } else if (position == 5) {

                    if ("On".equalsIgnoreCase(sound)) {

                        content = getResources().getString(R.string.lesson2_page6);
                    } else if ("Off".equalsIgnoreCase(sound)) {

                        tts.stop();
                    }
                } else if (position == 6) {

                    if ("On".equalsIgnoreCase(sound)) {

                        content = getResources().getString(R.string.lesson2_page7);
                    } else if ("Off".equalsIgnoreCase(sound)) {

                        tts.stop();
                    }
                } else if (position == 7) {

                    if ("On".equalsIgnoreCase(sound)) {

                        content = getResources().getString(R.string.lesson2_page8);
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
