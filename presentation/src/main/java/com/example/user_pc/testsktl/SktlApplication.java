package com.example.user_pc.testsktl;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;


/**
 * Created by USER-PC on 31.07.2017.
 */

public class SktlApplication extends Application {


    //здесь все инициализируется единожды при старте приложения
    //глобальный контеккст
    @Override public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
        // Normal app init code...
 
    }

}
