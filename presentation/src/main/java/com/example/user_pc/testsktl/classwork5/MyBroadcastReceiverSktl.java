package com.example.user_pc.testsktl.classwork5;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by USER-PC on 02.08.2017.
 */

public class MyBroadcastReceiverSktl extends BroadcastReceiver {
    @Override

//    здесь нельзя делать серьезные действия тк огранич время выполнения
//    здесь еще для натификейшн
    public void onReceive(Context context, Intent intent) {
        Log.e("AAA тестовое сообщ", "onReceive");

    }
}
