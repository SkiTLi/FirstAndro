package com.example.user_pc.testsktl.classwork5;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by USER-PC on 02.08.2017.
 */

//внутри сервиса работает то что должно работать в фоне
//по умолчанию в UI потоке, но можно задать определенные параметры
//    сервис прописывается в маниесте
public class MyServiceSktl extends Service {


//    binds дописал или нет

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("AAA", "onCreate");
//        stopService();//cfv себя останавливает
    }


    //    второй способ запустить сервис
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.e("AAA", "onBind");
        return null;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.e("AAA", "onUnbind");

        return super.onUnbind(intent);
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("AAA", "onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.e("AAA", "onDestroy");
        super.onDestroy();
    }
}
