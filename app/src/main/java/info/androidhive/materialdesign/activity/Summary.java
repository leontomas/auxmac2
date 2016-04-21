package info.androidhive.materialdesign.activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import info.androidhive.materialdesign.R;
import info.androidhive.materialdesign.model.TestSummary;
import info.androidhive.materialdesign.sqldatabase.DatabaseHelper;

/**
 * Created on 2/21/2016.
 */
public class Summary extends Activity implements View.OnClickListener {

    DatabaseHelper dbHelper;
    DatabaseHelper db = new DatabaseHelper(this);

    List<TestSummary> summaryList;
    TestSummary summary;

    private TextView txtScore, txtBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_test_summary);

        int score = 0;

        txtScore = (TextView) findViewById(R.id.txtScore);
        txtBack = (TextView) findViewById(R.id.txtBack);

        txtScore.setOnClickListener(this);
        txtBack.setOnClickListener(this);

        summaryList = this.getSummaryList();

        ArrayList<TestSummary> arraySummary = new ArrayList<TestSummary>();
        final QuestionAdapter adapter = new QuestionAdapter(this, arraySummary);

        final ListView listView = (ListView) findViewById(R.id.list_view);

        adapter.addAll(summaryList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                summary = adapter.getItem(position);
                showInfo(summary.getAnswer(), summary.getAdditionalInfo());
            }
        });
    }

    private void showInfo(String answer, String additionalInfo) {

        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setIcon(R.drawable.icon_information);
        alertDialogBuilder.setTitle("Additional Info");
        alertDialogBuilder.setMessage("Answer: " + answer + "\n\n" +
                "Additional Info: " + additionalInfo);

        alertDialogBuilder.setPositiveButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {


            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    public List<TestSummary> getSummaryList() {

        List<TestSummary> summaryList = new ArrayList<TestSummary>();

        String query = "select * from " + DatabaseHelper.TBL_SUMMARY;
        db.dbase = db.getWritableDatabase();
        Cursor cursor = db.dbase.rawQuery(query, null);

        if (cursor!=null) {
            if (cursor.moveToFirst()) {
                do {
                    TestSummary summary = new TestSummary();
                    summary.setQuestion(cursor.getString(1));
                    summary.setAnswer(cursor.getString(2));
                    summary.setAdditionalInfo(cursor.getString(3));
                    summary.setStatus(cursor.getString(4));

                    summaryList.add(summary);
                } while (cursor.moveToNext());
            }
        }

        return summaryList;
    }

    @Override
    public void onClick(View v) {

        dbHelper = new DatabaseHelper(Summary.this);

        String lesson = getIntent().getStringExtra("lesson");
        Intent i = null;

        if (v.getId() == R.id.txtScore) {

            dbHelper.open();
            dbHelper.delete();

            Intent intent = new Intent(Summary.this, ScoreBoard.class);
            startActivity(intent);
            finish();

            /*dbHelper.open();
            dbHelper.delete();

            if (lesson.equalsIgnoreCase("Aux Boiler")) {

                i = new Intent(Summary.this, info.androidhive.materialdesign.activity.lesson.AuxBoilerOperation.MainActivity.class);
                startActivity(i);
                finish();
            } else if (lesson.equalsIgnoreCase("Aux Engine")) {

                i = new Intent(Summary.this, info.androidhive.materialdesign.activity.lesson.AuxEngine.MainActivity.class);
                startActivity(i);
                finish();
            } else if (lesson.equalsIgnoreCase("Fresh Water Generator")) {

                i = new Intent(Summary.this, info.androidhive.materialdesign.activity.lesson.FreshWaterGenerator.MainActivity.class);
                startActivity(i);
                finish();
            } else if (lesson.equalsIgnoreCase("Operation of Generators")) {

                i = new Intent(Summary.this, info.androidhive.materialdesign.activity.lesson.OperationOfGenerator.MainActivity.class);
                startActivity(i);
                finish();
            } else if (lesson.equalsIgnoreCase("Steering Gear")) {

                i = new Intent(Summary.this, info.androidhive.materialdesign.activity.lesson.SteeringGear.MainActivity.class);
                startActivity(i);
                finish();
            } else {

                i = new Intent(Summary.this, LessonList.class);
                startActivity(i);
                finish();
            }*/
        } else if (v.getId() == R.id.txtBack) {

            dbHelper.open();
            dbHelper.delete();

            i = new Intent(Summary.this, LessonList.class);
            startActivity(i);
            finish();
        }
    }

    @Override
    public void onBackPressed() {

    }

    /*dialog.dismiss();
    finish();
    Intent i = new Intent(Summary.this, Quiz.class);
    i.putExtra("lesson", lesson.toString());
    startActivity(i);*/

}
