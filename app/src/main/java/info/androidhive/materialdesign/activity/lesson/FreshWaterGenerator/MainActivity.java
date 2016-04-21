package info.androidhive.materialdesign.activity.lesson.FreshWaterGenerator;

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
import info.androidhive.materialdesign.activity.FreshWaterGenerator_ViewPagerAdapter;
import info.androidhive.materialdesign.activity.LessonList;
import info.androidhive.materialdesign.activity.PlayVideo;
import info.androidhive.materialdesign.activity.SlidingTabLayout;
import info.androidhive.materialdesign.sqldatabase.DatabaseHelper;

/**
 * Created on 1/3/2016.
 */
public class MainActivity extends AppCompatActivity {

    // Declaring Your View and Variables

    Toolbar toolbar;
    ViewPager pager;
    FreshWaterGenerator_ViewPagerAdapter adapter;
    SlidingTabLayout tabs;
    CharSequence Titles[]={
            "Slide 1","Slide 2","Slide 3","Slide 4","Slide 5","Slide 6","Slide 7","Slide 8","Slide 9","Slide 10",
            "Slide 11","Slide 12","Slide 13","Slide 14","Slide 15","Slide 16","Slide 17","Slide 18","Slide 19","Slide 20",
            "Slide 21","Slide 22","Slide 23","Slide 24","Slide 25","Slide 26","Slide 27","Slide 28","Slide 29","Slide 30",
            "Slide 31","Slide 32","Slide 33","Slide 34","Slide 35","Slide 36","Slide 37","Slide 38","Slide 39","Slide 40",
            "Slide 41","Slide 42","Slide 43","Slide 44","Slide 45","Test"
    };
    int Numboftabs = 46;

    FloatingActionButton fabVideo;
    private TextToSpeech tts;
    String sound;

    DatabaseHelper databaseHelper;
    DatabaseHelper db = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_fresh_water_generator);

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
        adapter =  new FreshWaterGenerator_ViewPagerAdapter(getSupportFragmentManager(),Titles,Numboftabs);

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
        });*/

        // Setting the ViewPager For the SlidingTabsLayout
        //tabs.setViewPager(pager);

        String topic = getIntent().getStringExtra("topic");

        if (topic.equalsIgnoreCase("FreshWaterGen")) {

            pager.setCurrentItem(0);
        } else {

            if (topic.equalsIgnoreCase("Working principles") || topic.equalsIgnoreCase("FreshWaterGen")) {
                pager.setCurrentItem(2);
            } else if (topic.equalsIgnoreCase("Installation") || topic.equalsIgnoreCase("FreshWaterGen")) {
                pager.setCurrentItem(11);
            } else if (topic.equalsIgnoreCase("Basic Equipment") || topic.equalsIgnoreCase("FreshWaterGen")) {
                pager.setCurrentItem(13);
            } else if (topic.equalsIgnoreCase("Additional Equipment") || topic.equalsIgnoreCase("FreshWaterGen")) {
                pager.setCurrentItem(17);
            } else if (topic.equalsIgnoreCase("Starting Procedure") || topic.equalsIgnoreCase("FreshWaterGen")) {
                pager.setCurrentItem(33);
            } else if (topic.equalsIgnoreCase("Stopping Procedure") || topic.equalsIgnoreCase("FreshWaterGen")) { // Fresh Water Gen
                pager.setCurrentItem(40);
            } else if (topic.equalsIgnoreCase("Fresh Water Generator") || topic.equalsIgnoreCase("FreshWaterGen")) { // Fresh Water Gen
                pager.setCurrentItem(0);
            } else if (topic.equalsIgnoreCase("Applications") || topic.equalsIgnoreCase("FreshWaterGen")) { // Fresh Water Gen
                pager.setCurrentItem(2);
            } else if (topic.equalsIgnoreCase("Features") || topic.equalsIgnoreCase("FreshWaterGen")) { // Fresh Water Gen
                pager.setCurrentItem(2);
            } else if (topic.equalsIgnoreCase("Optional Equipment") || topic.equalsIgnoreCase("FreshWaterGen")) { // Fresh Water Gen
                pager.setCurrentItem(19);
            } else if (topic.equalsIgnoreCase("Service Support") || topic.equalsIgnoreCase("FreshWaterGen")) { // Fresh Water Gen
                pager.setCurrentItem(32);
            } else if (topic.equalsIgnoreCase("Assessment")) {
                pager.setCurrentItem(45);
            }
        }

        fabVideo = (FloatingActionButton) findViewById(R.id.fabVideo);
        fabVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String title = "FreshWaterGen";
                String credit = "Fresh Water Generator 3D2 by g534fde";

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

                        content = getResources().getString(R.string.lesson3_page1);
                    } else if ("Off".equalsIgnoreCase(sound)) {

                        tts.stop();
                    }
                } else if (position == 1) {

                    if ("On".equalsIgnoreCase(sound)) {

                        content = getResources().getString(R.string.lesson3_page2);
                    } else if ("Off".equalsIgnoreCase(sound)) {

                        tts.stop();
                    }
                } else if (position == 2) {

                    if ("On".equalsIgnoreCase(sound)) {

                        content = getResources().getString(R.string.lesson3_page3);
                    } else if ("Off".equalsIgnoreCase(sound)) {

                        tts.stop();
                    }
                } else if (position == 5) {

                    if ("On".equalsIgnoreCase(sound)) {

                        content = getResources().getString(R.string.lesson3_page6);
                    } else if ("Off".equalsIgnoreCase(sound)) {

                        tts.stop();
                    }
                } else if (position == 11) {

                    if ("On".equalsIgnoreCase(sound)) {

                        content = getResources().getString(R.string.lesson3_page12);
                    } else if ("Off".equalsIgnoreCase(sound)) {

                        tts.stop();
                    }
                } else if (position == 17) {

                    if ("On".equalsIgnoreCase(sound)) {

                        content = getResources().getString(R.string.lesson3_page18);
                    } else if ("Off".equalsIgnoreCase(sound)) {

                        tts.stop();
                    }
                } else if (position == 19) {

                    if ("On".equalsIgnoreCase(sound)) {

                        content = getResources().getString(R.string.lesson3_page20);
                    } else if ("Off".equalsIgnoreCase(sound)) {

                        tts.stop();
                    }
                } else if (position == 32) {

                    if ("On".equalsIgnoreCase(sound)) {

                        content = getResources().getString(R.string.lesson3_page33);
                    } else if ("Off".equalsIgnoreCase(sound)) {

                        tts.stop();
                    }
                } else if (position == 39) {

                    if ("On".equalsIgnoreCase(sound)) {

                        content = getResources().getString(R.string.lesson3_page40);
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
