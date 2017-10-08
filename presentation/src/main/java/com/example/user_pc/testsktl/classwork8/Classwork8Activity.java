package com.example.user_pc.testsktl.classwork8;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;


import com.example.user_pc.testsktl.R;
import com.example.user_pc.testsktl.base.*;
import com.example.user_pc.testsktl.classwork9_10_11.Classwork9Activity;
import com.example.user_pc.testsktl.databinding.ActivityClasswork8Binding;

import static android.R.attr.onClick;

/**
 * Created by USER-PC on 26.07.2017.
 */


//продолжение темы mvvm
public class Classwork8Activity extends BaseActivity {

    //Handler поволяет сделать что-то отложенно
    //системный андроидовский класс кторой позволяет создать отложенную операцию
    private Handler handler;

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            //выполняется через заданное время
        }
    };

    class MyHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            Log.e("SSS", "arg1=" + msg.arg1);
        }
    }


    //это для быстрогоотбражения Classwork9Activity
    public static void show(Activity activity) {
        Intent intent = new Intent(activity, Classwork8Activity.class);
        activity.startActivity(intent);
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        Classwork8ViewModel viewModel = new Classwork8ViewModel(this);// дописали this и переписалитроху класворк8вьюмодел
        this.viewModelInBaseActivity = viewModel;

        ActivityClasswork8Binding binding = DataBindingUtil.setContentView(this, R.layout.activity_classwork8);

        binding.setViewModel(viewModel);//сгенерирована сама
        super.onCreate(savedInstanceState);


        //добавили на последнем занятии

//                binding.superTextView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                .show();
//            }
//        });

//        handler = new Handler();
        handler = new MyHandler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //код который нужно запустить через 3000 милисек.
            }
        }, 3000);

        handler.postDelayed(runnable, 3000);

        //нужно отписаться обязательно, поэтому лучше в другом потоке

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (1 < 10) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Message message = new Message();
                    message.arg1 = 1;
                    handler.sendMessage(message);
                    i++;
                }
            }
        });
        thread.start();


    }

    //добавили на последнем занятии
    protected void onPause() {
        super.onPause();
        handler.removeCallbacks(runnable);

    }
}
