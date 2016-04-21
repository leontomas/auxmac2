package info.androidhive.materialdesign.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

import info.androidhive.materialdesign.R;
import info.androidhive.materialdesign.model.Dictionary;

public class Video extends Activity {

    private String title, credit;

    private ListView lv;
    ArrayAdapter<String> adapter;
    ArrayList<HashMap<String, String>> videoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_video);

        final String video[] = {
                "Explanation of Boiler Feed Water & its treatment by Magic Marks \n04 : 38",
                "Feed Water Pump by lbnul Hossain \n01 : 35",
                "Fresh Water Generator 3D2 by g534fde \n02 : 06",
                "Steam Turbine Operation by RTECHLearn \n02 : 36",
                "Steering Gear(Animated Marine Workshop) by Nur Amira Yahja \n03 : 52"};

        lv = (ListView) findViewById(R.id.list_view);
        adapter = new ArrayAdapter<String>(this, R.layout.video_list, R.id.video_title, video);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                Intent i;

                switch (position) {

                    case 0:

                        title = "explanation_of_boiler_feed_water";
                        credit = "Explanation of Boiler Feed Water & its treatment by Magic Marks";

                        i = new Intent(Video.this, PlayVideo.class);
                        i.putExtra("title", title);
                        i.putExtra("credit", credit);
                        startActivity(i);
                        finish();
                        break;
                    case 1:

                        title = "feed_water_pump";
                        credit = "Feed Water Pump by lbnul Hossain";

                        i = new Intent(Video.this, PlayVideo.class);
                        i.putExtra("title", title);
                        i.putExtra("credit", credit);
                        startActivity(i);
                        finish();
                        break;
                    case 2:

                        title = "fresh_water_generator";
                        credit = "Fresh Water Generator 3D2 by g534fde";

                        i = new Intent(Video.this, PlayVideo.class);
                        i.putExtra("title", title);
                        i.putExtra("credit", credit);
                        startActivity(i);
                        finish();
                        break;
                    case 3:

                        title = "steam_turbine_operation";
                        credit = "Steam Turbine Operation by RTECHLearn";

                        i = new Intent(Video.this, PlayVideo.class);
                        i.putExtra("title", title);
                        i.putExtra("credit", credit);
                        startActivity(i);
                        finish();
                        break;
                    case 4:

                        title = "steering_gear";
                        credit = "Steering Gear(Animated Marine Workshop) by Nur Amira Yahja";

                        i = new Intent(Video.this, PlayVideo.class);
                        i.putExtra("title", title);
                        i.putExtra("credit", credit);
                        startActivity(i);
                        finish();
                        break;
                    default:
                        break;
                }
            }
        });
    }

    @Override
    public void onBackPressed() {

        Intent i = new Intent(Video.this, MainActivity.class);
        startActivity(i);
        finish();
    }
}
