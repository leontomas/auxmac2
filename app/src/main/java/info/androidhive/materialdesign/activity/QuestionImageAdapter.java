package info.androidhive.materialdesign.activity;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import info.androidhive.materialdesign.R;
import info.androidhive.materialdesign.model.TestImageSummary;

/**
 * Created on 2/21/2016.
 */
public class QuestionImageAdapter extends ArrayAdapter<TestImageSummary> {

    public QuestionImageAdapter(Context context, ArrayList<TestImageSummary> question) {
        super(context, 0, question);
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        TestImageSummary question = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.imagequestion_list, parent, false);

        }

        ImageView imgStatus = (ImageView) convertView.findViewById(R.id.imgStatus);
        TextView txtAnswer = (TextView) convertView.findViewById(R.id.txtAnswer);

        String package_name = getContext().getApplicationContext().getPackageName();
        int imageStatus = getContext().getResources().getIdentifier(package_name + ":drawable/" + question.getStatus(), null, null);

        imgStatus.setImageBitmap(BitmapFactory.decodeResource(getContext().getResources(), imageStatus));
        txtAnswer.setText(question.getAnswer());

        return convertView;
    }
}
