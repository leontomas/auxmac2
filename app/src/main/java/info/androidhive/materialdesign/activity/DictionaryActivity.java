package info.androidhive.materialdesign.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import info.androidhive.materialdesign.R;
import info.androidhive.materialdesign.model.Dictionary;
import info.androidhive.materialdesign.sqldatabase.DatabaseHelper;

public class DictionaryActivity extends Activity {

    TextToSpeech tts;
    private ListView lv;
    private ImageButton imgButton;
    ArrayAdapter<String> adapter;
    EditText inputSearch;
    ArrayList<HashMap<String, String>> wordList;

    List<Dictionary> dictionaryList;

    DatabaseHelper db = new DatabaseHelper(this);

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dictionary);

        final String word[] ={"Abaft", "Abeam", "Aboard", "Above Deck", "Abreast", "Adrift", "Aft", "Aground", "Ahead", "Aids To Navigation",
                "Alee", "Aloft", "Amidships", "Anchor", "Anchorage", "Astern", "Athwartships", "Aweigh", "Batten Down", "Beacon", "Beam",
                "Bearing", "Below", "Bilge", "Boat", "Bow", "Bow Line", "Buoy", "Cabin", "Capsize", "Cast Off", "Catamaran", "Course", "Cuddy",
                "Current", "Daybeacon", "Daymark", "Deck", "Dolphin", "Draft", "Ease", "Ebb Tide", "Even Keel", "Eye Of The Wind", "Eye Splice",
                "Fast", "Fathom", "Fender", "Figure Eight Knot", "Flame Arrester", "Flare", "Flood", "Forepeak", "Forward", "Fouled", "Founder",
                "Freeboard", "Gaff", "Galley", "Gangplank", "Ground Tackle", "Gunwale", "Harbor", "Hard Chine", "Hatch", "Head", "Hull Speed",
                "Hypothermia", "Inboard", "Intracoastal Waterway", "Jacobs Ladder", "Jetty", "Kedge", "Keel", "Ketch", "Knot", "Latitude",
                "Lazarette", "Leeway", "Longitude", "Lubber's Line", "Marlinspike", "Mast", "Mooring", "Mooring Buoy", "Nautical Mile", "Navigation",
                "Navigation Rules", "Outboard", "Outdrive", "Overboard", "Painter", "Passarella", "Pennant", "Pier", "Port", "Privileged Vessel",
                "Propeller", "Quarter", "Quartering Sea", "Reef", "Rigging", "Rode", "Rope", "Rudder", "Running Lights", "Satellite Navigation",
                "Scope", "Screw", "Shoal", "Sloop", "Stow", "Swamp", "Tackle", "Tender", "True Wind", "Turnbuckle", "Underway", "V Bottom",
                "Variation", "Vhf Radio", "Wake", "Waterline", "Wharf", "Winch", "Windward", "Yacht", "Yaw", "Yawl"};

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status!=TextToSpeech.ERROR) {
                    tts.setLanguage(Locale.UK);
                }
            }
        });

        lv = (ListView) findViewById(R.id.list_view);
        inputSearch = (EditText) findViewById(R.id.txtSearch);
        imgButton = (ImageButton) findViewById(R.id.imageButton);

        adapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.word, word);
        lv.setAdapter(adapter);

        imgButton.setImageResource(R.drawable.ic_action_search);
        imgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                inputSearch.setText(null);
                inputSearch.setFocusable(true);
                imgButton.setImageResource(R.drawable.ic_action_search);
            }
        });

        inputSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                DictionaryActivity.this.adapter.getFilter().filter(charSequence);
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                DictionaryActivity.this.adapter.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {

                String search = inputSearch.getText().toString();

                if (search.isEmpty()) {
                    imgButton.setImageResource(R.drawable.ic_action_search);
                } else {
//                    imgButton.setImageResource(R.drawable.abc_ic_clear_mtrl_alpha);
                }

            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                dictionaryList = getWord(adapter.getItem(position));

                for (Dictionary dicWord : dictionaryList) {

                    showDefinition(dicWord.getWord(), dicWord.getDescription());
                }
            }
        });
    }

    public List<Dictionary> getWord(String id) {

        List<Dictionary> dictionaryList = new ArrayList<Dictionary>();

        String query = "select * from " + DatabaseHelper.TBL_DICTIONARY + " where " + DatabaseHelper.KEY_WORD + " = '" + id + "'";
        db.dbase = db.getWritableDatabase();
        Cursor cursor = db.dbase.rawQuery(query, null);

        if (cursor!=null) {
            if (cursor.moveToFirst()) {
                do {
                    Dictionary dictionary = new Dictionary();
                    dictionary.setID(cursor.getInt(0));
                    dictionary.setWord(cursor.getString(1));
                    dictionary.setDescription(cursor.getString(2));

                    dictionaryList.add(dictionary);
                } while (cursor.moveToNext());
            }
        }

        return dictionaryList;
    }

    private void showDefinition(final String word, final String definition) {

        final Dialog dialog = new Dialog(DictionaryActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.layout_dialog_show_definition);
        dialog.getWindow().setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        TextView txtDefinition =(TextView)dialog.findViewById(R.id.txtDefinition);

        txtDefinition.setText(word + " - " + definition);

        TextView txtSpeak =(TextView)dialog.findViewById(R.id.txtSpeak);
        txtSpeak.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                tts.speak(word + " , " + definition, TextToSpeech.QUEUE_FLUSH, null);
            }
        });

        TextView txtClose =(TextView)dialog.findViewById(R.id.txtClose);
        txtClose.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                dialog.dismiss();
            }
        });

        dialog.setCancelable(false);
        dialog.show();
    }

    @Override
    public void onBackPressed() {

        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }
}
