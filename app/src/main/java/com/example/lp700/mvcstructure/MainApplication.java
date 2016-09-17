package com.example.lp700.mvcstructure;

import android.app.Application;

import com.inthecheesefactory.thecheeselibrary.manager.Contextor;
import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;

/**
 * Created by lp700 on 10/9/2559.
 */
public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Fabric.with(this, new Crashlytics());

        // Initialize thing(s) here
        Contextor.getInstance().init(getApplicationContext()); // การเอา Application Context มาฝากที่ Contextor
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
