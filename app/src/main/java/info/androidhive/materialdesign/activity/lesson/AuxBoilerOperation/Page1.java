package info.androidhive.materialdesign.activity.lesson.AuxBoilerOperation;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.Locale;

import info.androidhive.materialdesign.R;

/**
 * Created by leo-pc on 1/4/2016.
 */
public class Page1 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.layout_aux_boiler_operation_page1,container,false);

        return v;
    }
}
