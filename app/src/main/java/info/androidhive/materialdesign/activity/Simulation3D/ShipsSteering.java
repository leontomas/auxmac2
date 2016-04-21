package info.androidhive.materialdesign.activity.Simulation3D;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.PixelFormat;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.TextView;

import com.threed.jpct.Camera;
import com.threed.jpct.FrameBuffer;
import com.threed.jpct.Light;
import com.threed.jpct.Loader;
import com.threed.jpct.Logger;
import com.threed.jpct.Matrix;
import com.threed.jpct.Object3D;
import com.threed.jpct.RGBColor;
import com.threed.jpct.SimpleVector;
import com.threed.jpct.Texture;
import com.threed.jpct.TextureInfo;
import com.threed.jpct.TextureManager;
import com.threed.jpct.World;
import com.threed.jpct.util.BitmapHelper;
import com.threed.jpct.util.MemoryHelper;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;

import javax.microedition.khronos.opengles.GL10;

import info.androidhive.materialdesign.R;
import info.androidhive.materialdesign.activity.Model;

public class ShipsSteering extends Activity {
    // Used to handle pause and resume...
    private static ShipsSteering master = null;
    AssetManager assMan;
    InputStream is;
    ProgressDialog pd;
    private Matrix matrix = new Matrix();
    private float scale = 1f;
    private ScaleGestureDetector SGD;
    private GLSurfaceView mGLView, surfaceViewShipsSteering;
    private MyRenderer renderer = null;
    private FrameBuffer fb = null;
    private World world = null;
    private RGBColor back = new RGBColor(0, 0, 0, 0);
    private float touchTurn = 0;
    private float touchTurnUp = 0;
    private float xpos = -1;
    private float ypos = -1;
    private Object3D cube = null;
    private int fps = 0;
    private Light sun = null;
    private String thingName = "shipssteering";
    private float thingScale = 0.1f;//end
    private Camera cam;
    private Object3D o3d;
    private TextView txtName, txtTitle;
    private String name, title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_view);

        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        title = intent.getStringExtra("title");
        txtName = (TextView) findViewById(R.id.txtName);
        txtTitle = (TextView) findViewById(R.id.txtTitle);
        txtName.setText(name);
        txtTitle.setText(title);


        Logger.log("onCreate");

//        if (master != null) {
//            copy(master);
//        } else {
//            pd.show();
//        }
        if (pd == null) {
            pd = new ProgressDialog(ShipsSteering.this);
            pd.setMessage("Loading model...");
            pd.setCancelable(false);
            pd.setCanceledOnTouchOutside(false);
            pd.show();
        }

        SGD = new ScaleGestureDetector(ShipsSteering.this, new ScaleListener());

//        super.onCreate(savedInstanceState);
//        mGLView = new GLSurfaceView(getApplication());
        surfaceViewShipsSteering = (GLSurfaceView) findViewById(R.id.surfaceViewShipsSteering);
        surfaceViewShipsSteering.setVisibility(View.VISIBLE);
        surfaceViewShipsSteering.setZOrderOnTop(true);
        surfaceViewShipsSteering.setEGLConfigChooser(8, 8, 8, 8, 16, 0);
        surfaceViewShipsSteering.getHolder().setFormat(PixelFormat.TRANSLUCENT);
//        surfaceViewShipsSteering.setEGLConfigChooser(new GLSurfaceView.EGLConfigChooser() {
//
//            public EGLConfig chooseConfig(EGL10 egl, EGLDisplay display) {
//                // Ensure that we get a 16bit framebuffer. Otherwise, we'll fall
//                // back to Pixelflinger on some device (read: Samsung I7500)
//                int[] attributes = new int[]{EGL10.EGL_DEPTH_SIZE, 16, EGL10.EGL_NONE};
//                EGLConfig[] configs = new EGLConfig[1];
//                int[] result = new int[1];
//                egl.eglChooseConfig(display, attributes, configs, 1, result);
//                return configs[0];
//            }
//        });

        renderer = new MyRenderer();
        surfaceViewShipsSteering.setRenderer(renderer);
