package info.androidhive.materialdesign.activity.lesson.AuxBoilerOperation;

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
import info.androidhive.materialdesign.activity.ViewPagerAdapter;
import info.androidhive.materialdesign.sqldatabase.DatabaseHelper;

/**
 * Created by leo-pc on 1/4/2016.
 */
public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    ViewPager pager;
    ViewPagerAdapter adapter;
    SlidingTabLayout tabs;
    final CharSequence Titles[]={
            "Slide 1","Slide 2","Slide 3","Slide 4","Slide 5","Slide 6","Slide 7","Slide 8","Slide 9","Slide 10",
            "Test"};
    int Numboftabs = 11;

    FloatingActionButton fabVideo;
    private TextToSpeech tts;
    String sound;

    DatabaseHelper databaseHelper;
    DatabaseHelper db = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_aux_boiler_operation);

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

        // Creating The ViewPagerAdapter and Passing Fragment Manager, Titles for the Tabs and Number Of Tabs.
        adapter =  new ViewPagerAdapter(getSupportFragmentManager(),Titles,Numboftabs);

        // Assigning ViewPager View and setting the adapter
        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(adapter);

        // Assigning the Sliding Tab Layout View
        //tabs = (SlidingTabLayout) findViewById(R.id.tabs);
        //tabs.setDistributeEvenly(true); // To make the Tabs Fixed set this true, This makes the tabs Space Evenly in Available width

        // Setting Custom Color for the Scroll bar indicator of the Tab View
        /*tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(R.color.textWhite);
            }
        });*/

        // Setting the ViewPager For the SlidingTabsLayout
        //tabs.setViewPager(pager);

        String topic = getIntent().getStringExtra("topic");

        if (topic.equalsIgnoreCase("AuxBoiler")) {

            pager.setCurrentItem(0);
        } else {

            if (topic.equalsIgnoreCase("Steam Plant Diagram")) {
                pager.setCurrentItem(2);
            } else if (topic.equalsIgnoreCase("Dual Pressure Boiler")) {
                pager.setCurrentItem(4);
            } else if (topic.equalsIgnoreCase("Turbine")) {
                pager.setCurrentItem(4);
            } else if (topic.equalsIgnoreCase("Condenser")) {
                pager.setCurrentItem(5);
            } else if (topic.equalsIgnoreCase("Feed Water Pump")) {
                pager.setCurrentItem(5);
            } else if (topic.equalsIgnoreCase("Main Equipment")) {
                pager.setCurrentItem(3);
            } else if (topic.equalsIgnoreCase("Boiler Design")) {
                pager.setCurrentItem(6);
            } else if (topic.equalsIgnoreCase("Auxiliary Boiler Plant")) {
                pager.setCurrentItem(0);
            } else if (topic.equalsIgnoreCase("Typical System Plant Diagram")) {
                pager.setCurrentItem(2);
            } else if (topic.equalsIgnoreCase("Main parts")) {
                pager.setCurrentItem(3);
            } else if (topic.equalsIgnoreCase("Steam")) {
                pager.setCurrentItem(3);
            } else if (topic.equalsIgnoreCase("Assessment")) {
                pager.setCurrentItem(10);
            }
        }

        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                String content = "";

                if (position == 0) {

                    if ("On".equalsIgnoreCase(sound)) {

                        content = getResources().getString(R.string.lesson1_title);
                    } else if ("Off".equalsIgnoreCase(sound)) {

                        tts.stop();
                    }
                } else if (position == 1) {

                    if ("On".equalsIgnoreCase(sound)) {

                        content = getResources().getString(R.string.lesson1_page1);
                    } else if ("Off".equalsIgnoreCase(sound)) {

                        tts.stop();
                    }
                } else if (position == 3) {

                    if ("On".equalsIgnoreCase(sound)) {

                        content = getResources().getString(R.string.lesson1_page5);
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

        fabVideo = (FloatingActionButton) findViewById(R.id.fabVideo);
        fabVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String title = "AuxBoiler";
                String credit = "Explanation of Boiler Feed Water & its treatment by Magic Marks";

                Intent i = new Intent(MainActivity.this, PlayVideo.class);
                i.putExtra("title", title);
                i.putExtra("credit", credit);
                startActivity(i);
                finish();
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

        if (tts != null) {
            tts.shutdown();
        }
    }

    @Override
    public void onBackPressed() {

        Intent i = new Intent(MainActivity.this, LessonList.class);
        startActivity(i);
        finish();
    }
}
