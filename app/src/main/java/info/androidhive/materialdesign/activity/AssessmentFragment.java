package info.androidhive.materialdesign.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import info.androidhive.materialdesign.R;

public class AssessmentFragment extends Fragment {

    private Button btnAutoViscosity, btnAuxEngine, btnFreshWater, btnBoiler;
    private String lesson;

    public AssessmentFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_assessment, container, false);

        btnAutoViscosity = (Button) rootView.findViewById(R.id.btnAutoViscosity);
        btnAutoViscosity.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                lesson = "AutoViscosity";

                Intent i = new Intent(getActivity(), Quiz.class);
                i.putExtra("lesson", lesson.toString());
                startActivity(i);
                getActivity().finish();
            }
        });

        btnAuxEngine = (Button) rootView.findViewById(R.id.btnAuxEngine);
        btnAuxEngine.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                lesson = "Aux Engine";

                Intent i = new Intent(getActivity(), Quiz.class);
                i.putExtra("lesson", lesson.toString());
                startActivity(i);
                getActivity().finish();
            }
        });

        btnFreshWater = (Button) rootView.findViewById(R.id.btnFreshWater);
        btnFreshWater.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                lesson = "Fresh Water Generator";

                Intent i = new Intent(getActivity(), Quiz.class);
                i.putExtra("lesson", lesson.toString());
                startActivity(i);
                getActivity().finish();
            }
        });

        btnBoiler = (Button) rootView.findViewById(R.id.btnBoiler);
        btnBoiler.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                lesson = "Boiler Operation";

                Intent i = new Intent(getActivity(), Quiz.class);
                i.putExtra("lesson", lesson.toString());
                startActivity(i);
                getActivity().finish();
            }
        });

        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
