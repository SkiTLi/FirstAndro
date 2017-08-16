package com.example.user_pc.testsktl.homework5;

import android.app.AlarmManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.util.Log;

/**
 * Created by USER-PC on 02.08.2017.
 */

public class SktlBroadcastReceiverCheckWiFi extends BroadcastReceiver {
    @Override

//    здесь нельзя делать серьезные действия тк огранич время выполнения

    public void onReceive(Context context, Intent intent) {
        Log.d("SktlBCRCheckNetwork", "что-то произошло с сетью.(я не знаю как определить включен ли мобильный интернет)");

        WifiManager wifi = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        if (wifi.isWifiEnabled()){
            Log.d("SktlWiFiStatus", "по идее должен быть включен WiFi");
        }else{
            Log.d("SktlWiFiStatus", "по идее должен быть выключен WiFi");
        }
    }


}
