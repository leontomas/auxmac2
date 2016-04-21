package info.androidhive.materialdesign.activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import info.androidhive.materialdesign.R;
import info.androidhive.materialdesign.model.Question;
import info.androidhive.materialdesign.model.Score;
import info.androidhive.materialdesign.sqldatabase.DatabaseHelper;

/**
 * Created on 2/21/2016.
 */
public class ScoreBoard extends Activity {

    DatabaseHelper dbHelper;
    DatabaseHelper db = new DatabaseHelper(this);

    List<Score> scoreList;
    Score score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_score);

        scoreList = this.getScoreList();

        ArrayList<Score> arrayScore = new ArrayList<Score>();
        final ScoreAdapter adapter = new ScoreAdapter(this, arrayScore);

        final ListView listView = (ListView) findViewById(R.id.score_list);

        adapter.addAll(scoreList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                score = adapter.getItem(position);
                showScoreInfo(score.getType(), score.getName(), score.getSubject(), score.getScore(), score.getDatetaken());
            }
        });
    }

    private void showScoreInfo(String type, String player, String lesson, int score, String datetaken) {

        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setIcon(R.drawable.icon_information);
        alertDialogBuilder.setTitle("Score Information");
        alertDialogBuilder.setMessage(
                "Category: " + type + "\n" +
                        "Player: " + player + "\n" +
                        "Lesson: " + lesson + "\n" +
                        "Score: " + score + "\n" +
                        "Date Taken: " + datetaken);

        alertDialogBuilder.setPositiveButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {


            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    public List<Score> getScoreList() {

        List<Score> scoreList = new ArrayList<Score>();

        String query = "select * from " + DatabaseHelper.TBL_SCORE;
        db.dbase = db.getWritableDatabase();
        Cursor cursor = db.dbase.rawQuery(query, null);

        if (cursor!=null) {
            if (cursor.moveToFirst()) {
                do {
                    Score score = new Score();
                    score.setType(cursor.getString(1));
                    score.setName(cursor.getString(2));
                    score.setSubject(cursor.getString(3));
                    score.setScore(cursor.getInt(4));
                    score.setDatetaken(cursor.getString(5));

                    scoreList.add(score);
                } while (cursor.moveToNext());
            }
        }

        return scoreList;
    }

    @Override
    public void onBackPressed() {

        Intent i = new Intent(ScoreBoard.this, MainActivity.class);
        startActivity(i);
        finish();
    }
}
