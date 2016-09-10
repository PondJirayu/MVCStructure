package com.example.lp700.mvcstructure.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.lp700.mvcstructure.R;
import com.example.lp700.mvcstructure.util.ScreenUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int screenWidth = ScreenUtils.getInstance().getScreenWidth();
        int screenHeight = ScreenUtils.getInstance().getScreenHeight();

//        ScreenUtils.getInstance().setX(5);
//        int x = ScreenUtils.getInstance().getX();

        Toast.makeText(MainActivity.this,"Width : " + screenWidth + " Height : " + screenHeight, Toast.LENGTH_SHORT).show();
    }
}
