package xyz.example.com.frontcameravuforiaapp.VuforiaSamples.app.ImageTargets;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;

import xyz.example.com.frontcameravuforiaapp.R;


public class DualCamera extends AppCompatActivity {

    private static final String TAG="DualCamera";
    private Button Change;
    private int flag;
    private String mClassToLaunch;
    private String mClassToLaunchPackage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Change= findViewById(R.id.changeView);
        flag=0;
        if(savedInstanceState==null){
            firstView();
        }
       /* Change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DualCamera.this,"Wait Changing view",Toast.LENGTH_SHORT).show();
            }
        });*/
    }
    public void firstView(){

        Log.d(TAG,"Umesh You are inside the DualCamera App--1");

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.front_camera_container, FrontCamera.newInstance())
                .commit();
        Log.d(TAG,"Umesh You are inside the DualCamera App--2");
    }
}
