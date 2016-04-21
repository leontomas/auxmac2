package info.androidhive.materialdesign.activity.lesson.OperationOfGenerator;

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
import info.androidhive.materialdesign.activity.OperationOfGenerator_ViewPagerAdapter;
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
    OperationOfGenerator_ViewPagerAdapter adapter;
    SlidingTabLayout tabs;
    CharSequence Titles[]={
            "Slide 1","Slide 2","Slide 3","Slide 4","Slide 5","Slide 6","Slide 7","Slide 8","Slide 9","Slide 10",
            "Slide 11","Slide 12","Slide 13","Slide 14","Slide 15","Slide 16","Slide 17","Slide 18","Slide 19","Slide 20",
            "Slide 21","Slide 22","Slide 23","test"
    };
    int Numboftabs = 24;

    FloatingActionButton fabVideo;
    private TextToSpeech tts;
    String sound;

    DatabaseHelper databaseHelper;
    DatabaseHelper db = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_operation_of_generator);

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
        adapter =  new OperationOfGenerator_ViewPagerAdapter(getSupportFragmentManager(),Titles,Numboftabs);

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

        if (topic.equalsIgnoreCase("OperationOfGen")) {

            pager.setCurrentItem(0);
        } else {

            if (topic.equalsIgnoreCase("Synchronous Generator")) {
                pager.setCurrentItem(2);
            } else if (topic.equalsIgnoreCase("Voltage Regulation")) {
                pager.setCurrentItem(10);
            } else if (topic.equalsIgnoreCase("Safety and Basic precautions")) {
                pager.setCurrentItem(20);
            } else if (topic.equalsIgnoreCase("Operation of Generator")) {
                pager.setCurrentItem(0);
            } else if (topic.equalsIgnoreCase("Flux")) {
                pager.setCurrentItem(2);
            } else if (topic.equalsIgnoreCase("AC Synchonous generator")) {
                pager.setCurrentItem(2);
            } else if (topic.equalsIgnoreCase("Diesel Engine")) {
                pager.setCurrentItem(6);
            } else if (topic.equalsIgnoreCase("Windings")) {
                pager.setCurrentItem(7);
            } else if (topic.equalsIgnoreCase("Armature Reaction")) {
                pager.setCurrentItem(7);
            } else if (topic.equalsIgnoreCase("Rotor Position")) {
                pager.setCurrentItem(4);
            } else if (topic.equalsIgnoreCase("Basic Precaution")) {
                pager.setCurrentItem(20);
            } else if (topic.equalsIgnoreCase("Electric Shock")) {
                pager.setCurrentItem(20);
            } else if (topic.equalsIgnoreCase("General Electric Maintenance")) {
                pager.setCurrentItem(21);
            } else if (topic.equalsIgnoreCase("Assessment")) {
                pager.setCurrentItem(23);
            }
        }

        fabVideo = (FloatingActionButton) findViewById(R.id.fabVideo);
        fabVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String title = "OperationOfGen";
                String credit = "Principle of a DC Generator by Magic Marks";

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

                        content = getResources().getString(R.string.lesson4_page1);
                    } else if ("Off".equalsIgnoreCase(sound)) {

                        tts.stop();
                    }
                } else if (position == 1) {

                    if ("On".equalsIgnoreCase(sound)) {

                        content = getResources().getString(R.string.lesson4_page2);
                    } else if ("Off".equalsIgnoreCase(sound)) {

                        tts.stop();
                    }
                } else if (position == 2) {

                    if ("On".equalsIgnoreCase(sound)) {

                        content = getResources().getString(R.string.lesson4_page3);
                    } else if ("Off".equalsIgnoreCase(sound)) {

                        tts.stop();
                    }
                } else if (position == 3) {

                    if ("On".equalsIgnoreCase(sound)) {

                        content = getResources().getString(R.string.lesson4_page4);
                    } else if ("Off".equalsIgnoreCase(sound)) {

                        tts.stop();
                    }
                } else if (position == 4) {

                    if ("On".equalsIgnoreCase(sound)) {

                        content = getResources().getString(R.string.lesson4_page5);
                    } else if ("Off".equalsIgnoreCase(sound)) {

                        tts.stop();
                    }
                } else if (position == 10) {

                    if ("On".equalsIgnoreCase(sound)) {

                        content = getResources().getString(R.string.lesson4_page11);
                    } else if ("Off".equalsIgnoreCase(sound)) {

                        tts.stop();
                    }
                } else if (position == 11) {

                    if ("On".equalsIgnoreCase(sound)) {

                        content = getResources().getString(R.string.lesson4_page12);
                    } else if ("Off".equalsIgnoreCase(sound)) {

                        tts.stop();
                    }
                } else if (position == 20) {

                    if ("On".equalsIgnoreCase(sound)) {

                        content = getResources().getString(R.string.lesson4_page21);
                    } else if ("Off".equalsIgnoreCase(sound)) {

                        tts.stop();
                    }
                } else if (position == 21) {

                    if ("On".equalsIgnoreCase(sound)) {

                        content = getResources().getString(R.string.lesson4_page22);
                    } else if ("Off".equalsIgnoreCase(sound)) {

                        tts.stop();
                    }
                } else if (position == 22) {

                    if ("On".equalsIgnoreCase(sound)) {

                        content = getResources().getString(R.string.lesson4_page23);
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
