package info.androidhive.materialdesign.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import info.androidhive.materialdesign.R;
import info.androidhive.materialdesign.model.Question;
import info.androidhive.materialdesign.model.TestSummary;

/**
 * Created on 2/21/2016.
 */
public class QuestionAdapter extends ArrayAdapter<TestSummary> {

    public QuestionAdapter(Context context, ArrayList<TestSummary> question) {
        super(context, 0, question);
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        TestSummary question = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.question_list, parent, false);

        }

        ImageView imgView = (ImageView) convertView.findViewById(R.id.imgView);
        TextView txtQuestion = (TextView) convertView.findViewById(R.id.txtQuestion);
        //TextView txtAnswer = (TextView) convertView.findViewById(R.id.txtAnswer);
        //TextView txtAdditionalInfo = (TextView) convertView.findViewById(R.id.txtAdditionalInfo);

        String package_name = getContext().getApplicationContext().getPackageName();
        int imgid = getContext().getResources().getIdentifier(package_name+":drawable/"+question.getStatus(), null, null);

        imgView.setImageBitmap(BitmapFactory.decodeResource(getContext().getResources(), imgid));
        txtQuestion.setText(question.getQuestion());
        //txtAnswer.setText(question.getAnswer());
        //txtAdditionalInfo.setText(question.getAdditionalInfo());

        return convertView;
    }


}
