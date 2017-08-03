package com.example.user_pc.testsktl.classwork6;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.user_pc.testsktl.R;
import com.example.user_pc.testsktl.classwork5.MyIntentService;
import com.example.user_pc.testsktl.classwork5.MyServiceSktl;

/**
 * Created by USER-PC on 26.07.2017.
 */

public class Classwork6Activity extends Activity {
    IntentFilter intentFilter = new IntentFilter();
    private TextView tw;
    int i;

    private BroadcastReceiver receiverSktl = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            Log.e("AAA тестовое сообщ", "onReceive");
//            intentFilter.

        }
    };


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classwork5);
//        здесь прописываеим реивер который работает только во время работы приложеия

        Intent intent = new Intent(Classwork6Activity.this, MyIntentService.class);
        intent.putExtra(MyIntentService.KEY_ACtION, "задание 0");
        startService(intent);

        Intent intent2 = new Intent(Classwork6Activity.this, MyIntentService.class);
        intent2.putExtra(MyIntentService.KEY_ACtION, "задание 2");
        startService(intent2);

        Intent intent3 = new Intent(Classwork6Activity.this, MyIntentService.class);
        intent3.putExtra(MyIntentService.KEY_ACtION, "задание 3");
        startService(intent3);



        tw = (TextView) findViewById(R.id.BC_textView);


//        сервисы нужно запускать. два раза его запустить нельзя


        startService(new Intent(this, MyServiceSktl.class));


//        по нажатию на текс вью будет завершен сервис
        tw.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
//                Intent intent = new Intent (Classwork5Activity.this, MyServiceSktl.class);
//                stopService(intent);


            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();

        intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        intentFilter.addAction(MyIntentService.MY_ACtION); // для получения
//        intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);//можно еще другие события



        registerReceiver(receiverSktl, intentFilter);

Intent intent = new Intent(Classwork6Activity.this, MyServiceSktl.class);

        bindService(intent,serviceConnecion, Context.BIND_AUTO_CREATE);
        i++;
        tw.setText("i = " + i);

    }
    ServiceConnection serviceConnecion = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.e("AAA","onServiceConnected");
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.e("AAA","onServiceDisconnected");
        }
    };
    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(receiverSktl);
        unbindService(serviceConnecion);

    }




//это когда нет анонимного бродкаста
//    private MyBroadcastReceiverSktl receiverSktl = new MyBroadcastReceiverSktl();
}