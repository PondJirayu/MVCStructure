package com.example.lp700.mvcstructure.activity;

import android.os.Build;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.lp700.mvcstructure.R;
import com.example.lp700.mvcstructure.fragment.MainFragment;
import com.example.lp700.mvcstructure.fragment.SecondFragment;
import com.example.lp700.mvcstructure.util.ScreenUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ทดลองใช้ Singleton Model
        int screenWidth = ScreenUtils.getInstance().getScreenWidth();
        int screenHeight = ScreenUtils.getInstance().getScreenHeight();

        Toast.makeText(getApplicationContext(), "Width : " + screenWidth + " Height : " + screenHeight, Toast.LENGTH_SHORT).show();

        // Separate by Android Version
        if (Build.VERSION.SDK_INT >= 21) {
            // Run on Android 21+

        } else {
            // Run on Android 1-20

        }

        // แปะ Fragment ที่ Activity  -- Fragment แปะครั้งแรกครั้งเดียวไม่ต้องแปะซ้ำ ระบบจะจัดการให้ตอนที่ Activity เกิดใหม่
        if (savedInstanceState == null) { // แปะตอนที่ Activity ถูกสร้างขึ้นมาครั้งแรก
            // First Created
            // Place Fragment here
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentContainer,
                            MainFragment.newInstance(123),
                            "MainFragment")
                    .commit();

            SecondFragment secondFragment = SecondFragment.newInstance();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentContainer,
                            secondFragment,
                            "SecondFragment")
                    .detach(secondFragment)
                    .commit();

            // Try Crash
//            MainFragment fragment = (MainFragment)
//                    getSupportFragmentManager().findFragmentByTag("MainFragment");
//            fragment.setHelloText("Woo Hooooooo");
        }
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        if (savedInstanceState == null) {
            MainFragment fragment = (MainFragment)
                    getSupportFragmentManager().findFragmentByTag("MainFragment");
            fragment.setHelloText("Woo Hooooooo\nWoo Hooooooo\\Woo Hooooooo\\Woo Hooooooo\\Woo Hooooooo\\Woo Hooooooo\\Woo Hooooooo\\Woo Hooooooo\\Woo Hooooooo\\Woo Hooooooo\\Woo Hooooooo\\Woo Hooooooo\\Woo Hooooooo\\Woo Hooooooo\\Woo Hooooooo\\Woo Hooooooo\\Woo Hooooooo\\Woo Hooooooo\\");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_second_fragment: {

                Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.contentContainer); // ค้นหา fragment ตัวที่อยู่บนสุด

                if (!(fragment instanceof SecondFragment)) {
                    getSupportFragmentManager().beginTransaction()
//                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                            .setCustomAnimations(R.anim.from_right, R.anim.to_left, R.anim.from_left, R.anim.to_right)
                            .replace(R.id.contentContainer, SecondFragment.newInstance())
                            .addToBackStack(null)
                            .commit();
                }

                Toast.makeText(MainActivity.this, "Second Fragment", Toast.LENGTH_SHORT).show();
                return true;
            }
            case R.id.action_first_tab: {
                MainFragment mainFragment = (MainFragment)
                        getSupportFragmentManager().findFragmentByTag("MainFragment");
                SecondFragment secondFragment = (SecondFragment)
                        getSupportFragmentManager().findFragmentByTag("SecondFragment");

                getSupportFragmentManager().beginTransaction()
                        .attach(mainFragment)
                        .detach(secondFragment)
                        .addToBackStack(null)
                        .commit();
                return true;
            }
            case R.id.action_second_tab: {
                MainFragment mainFragment = (MainFragment)
                        getSupportFragmentManager().findFragmentByTag("MainFragment");
                SecondFragment secondFragment = (SecondFragment)
                        getSupportFragmentManager().findFragmentByTag("SecondFragment");

                getSupportFragmentManager().beginTransaction()
                        .attach(secondFragment)
                        .detach(mainFragment)
                        .addToBackStack(null)
                        .commit();
                return true;
            }

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
