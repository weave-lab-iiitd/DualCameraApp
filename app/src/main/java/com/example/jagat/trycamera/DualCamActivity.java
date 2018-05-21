package com.example.jagat.trycamera;


import android.content.res.Configuration;
import android.hardware.Camera;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.widget.FrameLayout;
public class DualCamActivity extends Activity {

    private Camera mBackCamera;
    private Camera mFrontCamera;
    private BackCameraPreview mBackCamPreview;
    private FrontCameraPreview mFrontCamPreview;
    private CameraManager camManager;

    public static String TAG = "DualCamActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int orientation = this.getResources().getConfiguration().orientation;
        Log.d(TAG,new Integer(orientation).toString());
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            setContentView(R.layout.activity_dual_cam);
        } else {
            setContentView(R.layout.activity_dual_cam_land);
        }

        Log.i(TAG, "Number of cameras: " + Camera.getNumberOfCameras());

        // Create an instance of Camera
        mBackCamera = getCameraInstance(0);
        // Create back camera Preview view and set it as the content of our activity.
        mBackCamPreview = new BackCameraPreview(this, mBackCamera);
        FrameLayout backPreview = findViewById(R.id.back_camera_preview);
        backPreview.addView(mBackCamPreview);

        mFrontCamera = getCameraInstance(1);
        mFrontCamPreview = new FrontCameraPreview(this, mFrontCamera);
        FrameLayout frontPreview =  findViewById(R.id.front_camera_preview);
        frontPreview.addView(mFrontCamPreview);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.dual_cam, menu);
        return true;
    }


    public static Camera getCameraInstance(int cameraId){
        Camera c = null;
        try {
            c = Camera.open(cameraId); // attempt to get a Camera instance
        }
        catch (Exception e){
            // Camera is not available (in use or does not exist)
            Log.e(TAG,"Camera " + cameraId + " not available! " + e.toString() );
        }
        return c; // returns null if camera is unavailable
    }
}
