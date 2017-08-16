package com.example.user_pc.testsktl.classwork7;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableField;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.user_pc.testsktl.R;
import com.example.user_pc.testsktl.databinding.ActivityClasswork7Binding;



/**
 * Created by USER-PC on 26.07.2017.
 */

public class Classwork7Activity extends Activity {

    private Thread threadCW7;
    public ObservableField<String> myText = new ObservableField<>("ура все работает");//на обсервбл нужно подписыватьс яна изменения, а потом отписываться

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_classwork7);//нужно удалить

        ActivityClasswork7Binding binding = DataBindingUtil.setContentView(this, R.layout.activity_classwork7);
        binding.setActivity(this);//передает myText строчку передает в xml//биндинг-это геттер кторый заменяет все переменные в xml
        binding.superTextView.setText("или вот сразу забить текст");
    }


    @Override
    protected void onResume() {
        super.onResume();

        threadCW7 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 6; i++) {
                    final int a = i;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Log.e("AAA", e.toString());
                    }
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            myText.set(String.valueOf(a));
                        }
                    });
                }
            }
        });
        threadCW7.start();
    }

}
