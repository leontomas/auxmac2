package info.androidhive.materialdesign.activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
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
import info.androidhive.materialdesign.model.TestImageSummary;
import info.androidhive.materialdesign.sqldatabase.DatabaseHelper;

/**
 * Created on 2/21/2016.
 */
public class ImageSummary extends Activity implements View.OnClickListener {

    DatabaseHelper dbHelper;
    DatabaseHelper db = new DatabaseHelper(this);

    List<TestImageSummary> imageSummaryList;
    TestImageSummary imageSummary;

    private TextView txtScore, txtBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_test_image_summary);

        int score = 0;

        txtScore = (TextView) findViewById(R.id.txtScore);
        txtBack = (TextView) findViewById(R.id.txtBack);

        txtScore.setOnClickListener(this);
        txtBack.setOnClickListener(this);

        imageSummaryList = this.getImageSummaryList();

        ArrayList<TestImageSummary> arrayImageSummary = new ArrayList<TestImageSummary>();
        final QuestionImageAdapter adapter = new QuestionImageAdapter(this, arrayImageSummary);

        final ListView listView = (ListView) findViewById(R.id.list_image_view);

        adapter.addAll(imageSummaryList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                imageSummary = adapter.getItem(position);
                showInfo(imageSummary.getId(), imageSummary.getAnswer());
            }
        });
    }

    private void showInfo(int id, String answer) {

        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setIcon(R.drawable.icon_information);
        alertDialogBuilder.setTitle("Additional Info");
        alertDialogBuilder.setMessage("Answer: " + answer);

        final ImageView imgView = new ImageView(ImageSummary.this);

        alertDialogBuilder.setView(imgView);

        int pics[] = {
                R.drawable.img_identify_image1, R.drawable.img_identify_image2, R.drawable.img_identify_image3,
                R.drawable.img_identify_image4, R.drawable.img_identify_image5, R.drawable.img_identify_image6,
                R.drawable.img_identify_image7
        };

        imgView.setImageResource(pics[id]);

        alertDialogBuilder.setPositiveButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {


            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    public List<TestImageSummary> getImageSummaryList() {

        List<TestImageSummary> imageSummaryList = new ArrayList<TestImageSummary>();

        String query = "select * from " + DatabaseHelper.TBL_IMAGE_SUMMARY;
        db.dbase = db.getWritableDatabase();
        Cursor cursor = db.dbase.rawQuery(query, null);

        if (cursor!=null) {
            if (cursor.moveToFirst()) {
                do {
                    TestImageSummary imageSummary = new TestImageSummary();
                    imageSummary.setId(cursor.getInt(0));
                    imageSummary.setAnswer(cursor.getString(1));
                    imageSummary.setStatus(cursor.getString(2));

                    imageSummaryList.add(imageSummary);
                } while (cursor.moveToNext());
            }
        }

        return imageSummaryList;
    }

    @Override
    public void onClick(View v) {

        dbHelper = new DatabaseHelper(ImageSummary.this);

        String lesson = getIntent().getStringExtra("lesson");
        Intent i = null;

        if (v.getId() == R.id.txtScore) {

            dbHelper.open();
            dbHelper.deleteImage();

            Intent intent = new Intent(ImageSummary.this, ScoreBoard.class);
            startActivity(intent);
            finish();

        } else if (v.getId() == R.id.txtBack) {

            dbHelper.open();
            dbHelper.deleteImage();

            i = new Intent(ImageSummary.this, LessonList.class);
            startActivity(i);
            finish();
        }
    }

    @Override
    public void onBackPressed() {

    }
}
