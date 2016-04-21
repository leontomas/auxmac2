package info.androidhive.materialdesign.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import info.androidhive.materialdesign.R;
import info.androidhive.materialdesign.activity.Simulation3D.Chiller;
import info.androidhive.materialdesign.activity.Simulation3D.ControlPanel;
import info.androidhive.materialdesign.activity.Simulation3D.ShipsSteering;
import info.androidhive.materialdesign.activity.Simulation3D.SteamTurbine;
import info.androidhive.materialdesign.activity.Simulation3D.StopValve;
/**
 * Created on 2/21/2016.
 */
public class Model extends Activity implements View.OnClickListener {

    Button btnControlPanel, btnShipsSteering, btnStopValve, btnChiller, btnSteamTurbine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_model);

        btnShipsSteering = (Button) findViewById(R.id.btnShipsSteering);
        btnStopValve = (Button) findViewById(R.id.btnStopValve);
        btnChiller = (Button) findViewById(R.id.btnChiller);
        btnSteamTurbine = (Button) findViewById(R.id.btnSteamTurbine);

        btnShipsSteering.setOnClickListener(this);
        btnStopValve.setOnClickListener(this);
        btnChiller.setOnClickListener(this);
        btnSteamTurbine.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {

            case R.id.btnShipsSteering:
                intent = new Intent(Model.this, ShipsSteering.class);
                intent.putExtra("title", "Ship Steering Gear");
                intent.putExtra("name", "by Marco");
                break;
            case R.id.btnStopValve:
                intent = new Intent(Model.this, StopValve.class);
                intent.putExtra("title", "Stop valve");
                intent.putExtra("name", "by Sujith Singh Immanuel");
                break;
            case R.id.btnChiller:
                intent = new Intent(Model.this, Chiller.class);
                intent.putExtra("title", "Chiller for Brine");
                intent.putExtra("name", "by Fredo50");
                break;
            case R.id.btnSteamTurbine:
                intent = new Intent(Model.this, SteamTurbine.class);
                intent.putExtra("title", "Steam Turbine");
                intent.putExtra("name", "by Luis24");
                break;

        }
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed() {

        Intent i = new Intent(Model.this, MainActivity.class);
        startActivity(i);
        finish();
    }
}
