package info.androidhive.materialdesign.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import info.androidhive.materialdesign.R;
import info.androidhive.materialdesign.sqldatabase.DatabaseHelper;

/**
 * Created on 2/21/2016.
 */
public class QuizProcedure extends Activity implements View.OnClickListener {

    DatabaseHelper dbHelper;
    DatabaseHelper db = new DatabaseHelper(this);

    String message;
    int score = 0;

    TextView txtScore;
    ImageView imgSubmit, imgPhoto;
    EditText txtAnswer1, txtAnswer2, txtAnswer3, txtAnswer4, txtAnswer5,
            txtAnswer6, txtAnswer7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_quiz_procedure);

        final String tag = getIntent().getStringExtra("tag");

        txtScore = (TextView) findViewById(R.id.txtScore);

        imgSubmit = (ImageView) findViewById(R.id.imgSubmit);
        imgPhoto = (ImageView) findViewById(R.id.imgPhoto);

        imgSubmit.setOnClickListener(this);

        txtAnswer1 = (EditText) findViewById(R.id.txtAnswer1);
        txtAnswer2 = (EditText) findViewById(R.id.txtAnswer2);
        txtAnswer3 = (EditText) findViewById(R.id.txtAnswer3);
        txtAnswer4 = (EditText) findViewById(R.id.txtAnswer4);
        txtAnswer5 = (EditText) findViewById(R.id.txtAnswer5);
        txtAnswer6 = (EditText) findViewById(R.id.txtAnswer6);
        txtAnswer7 = (EditText) findViewById(R.id.txtAnswer7);

        if (tag.equals("start")) {

            imgPhoto.setImageResource(R.drawable.imgstart_quiz);
        } else {

            imgPhoto.setImageResource(R.drawable.imgstop_quiz);
        }

        showInstruction();
    }

    private void showInstruction() {

        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setIcon(R.drawable.icon);
        alertDialogBuilder.setTitle("Assessment");
        alertDialogBuilder.setMessage("Arrange the procedure/steps sequencially." +
                "\n\n" +
                "Determine which step should be done first." +
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

    @Override
    public void onClick(View v) {

        final String tag = getIntent().getStringExtra("tag");

        final String lesson = getIntent().getStringExtra("lesson");

        dbHelper = new DatabaseHelper(QuizProcedure.this);
        dbHelper.open();

        if (v.getId()==R.id.imgSubmit) {

            if(tag.equals("start")) {

                if ("6".equalsIgnoreCase(txtAnswer1.getText().toString())) {
                    score++;
                }

                if ("1".equalsIgnoreCase(txtAnswer2.getText().toString())) {
                    score++;
                }

                if ("3".equalsIgnoreCase(txtAnswer3.getText().toString())) {
                    score++;
                }

                if ("4".equalsIgnoreCase(txtAnswer4.getText().toString())) {
                    score++;
                }

                if ("7".equalsIgnoreCase(txtAnswer5.getText().toString())) {
                    score++;
                }

                if ("2".equalsIgnoreCase(txtAnswer6.getText().toString())) {
                    score++;
                }

                if ("5".equalsIgnoreCase(txtAnswer7.getText().toString())) {
                    score++;
                }

            } else {

                if ("7".equalsIgnoreCase(txtAnswer1.getText().toString())) {
                    score++;
                }

                if ("5".equalsIgnoreCase(txtAnswer2.getText().toString())) {
                    score++;
                }

                if ("1".equalsIgnoreCase(txtAnswer3.getText().toString())) {
                    score++;
                }

                if ("2".equalsIgnoreCase(txtAnswer4.getText().toString())) {
                    score++;
                }

                if ("6".equalsIgnoreCase(txtAnswer5.getText().toString())) {
                    score++;
                }

                if ("3".equalsIgnoreCase(txtAnswer6.getText().toString())) {
                    score++;
                }

                if ("4".equalsIgnoreCase(txtAnswer7.getText().toString())) {
                    score++;
                }
            }

            txtScore.setText(""+score);
        }

        if(score>4) {

            message = "AWESOME!!!";
            showResult(score, message);
        } else {

            message = "Sorry!!!";
            showResult(score, message);
        }

    }

    private void enterName(final String type, final String lesson, final int score, final String formattedDate) {

        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setIcon(R.drawable.icon);
        alertDialogBuilder.setTitle("AuxMac2");
        alertDialogBuilder.setMessage("Enter your name");

        final EditText txtPlayer = new EditText(QuizProcedure.this);

        alertDialogBuilder.setView(txtPlayer);

        alertDialogBuilder.setPositiveButton("View Answer", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int arg1) {

                String sTxtPlayer = txtPlayer.getText().toString();

                if (sTxtPlayer.equalsIgnoreCase("")) {
                    sTxtPlayer = "Player";
                } else {
                    sTxtPlayer = txtPlayer.getText().toString();
                }

                dbHelper.insertScore(type, sTxtPlayer, lesson, score, formattedDate);

                showAnswer();

                dialog.dismiss();
            }
        });

        alertDialogBuilder.setNegativeButton("Score", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int arg1) {

                String sTxtPlayer = txtPlayer.getText().toString();

                if (sTxtPlayer.equalsIgnoreCase("")) {
                    sTxtPlayer = "Player";
                } else {
                    sTxtPlayer = txtPlayer.getText().toString();
                }

                dbHelper.insertScore(type, sTxtPlayer, lesson, score, formattedDate);

                showAnswer();
                dialog.dismiss();

                Intent i = new Intent(QuizProcedure.this, ScoreBoard.class);
                startActivity(i);
                finish();
            }
        });

        alertDialogBuilder.setNeutralButton("Back to Lesson", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int arg1) {

                String sTxtPlayer = txtPlayer.getText().toString();

                if (sTxtPlayer.equalsIgnoreCase("")) {
                    sTxtPlayer = "Player";
                } else {
                    sTxtPlayer = txtPlayer.getText().toString();
                }

                dbHelper.insertScore(type, sTxtPlayer, lesson, score, formattedDate);

                showAnswer();
                dialog.dismiss();

                Intent i = new Intent(QuizProcedure.this, LessonList.class);
                startActivity(i);
                finish();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.setCancelable(false);
        alertDialog.show();
    }

    private void showAnswer() {

        final String tag = getIntent().getStringExtra("tag");

        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setIcon(R.drawable.icon);
        alertDialogBuilder.setTitle("AuxMac2");
        alertDialogBuilder.setMessage("Answer");

        final ImageView imgPhoto = new ImageView(QuizProcedure.this);

        imgPhoto.setAdjustViewBounds(true);
        if (tag.equals("start")) {

            imgPhoto.setImageResource(R.drawable.imgstart_quiz_answer);
        } else {

            imgPhoto.setImageResource(R.drawable.imgstop_quiz_answer);
        }

        alertDialogBuilder.setView(imgPhoto);

        alertDialogBuilder.setPositiveButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int arg1) {

                dialog.dismiss();
                Intent i = new Intent(QuizProcedure.this, LessonList.class);
                startActivity(i);
                finish();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.setCancelable(false);
        alertDialog.show();
    }

    private void showResult(final int score, String mess) {

        final String tag = getIntent().getStringExtra("tag");
        final String lesson = getIntent().getStringExtra("lesson");
        final String totalItem = "/7";

        final Dialog dialog = new Dialog(QuizProcedure.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.layout_show_result2);
        dialog.getWindow().setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

        TextView txt_mess =(TextView)dialog.findViewById(R.id.txt_mess);
        TextView txtscore =(TextView)dialog.findViewById(R.id.txtscore);
        TextView txtEnterName =(TextView)dialog.findViewById(R.id.txtEnterName);

        txt_mess.setText(mess);
        txtscore.setText(score + totalItem);

        txtEnterName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calendar calendar = Calendar.getInstance();
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String formattedDate = df.format(calendar.getTime());

                String type;

                if (tag.equals("start")) {

                    type = "Arrange - Start Procedure";
                } else  {

                    type = "Arrange - Stop Procedure";
                }

                enterName(type, lesson, score, formattedDate);
            }
        });

        dialog.setCancelable(false);
        dialog.show();
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(QuizProcedure.this, LessonList.class);
        startActivity(i);
        finish();
    }
}
