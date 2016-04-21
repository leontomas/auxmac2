package info.androidhive.materialdesign.activity.lesson.OperationOfGenerator;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import info.androidhive.materialdesign.R;
import info.androidhive.materialdesign.activity.Quiz;

/**
 * Created on 1/3/2016.
 */
public class Assessment extends Fragment {

    Button btnAssessment;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.layout_operation_of_generator_test,container,false);

        Button btnTest = (Button) v.findViewById(R.id.btnTest);
        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String lesson = "Operation of Generators";

                Intent i = new Intent(getActivity(), Quiz.class);
                i.putExtra("lesson", lesson.toString());
                startActivity(i);
                getActivity().finish();
            }
        });

        return v;
    }
}
