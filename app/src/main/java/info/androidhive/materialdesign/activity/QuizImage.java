package info.androidhive.materialdesign.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import info.androidhive.materialdesign.R;
import info.androidhive.materialdesign.activity.Simulation.TouchImageView;
import info.androidhive.materialdesign.model.QuestionImage;
import info.androidhive.materialdesign.sqldatabase.DatabaseHelper;

/**
 * Created on 2/21/2016.
 */
public class QuizImage extends Activity implements View.OnClickListener {

    DatabaseHelper dbHelper;
    DatabaseHelper db = new DatabaseHelper(this);

    List<QuestionImage> questionImageList;
    int qid = 0;
    QuestionImage currentQ;

    private TouchImageView touchImageView;
    private TextView txtScore;
    private Button btnChoiceA, btnChoiceB, btnChoiceC;

    String message = "";
    int score = 0;
    int counter = 0;

    String sStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_quiz_images);

        final String type = getIntent().getStringExtra("type");

        touchImageView = (TouchImageView) findViewById(R.id.imgPhoto);
        txtScore = (TextView) findViewById(R.id.txtScore);
        btnChoiceA = (Button) findViewById(R.id.btnChoiceA);
        btnChoiceB = (Button) findViewById(R.id.btnChoiceB);
        btnChoiceC = (Button) findViewById(R.id.btnChoiceC);

        questionImageList = this.getQuestionImageList(type);
        Collections.shuffle(questionImageList);
        currentQ = questionImageList.get(qid);

        btnChoiceA.setOnClickListener(this);
        btnChoiceB.setOnClickListener(this);
        btnChoiceC.setOnClickListener(this);

        txtScore.setText("0");

        setQuestion();

        showInstruction();
    }

    private void showInstruction() {

        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setIcon(R.drawable.icon);
        alertDialogBuilder.setTitle("Assessment");
        alertDialogBuilder.setMessage("Identify the Images shown." +
                "\n\n" +
                "Choose from the choices of the correct answer for the images." +
                "\n" +
                "You can \"Zoom-in\" and \"Zoom-out\" to identify images clearly.");

        alertDialogBuilder.setPositiveButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int arg1) {

                dialog.dismiss();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    private void setQuestion() {

        int pics[] = {
                R.drawable.img_identify_image1, R.drawable.img_identify_image2, R.drawable.img_identify_image3,
                R.drawable.img_identify_image4, R.drawable.img_identify_image5, R.drawable.img_identify_image6,
                R.drawable.img_identify_image7
        };

        touchImageView.setImageResource(pics[currentQ.getId()]);;
        btnChoiceA.setText(currentQ.getChoicea());
        btnChoiceB.setText(currentQ.getChoiceb());
        btnChoiceC.setText(currentQ.getChoicec());
        qid++;
    }

    @Override
    public void onClick(View v) {

        final String lesson = getIntent().getStringExtra("lesson");

        dbHelper = new DatabaseHelper(QuizImage.this);
        dbHelper.open();

        if (v.getId() == R.id.btnChoiceA) {

            String sBtnChoiceA = btnChoiceA.getText().toString();

            if (currentQ.getAnswer().equalsIgnoreCase(sBtnChoiceA)) {
                score++;
                sStatus = "check";
                if (qid <= questionImageList.size() - 1) {
                    currentQ = questionImageList.get(qid);
                    setQuestion();

                    if (questionImageList.size() == qid) {

                    }
                }
            } else {
                sStatus = "cross";
                if (qid <= questionImageList.size() - 1) {
                    currentQ = questionImageList.get(qid);
                    setQuestion();

                    if (questionImageList.size() == qid) {

                    }
                }
            }
            counter++;
        }

        if (v.getId() == R.id.btnChoiceB) {

            String sBtnChoiceB = btnChoiceB.getText().toString();

            if (currentQ.getAnswer().equalsIgnoreCase(sBtnChoiceB)) {
                score++;
                sStatus = "check";
                if (qid <= questionImageList.size() - 1) {
                    currentQ = questionImageList.get(qid);
                    setQuestion();

                    if (questionImageList.size() == qid) {

                    }
                }
            } else {
                sStatus = "cross";
                if (qid <= questionImageList.size() - 1) {
                    currentQ = questionImageList.get(qid);
                    setQuestion();

                    if (questionImageList.size() == qid) {

                    }
                }
            }
            counter++;
        }

        if (v.getId() == R.id.btnChoiceC) {

            String sBtnChoiceC = btnChoiceC.getText().toString();

            if (currentQ.getAnswer().equalsIgnoreCase(sBtnChoiceC)) {
                score++;
                sStatus = "check";
                if (qid <= questionImageList.size() - 1) {
                    currentQ = questionImageList.get(qid);
                    setQuestion();

                    if (questionImageList.size() == qid) {

                    }
                }
            } else {
                sStatus = "cross";
                if (qid <= questionImageList.size() - 1) {
                    currentQ = questionImageList.get(qid);
                    setQuestion();

                    if (questionImageList.size() == qid) {

                    }
                }
            }
            counter++;
        }

        long id = dbHelper.insertImageSummary(currentQ.getId(), currentQ.getAnswer(), sStatus);

        if (counter==7) {

            if (score >= 5) {

                message = "AWESOME!!!";
                showResult(score, message);
            } else {

                message = "Sorry!!!";
                showResult(score, message);
            }

            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String formattedDate = df.format(calendar.getTime());

            String type = "Identify Images";

            enterName(type, lesson, score, formattedDate);
        }

        txtScore.setText("" + score);
    }

    private void enterName(final String type, final String lesson, final int score, final String formattedDate) {

        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setIcon(R.drawable.icon);
        alertDialogBuilder.setTitle("AuxMac2");
        alertDialogBuilder.setMessage("Enter your name");

        final EditText txtPlayer = new EditText(QuizImage.this);

        alertDialogBuilder.setView(txtPlayer);

        alertDialogBuilder.setPositiveButton("Save", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int arg1) {

                String sTxtPlayer = txtPlayer.getText().toString();

                if (sTxtPlayer.equalsIgnoreCase("")) {
                    sTxtPlayer = "Player";
                } else {
                    sTxtPlayer = txtPlayer.getText().toString();
                }

                dbHelper.insertScore(type, sTxtPlayer, lesson, score, formattedDate);

                dialog.dismiss();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.setCancelable(false);
        alertDialog.show();
    }

    private void showResult(final int score, String mess) {

        final String lesson = getIntent().getStringExtra("lesson");
        final String totalItem = "/7";

        final Dialog dialog = new Dialog(QuizImage.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.layout_show_result);
        dialog.getWindow().setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

        TextView txt_mess =(TextView)dialog.findViewById(R.id.txt_mess);
        TextView txtscore =(TextView)dialog.findViewById(R.id.txtscore);

        txt_mess.setText(mess);
        txtscore.setText(score + totalItem);

        final Button btnShowList = (Button)dialog.findViewById(R.id.btnShowList);

        btnShowList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(QuizImage.this, ImageSummary.class);
                i.putExtra("score", score);
                i.putExtra("lesson", lesson);
                startActivity(i);
                finish();
            }
        });

        dialog.setCancelable(false);
        dialog.show();
    }

    public List<QuestionImage> getQuestionImageList(String type) {

        List<QuestionImage> questionImageList = new ArrayList<QuestionImage>();

        String query = "select * from " + DatabaseHelper.TBL_QUIZIMAGE + " where " + DatabaseHelper.KEY_IMG_TYPE + " = '" + type + "'";
        db.dbase = db.getWritableDatabase();
        Cursor cursor = db.dbase.rawQuery(query, null);

        if (cursor!=null) {
            if (cursor.moveToFirst()) {
                do {
                    QuestionImage questionImage = new QuestionImage();
                    questionImage.setId(cursor.getInt(0));
                    questionImage.setChoicea(cursor.getString(1));
                    questionImage.setChoiceb(cursor.getString(2));
                    questionImage.setChoicec(cursor.getString(3));
                    questionImage.setAnswer(cursor.getString(4));
                    questionImage.setType(cursor.getString(5));

                    questionImageList.add(questionImage);
                } while (cursor.moveToNext());
            }
        }

        return questionImageList;
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(QuizImage.this, LessonList.class);
        startActivity(i);
        finish();
    }
}
