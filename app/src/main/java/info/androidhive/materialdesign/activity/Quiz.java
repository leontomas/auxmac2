package info.androidhive.materialdesign.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import info.androidhive.materialdesign.R;
import info.androidhive.materialdesign.model.Question;
import info.androidhive.materialdesign.model.TestSummary;
import info.androidhive.materialdesign.sqldatabase.DatabaseHelper;


public class Quiz extends Activity implements View.OnClickListener {

    DatabaseHelper dbHelper;
    DatabaseHelper db = new DatabaseHelper(this);

    List<Question> questionList;
    List<TestSummary> summaryList;
    int qid = 0;
    Question currentQ;
    TestSummary summary;

    private TextView txtQuestion, txtScore;
    private Button btnChoiceA, btnChoiceB, btnChoiceC;

    String message = "";
    int score = 0;
    int counter = 0;

    String sQuestion, sAnswer, sAddInfo, sStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_layout);

        final String lesson = getIntent().getStringExtra("lesson");

        txtQuestion = (TextView) findViewById(R.id.txtQuestion);
        txtScore = (TextView) findViewById(R.id.txtScore);
        btnChoiceA = (Button) findViewById(R.id.btnChoiceA);
        btnChoiceB = (Button) findViewById(R.id.btnChoiceB);
        btnChoiceC = (Button) findViewById(R.id.btnChoiceC);

        questionList = this.getQuestionList(lesson);
        Collections.shuffle(questionList);
        currentQ = questionList.get(qid);

        btnChoiceA.setOnClickListener(this);
        btnChoiceB.setOnClickListener(this);
        btnChoiceC.setOnClickListener(this);

        txtScore.setText("0");

        setQuestion();
    }

    @Override
    public void onClick(View v) {

        final String lesson = getIntent().getStringExtra("lesson");

        dbHelper = new DatabaseHelper(Quiz.this);
        dbHelper.open();

        String sTxtQuestion = txtQuestion.getText().toString();
        String sTxtAnswer = currentQ.getAnswer().toString();

        if (v.getId()==R.id.btnChoiceA) {
            String answer = btnChoiceA.getText().toString();
            if (currentQ.getAnswer().equals(answer)) {
                score++;
                sAddInfo = "";
                sStatus = "check";
                if (qid <= questionList.size() - 1) {
                    currentQ = questionList.get(qid);
                    setQuestion();

                    if (questionList.size() == qid) {

                    }
                }

            } else {

                sAddInfo = currentQ.getadditionalInfo();
                sStatus = "cross";

                if (qid <= questionList.size() - 1) {
                    currentQ = questionList.get(qid);
                    setQuestion();

                    if (questionList.size() == qid) {

                    }
                }
            }

            counter++;
        }
        if (v.getId()==R.id.btnChoiceB) {
            String answer = btnChoiceB.getText().toString();
            if (currentQ.getAnswer().equals(answer)) {
                score++;

                sAddInfo = "";
                sStatus = "check";

                if (qid <= questionList.size() - 1) {
                    currentQ = questionList.get(qid);
                    setQuestion();

                    if (questionList.size() == qid) {

                    }
                }
            } else {

                sQuestion = currentQ.getQuestion();
                sAnswer = currentQ.getAnswer();
                sAddInfo = currentQ.getadditionalInfo();
                sStatus = "cross";

                if (qid <= questionList.size() - 1) {
                    currentQ = questionList.get(qid);
                    setQuestion();

                    if (questionList.size() == qid) {

                    }
                }
            }

            counter++;
        }
        if (v.getId()==R.id.btnChoiceC) {
            String answer = btnChoiceC.getText().toString();
            if (currentQ.getAnswer().equals(answer)) {
                score++;
                sAddInfo = "";
                sStatus = "check";
                if (qid <= questionList.size() - 1) {
                    currentQ = questionList.get(qid);
                    setQuestion();

                    if (questionList.size() == qid) {

                    }
                }

            } else {

                sQuestion = currentQ.getQuestion();
                sAnswer = currentQ.getAnswer();
                sAddInfo = currentQ.getadditionalInfo();
                sStatus = "cross";

                if (qid <= questionList.size() - 1) {
                    currentQ = questionList.get(qid);
                    setQuestion();

                    if (questionList.size() == qid) {

                    }
                }
            }

            counter++;
        }

        long id = dbHelper.insertSummary(sTxtQuestion, sTxtAnswer, sAddInfo, sStatus);

        if (counter==10) {

            if (score >= 8) {

                message = "AWESOME!!!";
                showResult(score, message);
            } else {

                message = "Sorry!!!";
                showResult(score, message);
            }

            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String formattedDate = df.format(calendar.getTime());

            String type = "Multiple Choice";

            enterName(type, lesson, score, formattedDate);
        }

        txtScore.setText("" + score);
    }

    private void setQuestion() {
        txtQuestion.setText(currentQ.getQuestion());
        btnChoiceA.setText(currentQ.getChoicea());
        btnChoiceB.setText(currentQ.getChoiceb());
        btnChoiceC.setText(currentQ.getChoicec());
        qid++;
    }

    private void enterName(final String type, final String lesson, final int score, final String formattedDate) {

        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setIcon(R.drawable.icon);
        alertDialogBuilder.setTitle("AuxMac2");
        alertDialogBuilder.setMessage("Enter your name");

        final EditText txtPlayer = new EditText(Quiz.this);

        alertDialogBuilder.setView(txtPlayer);

        alertDialogBuilder.setPositiveButton("Save", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {

                String sTxtPlayer = txtPlayer.getText().toString();

                if (sTxtPlayer.equalsIgnoreCase("")) {
                    sTxtPlayer = "Player";
                } else {
                    sTxtPlayer = txtPlayer.getText().toString();
                }

                dbHelper.insertScore(type, sTxtPlayer, lesson, score, formattedDate);
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.setCancelable(false);
        alertDialog.show();
    }

    private void showResult(final int score, String mess) {

        final String lesson = getIntent().getStringExtra("lesson");
        final String totalItem = "/10";

        final Dialog dialog = new Dialog(Quiz.this);
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

                Intent i = new Intent(Quiz.this, Summary.class);
                i.putExtra("score", score);
                i.putExtra("lesson", lesson);
                startActivity(i);
                finish();
            }
        });

        dialog.setCancelable(false);
        dialog.show();
    }

    public List<Question> getQuestionList(String lesson) {

        List<Question> questionList = new ArrayList<Question>();

        String query = "select * from " + DatabaseHelper.TBL_QUESTION + " where " + DatabaseHelper.KEY_LESSON + " = '" + lesson + "'";
        db.dbase = db.getWritableDatabase();
        Cursor cursor = db.dbase.rawQuery(query, null);

        if (cursor!=null) {
            if (cursor.moveToFirst()) {
                do {
                    Question question = new Question();
                    question.setID(cursor.getInt(0));
                    question.setQuestion(cursor.getString(1));
                    question.setLesson(cursor.getString(2));
                    question.setChoicea(cursor.getString(3));
                    question.setChoiceb(cursor.getString(4));
                    question.setChoicec(cursor.getString(5));
                    question.setAnswer(cursor.getString(6));
                    question.setadditionalInfo(cursor.getString(7));

                    questionList.add(question);
                } while (cursor.moveToNext());
            }
        }

        return questionList;
    }

    @Override
    public void onBackPressed() {

        Intent i = new Intent(this, LessonList.class);
        startActivity(i);
        finish();
    }
}