//        setContentView(mGLView);

    }

    @Override
    protected void onPause() {
        super.onPause();
//        surfaceViewShipsSteering.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
//        surfaceViewShipsSteering.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        master = null;
        TextureManager.getInstance().addTexture("texture");

        Intent i = new Intent(ShipsSteering.this, Model.class);
        startActivity(i);
        finish();
    }

    private void copy(Object src) {
        try {
            Logger.log("Copying data from master Activity!");
            Field[] fs = src.getClass().getDeclaredFields();
            for (Field f : fs) {
                f.setAccessible(true);
                f.set(this, f.get(src));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean onTouchEvent(MotionEvent me) {
        if (me.getPointerCount() == 2) {
            SGD.onTouchEvent(me);
        } else {


            if (me.getAction() == MotionEvent.ACTION_DOWN) {
                xpos = me.getX();
                ypos = me.getY();
                return true;
            }

            if (me.getAction() == MotionEvent.ACTION_UP) {
                xpos = -1;
                ypos = -1;
                touchTurn = 0;
                touchTurnUp = 0;
                return true;
            }

            if (me.getAction() == MotionEvent.ACTION_MOVE) {
                float xd = me.getX() - xpos;
                float yd = me.getY() - ypos;

                xpos = me.getX();
                ypos = me.getY();

                touchTurn = xd / -100f;
                touchTurnUp = yd / -100f;
                return true;
            }
//
//        SGD.onTouchEvent(me);

            try {
                Thread.sleep(15);
            } catch (Exception e) {
                // No need for this...
            }
        }

        return super.onTouchEvent(me);
    }

    protected boolean isFullscreenOpaque() {
        return true;
    }


    class MyRenderer implements GLSurfaceView.Renderer {

        private long time = System.currentTimeMillis();
        private ScaleGestureDetector SGD;

        public MyRenderer() {
        }

        @Override
        public void onSurfaceCreated(GL10 gl, javax.microedition.khronos.egl.EGLConfig config) {

        }

        public void onSurfaceChanged(GL10 gl, int w, int h) {
            if (fb != null) {
                fb.dispose();
            }
            fb = new FrameBuffer(gl, w, h);

            if (master == null) {

                world = new World();
                world.setAmbientLight(20, 20, 20);

                sun = new Light(world);
                sun.setIntensity(250, 250, 250);

                // Create a texture out of the icon...:-)
                Texture shiptexture = new Texture(BitmapHelper.rescale(BitmapHelper.convert(getResources().getDrawable(R.drawable.gray)), 256, 256));
                TextureManager.getInstance().addTexture("ship", shiptexture);
                TextureInfo ti = new TextureInfo(TextureManager.getInstance().getTextureID("ship"));

                InputStream stream = null;
                try {
                    stream = getResources().getAssets().open(thingName + ".3ds");
                } catch (IOException e) {
                    e.printStackTrace();
                }


                try {
//                    cube = loadModel(stream, thingScale);
                    cube = Object3D.mergeAll(Loader.load3DS(stream, thingScale));
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                cube.setTexture(ti);
               // cube.setScale(0.60f);
                //cube.rotateX(300f);

                //Primitives.getCube(10);
                //cube.calcTextureWrapSpherical();
                //cube.setTexture("texture");
                //cube.strip();
                cube.build();
                world.addObject(cube);

                cam = world.getCamera();
                cam.moveCamera(Camera.CAMERA_MOVEOUT, 50);
                cam.lookAt(cube.getTransformedCenter());

                SimpleVector sv = new SimpleVector();
                sv.set(cube.getTransformedCenter());
                sv.y -= 50;
                sv.z -= 50;
                sun.setPosition(sv);
                MemoryHelper.compact();

                pd.dismiss();
                if (master == null) {
                    Logger.log("Saving master Activity!");
                    master = ShipsSteering.this;
                }
            }
        }


        public void onDrawFrame(GL10 gl) {
            if (touchTurn != 0) {
                cube.rotateY(touchTurn);
                touchTurn = 0;
            }

            if (touchTurnUp != 0) {
                cube.rotateX(touchTurnUp);
                touchTurnUp = 0;
            }

            fb.clear(back);
            world.renderScene(fb);
            world.draw(fb);
            fb.display();

            if (System.currentTimeMillis() - time >= 1000) {
                Logger.log(fps + "fps");
                fps = 0;
                time = System.currentTimeMillis();
            }
            fps++;
        }

        public void setZoom(float scale) {
            cube.setScale(scale);
        }

        private Object3D loadModel(InputStream stream, float scale) throws UnsupportedEncodingException {

//
            Object3D[] model = Loader.load3DS(stream, scale);

            o3d = new Object3D(0);
            Object3D temp = null;
            for (int i = 0; i < model.length; i++) {
                temp = model[i];
                temp.setCenter(SimpleVector.ORIGIN);
                temp.rotateX((float) (-.5 * Math.PI));
                temp.rotateMesh();
                temp.setRotationMatrix(new Matrix());
                o3d = Object3D.mergeObjects(o3d, temp);
                o3d.build();
            }

            return o3d;
        }

    }

    private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {

        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            scale *= detector.getScaleFactor();
            scale = Math.max(0.1f, Math.min(scale, 5.0f));
//
//
////            matrix.setScale(scale, scale);
            float mScaleFactor = detector.getScaleFactor();

            // Don't let the object get too small or too large.
            mScaleFactor = Math.max(1.0f, Math.min(mScaleFactor, 10.0f));

            // pass it to your renderer
            renderer.setZoom(scale);
            Log.d("SCALE", Float.toString(mScaleFactor));

            return true;
        }
    }
}
