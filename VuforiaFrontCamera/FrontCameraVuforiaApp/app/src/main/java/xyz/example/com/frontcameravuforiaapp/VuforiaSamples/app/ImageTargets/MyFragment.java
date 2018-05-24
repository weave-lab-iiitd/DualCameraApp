package xyz.example.com.frontcameravuforiaapp.VuforiaSamples.app.ImageTargets;

import android.annotation.SuppressLint;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

@SuppressLint("ValidFragment")
public class MyFragment extends Fragment {

    private final GLSurfaceView mFragGLView;

    public MyFragment(GLSurfaceView glView) {
        super();
        mFragGLView = glView;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return mFragGLView;
    }

    @Override
    public void onPause() {
        super.onPause();
        mFragGLView.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        mFragGLView.onResume();
    }

}