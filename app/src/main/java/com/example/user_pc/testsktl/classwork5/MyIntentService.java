package com.example.user_pc.testsktl.classwork5;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by USER-PC on 02.08.2017.
 */

//может получить много заданий и потом по очереди их выполнять
//    после их выполнения са килается

    //создается и работет в отдельном потоке!!!

public class MyIntentService extends IntentService {

    public static final String KEY_ACtION = "KEY_ACtION";
    public static final String MY_ACtION = "com.example.user_pc.testsktl.classwork5.My_Action";

    public MyIntentService() {
        super("MyIntentService");
    }

    public static String getKEY_ACtION() {
        return KEY_ACtION;
    }


    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        String action = intent.getStringExtra(KEY_ACtION);
//        Log.e("AAA", "onHandleIntent action()=" + action);




        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Intent intentReceiver = new Intent(MY_ACtION); //это глобальный ресиверб не локальный
        sendBroadcast(intentReceiver);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("AAA", "oonDestroy() MyIntentService");
    }
}