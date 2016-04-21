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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import info.androidhive.materialdesign.R;
import info.androidhive.materialdesign.sqldatabase.DatabaseHelper;
/**
 * Created on 2/21/2016.
 */
public class QuizFill extends Activity implements View.OnClickListener {

    DatabaseHelper dbHelper;
    DatabaseHelper db = new DatabaseHelper(this);

    String message;
    int score = 0;

    TextView txtScore;
    ImageView imgSubmit, imgInfo;
    EditText txtAnswer1, txtAnswer2, txtAnswer3, txtAnswer4, txtAnswer5,
            txtAnswer6, txtAnswer7, txtAnswer8, txtAnswer9, txtAnswer10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_quiz_steering_gear);

        txtScore = (TextView) findViewById(R.id.txtScore);

        imgSubmit = (ImageView) findViewById(R.id.imgSubmit);
        imgInfo = (ImageView) findViewById(R.id.imgInfo);

        imgSubmit.setOnClickListener(this);

        txtAnswer1 = (EditText) findViewById(R.id.txtAnswer1);
        txtAnswer2 = (EditText) findViewById(R.id.txtAnswer2);
        txtAnswer3 = (EditText) findViewById(R.id.txtAnswer3);
        txtAnswer4 = (EditText) findViewById(R.id.txtAnswer4);
        txtAnswer5 = (EditText) findViewById(R.id.txtAnswer5);
        txtAnswer6 = (EditText) findViewById(R.id.txtAnswer6);
        txtAnswer7 = (EditText) findViewById(R.id.txtAnswer7);
        txtAnswer8 = (EditText) findViewById(R.id.txtAnswer8);
        txtAnswer9 = (EditText) findViewById(R.id.txtAnswer9);
        txtAnswer10 = (EditText) findViewById(R.id.txtAnswer10);

        imgInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showChoices();
            }
        });

        showInstruction();
    }

    private void showInstruction() {

        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setIcon(R.drawable.icon);
        alertDialogBuilder.setTitle("Assessment");
        alertDialogBuilder.setMessage("Fill-out the blanks provided." +
                "\n\n" +
                "You can view the answer by pressing the \"i\" icon in the upper left corner" +
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

        final String lesson = getIntent().getStringExtra("lesson");

        dbHelper = new DatabaseHelper(QuizFill.this);
        dbHelper.open();

        if (v.getId()==R.id.imgSubmit) {

            if ("Angle indicator".equalsIgnoreCase(txtAnswer1.getText().toString())) {
                score++;
            }

            if ("Expansion tank".equalsIgnoreCase(txtAnswer2.getText().toString())) {
                score++;
            }

            if ("Rudder stock nut".equalsIgnoreCase(txtAnswer3.getText().toString())) {
                score++;
            }

            if ("Stopper bolt nut".equalsIgnoreCase(txtAnswer4.getText().toString())) {
                score++;
            }

            if ("Upper radial bearing".equalsIgnoreCase(txtAnswer5.getText().toString())) {
                score++;
            }

            if ("Rotor Hub".equalsIgnoreCase(txtAnswer6.getText().toString())) {
                score++;
            }

            if ("Housing".equalsIgnoreCase(txtAnswer7.getText().toString())) {
                score++;
            }

            if ("Rudder stock".equalsIgnoreCase(txtAnswer8.getText().toString())) {
                score++;
            }

            if ("Rudder carrier".equalsIgnoreCase(txtAnswer9.getText().toString())) {
                score++;
            }

            if ("Lower packing".equalsIgnoreCase(txtAnswer10.getText().toString())) {
                score++;
            }

            txtScore.setText("" + score);
        }

        if(score>8) {

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

        final EditText txtPlayer = new EditText(QuizFill.this);

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

                Intent i = new Intent(QuizFill.this, ScoreBoard.class);
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

                Intent i = new Intent(QuizFill.this, LessonList.class);
                startActivity(i);
                finish();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.setCancelable(false);
        alertDialog.show();
    }

    private void showAnswer() {

        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setIcon(R.drawable.icon);
        alertDialogBuilder.setTitle("AuxMac2");
        alertDialogBuilder.setMessage("Answer");

        final ImageView imgPhoto = new ImageView(QuizFill.this);

        imgPhoto.setImageResource(R.drawable.actuator);
        alertDialogBuilder.setView(imgPhoto);

        alertDialogBuilder.setPositiveButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int arg1) {

                dialog.dismiss();
                Intent i = new Intent(QuizFill.this, LessonList.class);
                startActivity(i);
                finish();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.setCancelable(false);
        alertDialog.show();
    }

    private void showResult(final int score, String mess) {

        final String lesson = getIntent().getStringExtra("lesson");
        final String totalItem = "/10";

        final Dialog dialog = new Dialog(QuizFill.this);
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

                String type = "Fill-in Blanks";

                enterName(type, lesson, score, formattedDate);
            }
        });

        dialog.setCancelable(false);
        dialog.show();
    }

    private void showChoices() {

        String answerList[] = {"Lower packing", "Upper radial bearing", "Expansion tank", "Rudder carrier", "Rudder stock nut",
                "Housing", "Angle indicator", "Rotor Hub", "Stopper bolt nut", "Rudder stock"};

        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setIcon(R.drawable.icon);
        alertDialogBuilder.setTitle("Fill-in Blanks");
        alertDialogBuilder.setMessage("Choose the best answer!");

        ListView list = new ListView(this);
        list.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, answerList));

        alertDialogBuilder.setView(list);

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
    public void onBackPressed() {
        Intent i = new Intent(QuizFill.this, LessonList.class);
        startActivity(i);
        finish();
    }
}
