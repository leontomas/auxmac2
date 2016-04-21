package info.androidhive.materialdesign.activity;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import info.androidhive.materialdesign.R;
import info.androidhive.materialdesign.model.*;

/**
 * Created on 2/21/2016.
 */
public class ScoreAdapter extends ArrayAdapter<Score> {

    public ScoreAdapter(Context context, ArrayList<Score> score) {
        super(context, 0, score);
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        Score score = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.score_list, parent, false);

        }

        if (position % 2 == 0) {
            convertView.setBackgroundColor(Color.LTGRAY);
        } else {
            convertView.setBackgroundColor(Color.TRANSPARENT);
        }

        TextView txtType = (TextView) convertView.findViewById(R.id.txtType);
        TextView txtPlayer = (TextView) convertView.findViewById(R.id.txtPlayer);
        TextView txtSubject = (TextView) convertView.findViewById(R.id.txtSubject);
        TextView txtScore = (TextView) convertView.findViewById(R.id.txtScore);
        TextView txtDateTaken = (TextView) convertView.findViewById(R.id.txtDateTaken);

        String totalItem = "";

        if (score.getType().equalsIgnoreCase("Multiple Choice")) {
            totalItem = "/10";
        } else if (score.getType().equalsIgnoreCase("Identify Images")) {
            totalItem = "/7";
        } else if (score.getType().equalsIgnoreCase("Fill-in Blanks")) {
            totalItem = "/10";
        } else if (score.getType().equalsIgnoreCase("Arrange - Start Procedure")) {
            totalItem = "/7";
        } else if (score.getType().equalsIgnoreCase("Arrange - Stop Procedure")) {
            totalItem = "/7";
        }

        txtType.setText(score.getType());
        txtPlayer.setText(score.getName());
        txtSubject.setText(score.getSubject());
        txtScore.setText(score.getScore() + totalItem);
        txtDateTaken.setText(score.getDatetaken());

        return convertView;
    }
}
