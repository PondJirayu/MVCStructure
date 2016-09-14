package com.example.lp700.mvcstructure.activity;

import android.os.Build;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.lp700.mvcstructure.R;
import com.example.lp700.mvcstructure.fragment.MainFragment;
import com.example.lp700.mvcstructure.util.ScreenUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ทดลองใช้ Singleton Model
        int screenWidth = ScreenUtils.getInstance().getScreenWidth();
        int screenHeight = ScreenUtils.getInstance().getScreenHeight();

        Toast.makeText(getApplicationContext(),"Width : " + screenWidth + " Height : " + screenHeight, Toast.LENGTH_SHORT).show();

        // Separate by Android Version
        if (Build.VERSION.SDK_INT >= 21){
            // Run on Android 21+

        } else {
            // Run on Android 1-20

        }

        if (savedInstanceState == null){
            // First Created
            // Place Fragment here
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentContainer,
                            MainFragment.newInstance(123),
                            "MainFragment")
                    .commit();
        }
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        if (savedInstanceState == null){
            MainFragment fragment = (MainFragment)
                    getSupportFragmentManager().findFragmentByTag("MainFragment");
            fragment.setHelloText("Woo Hooooooo");
        }
    }
}
