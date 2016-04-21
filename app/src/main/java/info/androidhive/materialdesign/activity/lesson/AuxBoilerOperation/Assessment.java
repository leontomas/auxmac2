package info.androidhive.materialdesign.activity.lesson.AuxBoilerOperation;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import info.androidhive.materialdesign.R;
import info.androidhive.materialdesign.activity.Quiz;
import info.androidhive.materialdesign.activity.QuizImage;

/**
 * Created by leo-pc on 1/4/2016.
 */
public class Assessment extends Fragment {

    Button btnAssessment;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.layout_aux_boiler_test,container,false);

        Button btnTest = (Button) v.findViewById(R.id.btnTest);
        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showTestOption();
            }
        });

        return v;
    }

    private void showTestOption() {

        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
        alertDialogBuilder.setIcon(R.drawable.icon);
        alertDialogBuilder.setTitle("AuxMac2");
        alertDialogBuilder.setMessage("Choose Question Type");

        alertDialogBuilder.setPositiveButton("Multiple Choice", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                String lesson = "Aux Boiler";

                Intent i = new Intent(getActivity(), Quiz.class);
                i.putExtra("lesson", lesson.toString());
                startActivity(i);
                getActivity().finish();
                dialog.dismiss();
            }
        });

        alertDialogBuilder.setNegativeButton("Identify Images", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                String lesson = "Aux Boiler";
                String type = "Identification";

                Intent i = new Intent(getActivity(), QuizImage.class);
                i.putExtra("type", type);
                i.putExtra("lesson", lesson.toString());
                startActivity(i);
                getActivity().finish();
                dialog.dismiss();
            }
        });

        alertDialogBuilder.setNeutralButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.dismiss();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

}
