package info.androidhive.materialdesign.activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Switch;

import java.util.ArrayList;
import java.util.HashMap;

import info.androidhive.materialdesign.R;
import info.androidhive.materialdesign.sqldatabase.DatabaseHelper;

public class LessonList extends Activity {

    private AutoCompleteTextView txtSearch;
    private Switch switchSpeaker;
    private ListView lv;

    String value, sound;
    int id;

    ArrayAdapter<String> adapter, topicAdapter;
    ArrayList<HashMap<String, String>> lessonList;
    ArrayList<HashMap<String, String>> wordList;

    DatabaseHelper databaseHelper;
    DatabaseHelper db = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lesson_list_layout);

        // list of lesson
        String lesson[] = {
                "Aux Boiler Operation",
                "Aux Engine",
                "Fresh Water Generator",
                "Operation of Generator",
                "Steering Gear"};

        // list of topics
        String[] topic = getResources().getStringArray(R.array.topicList);

        txtSearch = (AutoCompleteTextView) findViewById(R.id.txtSearch);
        switchSpeaker = (Switch) findViewById(R.id.switchSpeaker);
        lv = (ListView) findViewById(R.id.lesson_list);

        String query = "select * from " + DatabaseHelper.TBL_SOUND;
        db.dbase = db.getWritableDatabase();
        Cursor cursor = db.dbase.rawQuery(query, null);

        if(cursor!=null) {
            if(cursor.moveToFirst()) {
                do{
                    id = cursor.getInt(0);
                    sound = cursor.getString(1);
                }while(cursor.moveToNext());
            }
        }

        if ("On".equalsIgnoreCase(sound)) {

            switchSpeaker.setChecked(true);
        } else if ("Off".equalsIgnoreCase(sound)) {

            switchSpeaker.setChecked(false);
        }

        topicAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, topic);

        txtSearch.setAdapter(topicAdapter);
        txtSearch.setThreshold(1);

        txtSearch.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = null;
                String keyTopic = "";
                String topic = topicAdapter.getItem(position);

                if (topic.equalsIgnoreCase("Steam Plant Diagram")) {

                    keyTopic = topic;

                    i = new Intent(LessonList.this, info.androidhive.materialdesign.activity.lesson.AuxBoilerOperation.MainActivity.class);
                    i.putExtra("topic", keyTopic);
                } else if (topic.equalsIgnoreCase("Dual Pressure Boiler")) {

                    keyTopic = topic;

                    i = new Intent(LessonList.this, info.androidhive.materialdesign.activity.lesson.AuxBoilerOperation.MainActivity.class);
                    i.putExtra("topic", keyTopic);
                } else if (topic.equalsIgnoreCase("Turbine")) {

                    keyTopic = topic;

                    i = new Intent(LessonList.this, info.androidhive.materialdesign.activity.lesson.AuxBoilerOperation.MainActivity.class);
                    i.putExtra("topic", keyTopic);
                } else if (topic.equalsIgnoreCase("Condenser")) {

                    keyTopic = topic;

                    i = new Intent(LessonList.this, info.androidhive.materialdesign.activity.lesson.AuxBoilerOperation.MainActivity.class);
                    i.putExtra("topic", keyTopic);
                } else if (topic.equalsIgnoreCase("Feed Water Pump")) {

                    keyTopic = topic;

                    i = new Intent(LessonList.this, info.androidhive.materialdesign.activity.lesson.AuxBoilerOperation.MainActivity.class);
                    i.putExtra("topic", keyTopic);
                } else if (topic.equalsIgnoreCase("Main Equipment")) {

                    keyTopic = topic;

                    i = new Intent(LessonList.this, info.androidhive.materialdesign.activity.lesson.AuxBoilerOperation.MainActivity.class);
                    i.putExtra("topic", keyTopic);
                } else if (topic.equalsIgnoreCase("Boiler Design")) {

                    keyTopic = topic;

                    i = new Intent(LessonList.this, info.androidhive.materialdesign.activity.lesson.AuxBoilerOperation.MainActivity.class);
                    i.putExtra("topic", keyTopic);
                } else if (topic.equalsIgnoreCase("Auxiliary Boiler Plant")) {

                    keyTopic = topic;

                    i = new Intent(LessonList.this, info.androidhive.materialdesign.activity.lesson.AuxBoilerOperation.MainActivity.class);
                    i.putExtra("topic", keyTopic);
                } else if (topic.equalsIgnoreCase("Typical System Plant Diagram")) {

                    keyTopic = topic;

                    i = new Intent(LessonList.this, info.androidhive.materialdesign.activity.lesson.AuxBoilerOperation.MainActivity.class);
                    i.putExtra("topic", keyTopic);
                } else if (topic.equalsIgnoreCase("Main parts")) {

                    keyTopic = topic;

                    i = new Intent(LessonList.this, info.androidhive.materialdesign.activity.lesson.AuxBoilerOperation.MainActivity.class);
                    i.putExtra("topic", keyTopic);
                } else if (topic.equalsIgnoreCase("Steam")) {

                    keyTopic = topic;

                    i = new Intent(LessonList.this, info.androidhive.materialdesign.activity.lesson.AuxBoilerOperation.MainActivity.class);
                    i.putExtra("topic", keyTopic);
                } else if (topic.equalsIgnoreCase("Hazards and Safety precautions")) {

                    keyTopic = topic;

                    i = new Intent(LessonList.this, info.androidhive.materialdesign.activity.lesson.AuxEngine.MainActivity.class);
                    i.putExtra("topic", keyTopic);
                } else if (topic.equalsIgnoreCase("Start and Stop routines")) {

                    keyTopic = topic;

                    i = new Intent(LessonList.this, info.androidhive.materialdesign.activity.lesson.AuxEngine.MainActivity.class);
                    i.putExtra("topic", keyTopic);
                } else if (topic.equalsIgnoreCase("Auto Stop")) {

                    keyTopic = topic;

                    i = new Intent(LessonList.this, info.androidhive.materialdesign.activity.lesson.AuxEngine.MainActivity.class);
                    i.putExtra("topic", keyTopic);
                } else if (topic.equalsIgnoreCase("Manual Stop")) {

                    keyTopic = topic;

                    i = new Intent(LessonList.this, info.androidhive.materialdesign.activity.lesson.AuxEngine.MainActivity.class);
                    i.putExtra("topic", keyTopic);
                } else if (topic.equalsIgnoreCase("Auxiliary Engine")) {

                    keyTopic = topic;

                    i = new Intent(LessonList.this, info.androidhive.materialdesign.activity.lesson.AuxEngine.MainActivity.class);
                    i.putExtra("topic", keyTopic);
                } else if (topic.equalsIgnoreCase("Hazards")) {

                    keyTopic = topic;

                    i = new Intent(LessonList.this, info.androidhive.materialdesign.activity.lesson.AuxEngine.MainActivity.class);
                    i.putExtra("topic", keyTopic);
                } else if (topic.equalsIgnoreCase("Fire Hazards")) {

                    keyTopic = topic;

                    i = new Intent(LessonList.this, info.androidhive.materialdesign.activity.lesson.AuxEngine.MainActivity.class);
                    i.putExtra("topic", keyTopic);
                } else if (topic.equalsIgnoreCase("Electrical hazards")) {

                    keyTopic = topic;

                    i = new Intent(LessonList.this, info.androidhive.materialdesign.activity.lesson.AuxEngine.MainActivity.class);
                    i.putExtra("topic", keyTopic);
                } else if (topic.equalsIgnoreCase("Thermal hazards")) {

                    keyTopic = topic;

                    i = new Intent(LessonList.this, info.androidhive.materialdesign.activity.lesson.AuxEngine.MainActivity.class);
                    i.putExtra("topic", keyTopic);
                } else if (topic.equalsIgnoreCase("Noise hazards")) {

                    keyTopic = topic;

                    i = new Intent(LessonList.this, info.androidhive.materialdesign.activity.lesson.AuxEngine.MainActivity.class);
                    i.putExtra("topic", keyTopic);
                } else if (topic.equalsIgnoreCase("Operation Surveillance")) {

                    keyTopic = topic;

                    i = new Intent(LessonList.this, info.androidhive.materialdesign.activity.lesson.AuxEngine.MainActivity.class);
                    i.putExtra("topic", keyTopic);
                } else if (topic.equalsIgnoreCase("Fuel Oil System")) {

                    keyTopic = topic;

                    i = new Intent(LessonList.this, info.androidhive.materialdesign.activity.lesson.AuxEngine.MainActivity.class);
                    i.putExtra("topic", keyTopic);
                } else if (topic.equalsIgnoreCase("Lubricating Oil System")) {

                    keyTopic = topic;

                    i = new Intent(LessonList.this, info.androidhive.materialdesign.activity.lesson.AuxEngine.MainActivity.class);
                    i.putExtra("topic", keyTopic);
                } else if (topic.equalsIgnoreCase("Cool Water Leakage")) {

                    keyTopic = topic;

                    i = new Intent(LessonList.this, info.androidhive.materialdesign.activity.lesson.AuxEngine.MainActivity.class);
                    i.putExtra("topic", keyTopic);
                } else if (topic.equalsIgnoreCase("Working principles")) {

                    keyTopic = topic;

                    i = new Intent(LessonList.this, info.androidhive.materialdesign.activity.lesson.FreshWaterGenerator.MainActivity.class);
                    i.putExtra("topic", keyTopic);
                } else if (topic.equalsIgnoreCase("Installation")) {

                    keyTopic = topic;

                    i = new Intent(LessonList.this, info.androidhive.materialdesign.activity.lesson.FreshWaterGenerator.MainActivity.class);
                    i.putExtra("topic", keyTopic);
                } else if (topic.equalsIgnoreCase("Basic Equipment")) {

                    keyTopic = topic;

                    i = new Intent(LessonList.this, info.androidhive.materialdesign.activity.lesson.FreshWaterGenerator.MainActivity.class);
                    i.putExtra("topic", keyTopic);
                } else if (topic.equalsIgnoreCase("Additional Equipment")) {

                    keyTopic = topic;

                    i = new Intent(LessonList.this, info.androidhive.materialdesign.activity.lesson.FreshWaterGenerator.MainActivity.class);
                    i.putExtra("topic", keyTopic);
                } else if (topic.equalsIgnoreCase("Starting Procedure")) {

                    keyTopic = topic;

                    i = new Intent(LessonList.this, info.androidhive.materialdesign.activity.lesson.FreshWaterGenerator.MainActivity.class);
                    i.putExtra("topic", keyTopic);
                } else if (topic.equalsIgnoreCase("Stopping Procedure")) {

                    keyTopic = topic;

                    i = new Intent(LessonList.this, info.androidhive.materialdesign.activity.lesson.FreshWaterGenerator.MainActivity.class);
                    i.putExtra("topic", keyTopic);
                } else if (topic.equalsIgnoreCase("Fresh Water Generator")) {

                    keyTopic = topic;

                    i = new Intent(LessonList.this, info.androidhive.materialdesign.activity.lesson.FreshWaterGenerator.MainActivity.class);
                    i.putExtra("topic", keyTopic);
                } else if (topic.equalsIgnoreCase("Applications")) {

                    keyTopic = topic;

                    i = new Intent(LessonList.this, info.androidhive.materialdesign.activity.lesson.FreshWaterGenerator.MainActivity.class);
                    i.putExtra("topic", keyTopic);
                } else if (topic.equalsIgnoreCase("Features")) {

                    keyTopic = topic;

                    i = new Intent(LessonList.this, info.androidhive.materialdesign.activity.lesson.FreshWaterGenerator.MainActivity.class);
                    i.putExtra("topic", keyTopic);
                } else if (topic.equalsIgnoreCase("Optional Equipment")) {

                    keyTopic = topic;

                    i = new Intent(LessonList.this, info.androidhive.materialdesign.activity.lesson.FreshWaterGenerator.MainActivity.class);
                    i.putExtra("topic", keyTopic);
                } else if (topic.equalsIgnoreCase("Service Support")) {

                    keyTopic = topic;

                    i = new Intent(LessonList.this, info.androidhive.materialdesign.activity.lesson.FreshWaterGenerator.MainActivity.class);
                    i.putExtra("topic", keyTopic);
                } else if (topic.equalsIgnoreCase("Synchronous Generator")) {

                    keyTopic = topic;

                    i = new Intent(LessonList.this, info.androidhive.materialdesign.activity.lesson.OperationOfGenerator.MainActivity.class);
                    i.putExtra("topic", keyTopic);
                } else if (topic.equalsIgnoreCase("Voltage Regulation")) {

                    keyTopic = topic;

                    i = new Intent(LessonList.this, info.androidhive.materialdesign.activity.lesson.OperationOfGenerator.MainActivity.class);
                    i.putExtra("topic", keyTopic);
                } else if (topic.equalsIgnoreCase("Safety and Basic precautions")) {

                    keyTopic = topic;

                    i = new Intent(LessonList.this, info.androidhive.materialdesign.activity.lesson.OperationOfGenerator.MainActivity.class);
                    i.putExtra("topic", keyTopic);
                } else if (topic.equalsIgnoreCase("Operation of Generator")) {

                    keyTopic = topic;

                    i = new Intent(LessonList.this, info.androidhive.materialdesign.activity.lesson.OperationOfGenerator.MainActivity.class);
                    i.putExtra("topic", keyTopic);
                } else if (topic.equalsIgnoreCase("Flux")) {

                    keyTopic = topic;

                    i = new Intent(LessonList.this, info.androidhive.materialdesign.activity.lesson.OperationOfGenerator.MainActivity.class);
                    i.putExtra("topic", keyTopic);
                } else if (topic.equalsIgnoreCase("AC Synchonous generator")) {

                    keyTopic = topic;

                    i = new Intent(LessonList.this, info.androidhive.materialdesign.activity.lesson.OperationOfGenerator.MainActivity.class);
                    i.putExtra("topic", keyTopic);
                } else if (topic.equalsIgnoreCase("Diesel Engine")) {

                    keyTopic = topic;

                    i = new Intent(LessonList.this, info.androidhive.materialdesign.activity.lesson.OperationOfGenerator.MainActivity.class);
                    i.putExtra("topic", keyTopic);
                } else if (topic.equalsIgnoreCase("Windings")) {

                    keyTopic = topic;

                    i = new Intent(LessonList.this, info.androidhive.materialdesign.activity.lesson.OperationOfGenerator.MainActivity.class);
                    i.putExtra("topic", keyTopic);
                } else if (topic.equalsIgnoreCase("Armature Reaction")) {

                    keyTopic = topic;

                    i = new Intent(LessonList.this, info.androidhive.materialdesign.activity.lesson.OperationOfGenerator.MainActivity.class);
                    i.putExtra("topic", keyTopic);
                } else if (topic.equalsIgnoreCase("Rotor Position")) {

                    keyTopic = topic;

                    i = new Intent(LessonList.this, info.androidhive.materialdesign.activity.lesson.OperationOfGenerator.MainActivity.class);
                    i.putExtra("topic", keyTopic);
                } else if (topic.equalsIgnoreCase("Basic Precaution")) {

                    keyTopic = topic;

                    i = new Intent(LessonList.this, info.androidhive.materialdesign.activity.lesson.OperationOfGenerator.MainActivity.class);
                    i.putExtra("topic", keyTopic);
                } else if (topic.equalsIgnoreCase("Electric Shock")) {

                    keyTopic = topic;

                    i = new Intent(LessonList.this, info.androidhive.materialdesign.activity.lesson.OperationOfGenerator.MainActivity.class);
                    i.putExtra("topic", keyTopic);
                } else if (topic.equalsIgnoreCase("General Electric Maintenance")) {

                    keyTopic = topic;

                    i = new Intent(LessonList.this, info.androidhive.materialdesign.activity.lesson.OperationOfGenerator.MainActivity.class);
                    i.putExtra("topic", keyTopic);
                } else if (topic.equalsIgnoreCase("Rudder Arrangement")) {

                    keyTopic = topic;

                    i = new Intent(LessonList.this, info.androidhive.materialdesign.activity.lesson.SteeringGear.MainActivity.class);
                    i.putExtra("topic", keyTopic);
                } else if (topic.equalsIgnoreCase("Actuator working principles")) {

                    keyTopic = topic;

                    i = new Intent(LessonList.this, info.androidhive.materialdesign.activity.lesson.SteeringGear.MainActivity.class);
                    i.putExtra("topic", keyTopic);
                } else if (topic.equalsIgnoreCase("Actuator main parts")) {

                    keyTopic = topic;

                    i = new Intent(LessonList.this, info.androidhive.materialdesign.activity.lesson.SteeringGear.MainActivity.class);
                    i.putExtra("topic", keyTopic);
                } else if (topic.equalsIgnoreCase("Steering and control system")) {

                    keyTopic = topic;

                    i = new Intent(LessonList.this, info.androidhive.materialdesign.activity.lesson.SteeringGear.MainActivity.class);
                    i.putExtra("topic", keyTopic);
                } else if (topic.equalsIgnoreCase("Steering Gear")) {

                    keyTopic = topic;

                    i = new Intent(LessonList.this, info.androidhive.materialdesign.activity.lesson.SteeringGear.MainActivity.class);
                    i.putExtra("topic", keyTopic);
                } else if (topic.equalsIgnoreCase("Torque")) {

                    keyTopic = topic;

                    i = new Intent(LessonList.this, info.androidhive.materialdesign.activity.lesson.SteeringGear.MainActivity.class);
                    i.putExtra("topic", keyTopic);
                } else if (topic.equalsIgnoreCase("Flap Rudder")) {

                    keyTopic = topic;

                    i = new Intent(LessonList.this, info.androidhive.materialdesign.activity.lesson.SteeringGear.MainActivity.class);
                    i.putExtra("topic", keyTopic);
                } else if (topic.equalsIgnoreCase("Half Spade Rudder")) {

                    keyTopic = topic;

                    i = new Intent(LessonList.this, info.androidhive.materialdesign.activity.lesson.SteeringGear.MainActivity.class);
                    i.putExtra("topic", keyTopic);
                } else if (topic.equalsIgnoreCase("Standard Model")) {

                    keyTopic = topic;

                    i = new Intent(LessonList.this, info.androidhive.materialdesign.activity.lesson.SteeringGear.MainActivity.class);
                    i.putExtra("topic", keyTopic);
                } else if (topic.equalsIgnoreCase("Ram")) {

                    keyTopic = topic;

                    i = new Intent(LessonList.this, info.androidhive.materialdesign.activity.lesson.SteeringGear.MainActivity.class);
                    i.putExtra("topic", keyTopic);
                } else if (topic.equalsIgnoreCase("Actuator")) {

                    keyTopic = topic;

                    i = new Intent(LessonList.this, info.androidhive.materialdesign.activity.lesson.SteeringGear.MainActivity.class);
                    i.putExtra("topic", keyTopic);
                } else if (topic.equalsIgnoreCase("Engine Control room")) {

                    keyTopic = topic;

                    i = new Intent(LessonList.this, info.androidhive.materialdesign.activity.lesson.SteeringGear.MainActivity.class);
                    i.putExtra("topic", keyTopic);
                } else if (topic.equalsIgnoreCase("Wheel House")) {

                    keyTopic = topic;

                    i = new Intent(LessonList.this, info.androidhive.materialdesign.activity.lesson.SteeringGear.MainActivity.class);
                    i.putExtra("topic", keyTopic);
                } else if (topic.equalsIgnoreCase("Steering gear compartment")) {

                    keyTopic = topic;

                    i = new Intent(LessonList.this, info.androidhive.materialdesign.activity.lesson.SteeringGear.MainActivity.class);
                    i.putExtra("topic", keyTopic);
                } else if (topic.equalsIgnoreCase("Steering modes")) {

                    keyTopic = topic;

                    i = new Intent(LessonList.this, info.androidhive.materialdesign.activity.lesson.SteeringGear.MainActivity.class);
                    i.putExtra("topic", keyTopic);
                }

                startActivity(i);
                finish();
            }
        });

        switchSpeaker.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                databaseHelper = new DatabaseHelper(LessonList.this);
                databaseHelper.open();

                if (sound.equalsIgnoreCase("On")) {

                    long id = databaseHelper.updateSound("Off");
                } else if (sound.equalsIgnoreCase("Off")) {

                    long id = databaseHelper.updateSound("On");
                }
            }
        });

        adapter = new ArrayAdapter<String>(this, R.layout.lesson_list, R.id.lesson, lesson);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                String lesson = "";
                Intent i;

                switch (position) {
                    case 0:
                        lesson = "AuxBoiler";
                        lessonChoice(lesson);
                        /*i = new Intent(LessonList.this, info.androidhive.materialdesign.activity.lesson.AuxBoilerOperation.MainActivity.class);
                        i.putExtra("topic", "AuxBoiler");
                        startActivity(i);
                        finish();*/
                        break;
                    case 1:
                        lesson = "AuxEngine";
                        lessonChoice(lesson);
                        /*i = new Intent(LessonList.this, info.androidhive.materialdesign.activity.lesson.AuxEngine.MainActivity.class);
                        i.putExtra("topic", "AuxEngine");
                        startActivity(i);
                        finish();*/
                        break;
                    case 2:
                        lesson = "FreshWaterGen";
                        lessonChoice(lesson);
                        /*i = new Intent(LessonList.this, info.androidhive.materialdesign.activity.lesson.FreshWaterGenerator.MainActivity.class);
                        i.putExtra("topic", "FreshWaterGen");
                        startActivity(i);
                        finish();*/
                        break;
                    case 3:
                        lesson = "OperationOfGen";
                        lessonChoice(lesson);
                        /*i = new Intent(LessonList.this, info.androidhive.materialdesign.activity.lesson.OperationOfGenerator.MainActivity.class);
                        i.putExtra("topic", "OperationOfGen");
                        startActivity(i);
                        finish();*/
                        break;
                    case 4:
                        lesson = "SteeringGear";
                        lessonChoice(lesson);
                        /* = new Intent(LessonList.this, info.androidhive.materialdesign.activity.lesson.SteeringGear.MainActivity.class);
                        i.putExtra("topic", "SteeringGear");
                        startActivity(i);
                        finish();*/
                        break;
                    default:
                        break;
                }
            }

        });

    }

    private void lessonChoice(final String lesson) {

        String choiceList[] = {"Take Lesson", "Take Quiz"};

        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setIcon(R.drawable.icon);
        alertDialogBuilder.setTitle("AuxMac2");
        alertDialogBuilder.setMessage("");

        ListView list = new ListView(this);
        list.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, choiceList));

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = null;

                switch (position) {
                    case 0:
                        if (lesson.equalsIgnoreCase("AuxBoiler")) {
                            i = new Intent(LessonList.this, info.androidhive.materialdesign.activity.lesson.AuxBoilerOperation.MainActivity.class);
                            i.putExtra("topic", "AuxBoiler");
                            startActivity(i);
                            finish();
                        } else if (lesson.equalsIgnoreCase("AuxEngine")) {
                            i = new Intent(LessonList.this, info.androidhive.materialdesign.activity.lesson.AuxEngine.MainActivity.class);
                            i.putExtra("topic", "AuxEngine");
                            startActivity(i);
                            finish();
                        } else if (lesson.equalsIgnoreCase("FreshWaterGen")) {
                            i = new Intent(LessonList.this, info.androidhive.materialdesign.activity.lesson.FreshWaterGenerator.MainActivity.class);
                            i.putExtra("topic", "FreshWaterGen");
                            startActivity(i);
                            finish();
                        } else if (lesson.equalsIgnoreCase("OperationOfGen")) {
                            i = new Intent(LessonList.this, info.androidhive.materialdesign.activity.lesson.OperationOfGenerator.MainActivity.class);
                            i.putExtra("topic", "OperationOfGen");
                            startActivity(i);
                            finish();
                        } else if (lesson.equalsIgnoreCase("SteeringGear")) {
                            i = new Intent(LessonList.this, info.androidhive.materialdesign.activity.lesson.SteeringGear.MainActivity.class);
                            i.putExtra("topic", "SteeringGear");
                            startActivity(i);
                            finish();
                        }
                        break;
                    case 1:
                        if (lesson.equalsIgnoreCase("AuxBoiler")) {
                            i = new Intent(LessonList.this, info.androidhive.materialdesign.activity.lesson.AuxBoilerOperation.MainActivity.class);
                            i.putExtra("topic", "Assessment");
                            startActivity(i);
                            finish();
                        } else if (lesson.equalsIgnoreCase("AuxEngine")) {
                            i = new Intent(LessonList.this, info.androidhive.materialdesign.activity.lesson.AuxEngine.MainActivity.class);
                            i.putExtra("topic", "Assessment");
                            startActivity(i);
                            finish();
                        } else if (lesson.equalsIgnoreCase("FreshWaterGen")) {
                            i = new Intent(LessonList.this, info.androidhive.materialdesign.activity.lesson.FreshWaterGenerator.MainActivity.class);
                            i.putExtra("topic", "Assessment");
                            startActivity(i);
                            finish();
                        } else if (lesson.equalsIgnoreCase("OperationOfGen")) {
                            i = new Intent(LessonList.this, info.androidhive.materialdesign.activity.lesson.OperationOfGenerator.MainActivity.class);
                            i.putExtra("topic", "Assessment");
                            startActivity(i);
                            finish();
                        } else if (lesson.equalsIgnoreCase("SteeringGear")) {
                            i = new Intent(LessonList.this, info.androidhive.materialdesign.activity.lesson.SteeringGear.MainActivity.class);
                            i.putExtra("topic", "Assessment");
                            startActivity(i);
                            finish();
                        }
                        break;
                    default:
                        break;
                }
            }
        });

        alertDialogBuilder.setView(list);

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    @Override
    public void onBackPressed() {

        Intent i = new Intent(LessonList.this, MainActivity.class);
        startActivity(i);
        finish();
    }
}
