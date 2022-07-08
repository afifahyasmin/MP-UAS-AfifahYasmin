package com.afifah.uas_afifah_yasmin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceView;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import org.opencv.android.BaseLoaderCallback;
import org.opencv.android.CameraBridgeViewBase;
import org.opencv.android.LoaderCallbackInterface;
import org.opencv.android.OpenCVLoader;
import org.opencv.core.CvType;
import org.opencv.core.Mat;

public class CameraActivity extends Activity implements CameraBridgeViewBase.CvCameraViewListener2 {
    private static final String TAG = "CameraActivity";
    private Mat mRgba;
    private Mat mGrey;
    private CameraBridgeViewBase mOpenCVCamera;
    private BaseLoaderCallback mLoaderCallBack = new BaseLoaderCallback(this) {
        @Override
        public void onManagerConnected(int status) {
            switch(status){
                case LoaderCallbackInterface.SUCCESS:{

                    Log.i(TAG, "opencv is loaded");
                    mOpenCVCamera.enableView();
                }
                default:{
                    super.onManagerConnected(status);

                }
                break;
            }
        }
    };
    public CameraActivity(){

        Log.i(TAG, "CameraActivity");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        ActivityCompat.requestPermissions(CameraActivity.this, new String[] {Manifest.permission.CAMERA}, 1);

        setContentView(R.layout.camera_view);
        mOpenCVCamera = (CameraBridgeViewBase) findViewById(R.id.frame_surface);
        mOpenCVCamera.setVisibility(SurfaceView.VISIBLE);
        mOpenCVCamera.setCvCameraViewListener(this);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch(requestCode){
            case 1:{
                if(grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    mOpenCVCamera.setCameraPermissionGranted();
                }else{
                    //permision denied
                }
                return;
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(OpenCVLoader.initDebug()){

            Log.i(TAG, "onResume");
            mLoaderCallBack.onManagerConnected(LoaderCallbackInterface.SUCCESS);
        }else{

            Log.i(TAG, "onResume Gagal");
            OpenCVLoader.initAsync(OpenCVLoader.OPENCV_VERSION, this, mLoaderCallBack);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(mOpenCVCamera != null){
            Log.i(TAG, "onPause");
            mOpenCVCamera.disableView();

        }
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        if(mOpenCVCamera != null){
            Log.i(TAG, "onDestroy");
            mOpenCVCamera.disableView();
        }
    }
    @Override
    public void onCameraViewStarted(int width, int height){
        Log.i(TAG, "onCameraViewStarted lebar = " + width + " tinggi = " + height );
        mRgba = new Mat(height,width, CvType.CV_8UC4);
        mGrey = new Mat(height,width, CvType.CV_8UC1);


    }
    @Override
    public void onCameraViewStopped(){
        Log.i(TAG, "onCameraViewStopped ");

        mRgba.release();
    }
    @Override
    public Mat onCameraFrame(@NonNull CameraBridgeViewBase.CvCameraViewFrame inputFrame){
        Log.i(TAG, "onCameraFrame ");
        mRgba = inputFrame.rgba();
        mGrey = inputFrame.gray();
        return  mGrey;
    }
}
