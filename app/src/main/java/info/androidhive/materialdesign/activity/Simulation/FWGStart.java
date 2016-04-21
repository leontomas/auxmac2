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

public class FWGStart extends AppCompatActivity implements OnClickableAreaClickedListener {
    Dialog dialog, dialogStop;
    private ImageView image, imgStart, imgStartInstruction;
    private List<ClickableArea> clickableAreas;
    private ClickableAreasImage clickableAreasImage;
    private String mess = "";
    private AnimationDrawable gyroAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fwgstart);

        /*imgStart = (ImageView) findViewById(R.id.imgStart);
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
//        dialog.getWindow().setBackgroundDrawable(null);

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
        image.setImageResource(R.drawable.pointa);

        // Create your image
        clickableAreasImage = new ClickableAreasImage(new PhotoViewAttacher(image), this);

        // Define your clickable area (pixel values: x coordinate, y coordinate, width, height) and assign an object to it
        clickableAreas = getClickableAreas(new ClickableArea(492, 441, 150, 150, 1));
        clickableAreasImage.setClickableAreas(clickableAreas);

    }

    // Listen for touches on your images:
    @Override
    public void onClickableAreaTouched(Object item) {

        clickableAreas = null;
        switch ((Integer) item) {
            case 1:
                image.setImageResource(R.drawable.pointb);
                clickableAreas = getClickableAreas(new ClickableArea(328, 380, 150, 150, 2));

                mess = "Suction valve opens.";
                showMessage(mess);

                break;
            case 2:
                image.setImageResource(R.drawable.pointc);
                clickableAreas = getClickableAreas(new ClickableArea(676, 397, 150, 150, 3));

                mess = "Discharge valve opens.";
                showMessage(mess);

                break;
            case 3:
                image.setImageResource(R.drawable.pointd);
                clickableAreas = getClickableAreas(new ClickableArea(587, 34, 150, 150, 4));

                mess = "Overload valve for combined air/brine ejector opens.";
                showMessage(mess);

                break;
            case 4:
                image.setImageResource(R.drawable.pointe);
                clickableAreas = getClickableAreas(new ClickableArea(970, 144, 150, 150, 5));

                mess = "Air valve closes.";
                showMessage(mess);

//                new Handler().postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        image.setImageResource(R.drawable.pointmm);
//                        mess = "You are done with the starting procedure.";
//                        showMessage(mess);
//                    }
//                }, 3000);


                break;
            case 5:
                image.setImageResource(R.drawable.pointf);
                gyroAnimation = (AnimationDrawable) image.getDrawable();
                gyroAnimation.start();
                clickableAreas = getClickableAreas(new ClickableArea(912, 86, 150, 150, 6));

                mess = "Main switch has set to position 1 which results in power supply for the fresh water generator.";
                showMessage(mess);

                break;
            case 6:
                image.setImageResource(R.drawable.pointg);
                clickableAreas = getClickableAreas(new ClickableArea(140, 275, 150, 150, 7));

                mess = "Sea water will pass through the condenser and overboard valve.";
                showMessage(mess);

                break;
            case 7:
                image.setImageResource(R.drawable.pointh);
                clickableAreas = getClickableAreas(new ClickableArea(140, 209, 150, 150, 8));

                mess = "Hot water inlet from the jacket cooling system opens.";
                showMessage(mess);

                break;
            case 8:
                image.setImageResource(R.drawable.pointi);
                clickableAreas = getClickableAreas(new ClickableArea(93, 245, 150, 150, 9));

                mess = "Hot water outlet from the jacket cooling system opens. Changes in the vacuum occurs, it decreases a little bit.";
                showMessage(mess);

                break;
            case 9:
                image.setImageResource(R.drawable.pointj);
                gyroAnimation = (AnimationDrawable) image.getDrawable();
                gyroAnimation.start();
                clickableAreas = getClickableAreas(new ClickableArea(970, 86, 150, 150, 10));

                mess = "Fresh water will be generated as required.";
                showMessage(mess);

                break;
            case 10:
                image.setImageResource(R.drawable.pointk);
                clickableAreas = getClickableAreas(new ClickableArea(812, 130, 150, 150, 11));

                mess = "Fresh water pump opens.";
                showMessage(mess);

                break;
            case 11:
                image.setImageResource(R.drawable.pointl);
                clickableAreas = getClickableAreas(new ClickableArea(0, 0, 0, 0, 12));

                mess = "Alarm opens.";
                showMessage(mess);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        image.setImageResource(R.drawable.pointm);
                        gyroAnimation = (AnimationDrawable) image.getDrawable();
                        gyroAnimation.start();
                        mess = "You are done with the starting procedure.";
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