package info.androidhive.materialdesign.activity.lesson.AuxEngine;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import info.androidhive.materialdesign.R;

/**
 * Created by leo-pc on 1/4/2016.
 */
public class Page3 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.layout_aux_engine_page3,container,false);
        return v;
    }
}
