/**
 * *1) Необходимо создать Service, который будет запускаться при открытии activity
 * и завершаться при закрытии(можно при сворачивании).
 * Внутри сервиса вам нужно будет сделать подписку на BroadcastReceiver,
 * так чтобы вы ловили события включения/выключения wifi.
 * В итоге у вас будет так: запускается активити -> запускается сервис
 * -> внутри сервиса делается подписка на события BroadcastReceiver,
 * далее если вы меняете статус wifi,
 * то в логах например пишите сообщения включился или выключился wifi.
 * Далее пользователь закрывает активити -> сервис завершается -> отписываемся от BroadcastReceiver.
 * Если не отпишитесь от BroadcastReceiver, то будет утечка памяти.
 * *2) Необязательное задание.(sktl не сделал)
 * На основе предыдущего задания добавьте отсылку собственных сообщений из сервиса в активити.
 * Например при изменении статуса wifi, вы будите посылать в активити слова “On”/”Off”.
 * Понятное дело, что можно сразу в активити подписываться на BroadcastReceiver,
 * но тут идея что бы вы сами сгенерировали событие в сервисе, и сами словили это событие в активити.
 */


package com.example.user_pc.testsktl.homework5;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.user_pc.testsktl.classwork5.MyServiceSktl;

/**
 * Created by USER-PC on 03.08.2017.
 */

public class HW5Activity extends Activity {



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        startService(new Intent(this, SktlServiceOnBCR.class));
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
//        SktlBroadcastReceiverCheckWiFi broadcastReceiverCheckWiFi = new SktlBroadcastReceiverCheckWiFi();
        stopService(new Intent(this, SktlServiceOnBCR.class));
        Log.d("Sktl_HW5Activity", "по идее должен остановиться SktlServiceOnBCR");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
