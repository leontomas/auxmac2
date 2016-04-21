package info.androidhive.materialdesign.activity.Simulation;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import at.lukle.clickableareasimage.ClickableArea;
import at.lukle.clickableareasimage.ClickableAreasImage;
import at.lukle.clickableareasimage.OnClickableAreaClickedListener;
import info.androidhive.materialdesign.R;
import uk.co.senab.photoview.PhotoViewAttacher;

public class FWGStop extends AppCompatActivity implements OnClickableAreaClickedListener {
    Dialog dialog, dialogStop;
    private ImageView image, imgStart;
    private List<ClickableArea> clickableAreas;
    private ClickableAreasImage clickableAreasImage;
    private String mess = "";
    private AnimationDrawable gyroAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fwgstop);

        /*imgStart = (ImageView) findViewById(R.id.imgStop);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                imgStart.setVisibility(View.GONE);
            }
        }, 5000);*/

        dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.layout_dialog);
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(true);

        dialogStop = new Dialog(this);
        dialogStop.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogStop.setContentView(R.layout.layout_dialog_instruction);
        dialogStop.setCancelable(true);
        dialogStop.setCanceledOnTouchOutside(true);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();
            }
        });

        FloatingActionButton fab2 = (FloatingActionButton) findViewById(R.id.fab2);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogStop.show();
            }
        });
        // Add image
        image = (ImageView) findViewById(R.id.imageView);
        image.setImageResource(R.drawable.pointstopa);

        // Create your image
        clickableAreasImage = new ClickableAreasImage(new PhotoViewAttacher(image), this);

        // Define your clickable area (pixel values: x coordinate, y coordinate, width, height) and assign an object to it
        clickableAreas = getClickableAreas(new ClickableArea(970, 104, 200, 200, 1));
        clickableAreasImage.setClickableAreas(clickableAreas);
    }

    // Listen for touches on your images:
    @Override
    public void onClickableAreaTouched(Object item) {

        clickableAreas = null;
        switch ((Integer) item) {
            case 1:
                image.setImageResource(R.drawable.pointstopb);
                clickableAreas = getClickableAreas(new ClickableArea(815, 130, 200, 200, 2));

                mess = "Fresh water pump stops.";
                showMessage(mess);

                break;
            case 2:
                image.setImageResource(R.drawable.pointstopc);
                gyroAnimation = (AnimationDrawable) image.getDrawable();
                gyroAnimation.start();
                clickableAreas = getClickableAreas(new ClickableArea(910, 103, 200, 200, 3));

                mess = "Sec. Alarm turns off.";
                showMessage(mess);

                break;
            case 3:
                image.setImageResource(R.drawable.pointstopd);
                clickableAreas = getClickableAreas(new ClickableArea(970, 145, 200, 200, 4));

                mess = "Ejector pump stops and vapor cools down.";
                showMessage(mess);

                break;
            case 4:
                image.setImageResource(R.drawable.pointstope);
                clickableAreas = getClickableAreas(new ClickableArea(587, 34, 200, 200, 5));

                mess = "Main switch has set to 0 which results to shutdown power supply for the fresh water generator";
                showMessage(mess);

                break;
            case 5:
                image.setImageResource(R.drawable.pointstopf);
                clickableAreas = getClickableAreas(new ClickableArea(490, 438, 200, 200, 6));

                mess = "Air valve opens.";
                showMessage(mess);

                break;
            case 6:
                image.setImageResource(R.drawable.pointstopg);
                clickableAreas = getClickableAreas(new ClickableArea(330, 385, 200, 200, 7));

                mess = "Suction valve closes.";
                showMessage(mess);

                break;
            case 7:
                image.setImageResource(R.drawable.pointstoph);
                clickableAreas = getClickableAreas(new ClickableArea(676, 393, 200, 200, 8));

                mess = "Discharge valve closes.";
                showMessage(mess);

                break;
            case 8:
                image.setImageResource(R.drawable.pointstopi);
                clickableAreas = getClickableAreas(new ClickableArea(0, 0, 0, 0, 9));

                mess = "Overboard valve closes.";
                showMessage(mess);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        image.setImageResource(R.drawable.pointmm);
                        mess = "You done with the stopping of machine.";
                        showMessage(mess);
                    }
                }, 3000);

                break;

        }
        clickableAreasImage.setClickableAreas(clickableAreas);

    }

    private void showMessage(String message) {
        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setIcon(R.drawable.icon);
        alertDialogBuilder.setTitle("Alfa Laval Fresh Water Generator");
        alertDialogBuilder.setMessage("" + message);

        alertDialogBuilder.setPositiveButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {

                dialog.dismiss();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    @NonNull
    private List<ClickableArea> getClickableAreas(ClickableArea clickableArea) {
        List<ClickableArea> clickableAreas = new ArrayList<>();
        clickableAreas.add(clickableArea);
        return clickableAreas;
    }
}