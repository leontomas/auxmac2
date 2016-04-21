package info.androidhive.materialdesign.activity.lesson.FreshWaterGenerator;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import info.androidhive.materialdesign.R;

/**
 * Created on 1/3/2016.
 */
public class Page1 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.layout_fresh_water_generator_page1,container,false);
        return v;
    }
}
