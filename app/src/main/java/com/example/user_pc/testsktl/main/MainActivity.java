package com.example.user_pc.testsktl.main;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.example.user_pc.testsktl.R;
import com.example.user_pc.testsktl.classwork2.Classwork2Activity;
import com.example.user_pc.testsktl.classwork3.Classwork3Activity;
import com.example.user_pc.testsktl.homework1.Dz1Activity;
import com.example.user_pc.testsktl.homework2.HW2Activity;
import com.example.user_pc.testsktl.homework3.HW3Activity;
import com.squareup.leakcanary.LeakCanary;

/**
 * Created by USER-PC on 26.07.2017.
 */

public class MainActivity extends Activity {




//    //подключили к проекту LeakCanary или не подключили)
//    public class ExampleApplication extends Application {
//        @Override
//        public void onCreate() {
//            super.onCreate();
//            LeakCanary.install(this);
//        }
//    }





    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        Button dz1Button = (Button) findViewById(R.id.dz1Button);

        dz1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //переход на новую активити

                //нужно указать MainActivity. иначе ошибка т.к. находимся в анонимном классе
                Intent intent = new Intent(MainActivity.this, Dz1Activity.class);
                startActivity(intent);


            }
        });

        Button classWork2Button = (Button) findViewById(R.id.classwork2Button);

        classWork2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //переход на новую активити

                //нужно указать MainActivity. иначе ошибка т.к. находимся в анонимном классе
                Intent intent = new Intent(MainActivity.this, Classwork2Activity.class);
                startActivity(intent);


            }
        });

        Button homeWork2Button = (Button) findViewById(R.id.hw_2Button);

        homeWork2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //переход на новую активити

                //нужно указать MainActivity. иначе ошибка т.к. находимся в анонимном классе
                Intent intent = new Intent(MainActivity.this, HW2Activity.class);
                startActivity(intent);


            }
        });

        Button classWork3Button = (Button) findViewById(R.id.classwork3Button);
        classWork3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //переход на новую активити

                //нужно указать MainActivity. иначе ошибка т.к. находимся в анонимном классе
                Intent intent = new Intent(MainActivity.this, Classwork3Activity.class);
                startActivity(intent);


            }
        });

        Button homeWork3Button = (Button) findViewById(R.id.homework3Button);
        homeWork3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //переход на новую активити

                //нужно указать MainActivity. иначе ошибка т.к. находимся в анонимном классе
                Intent intent = new Intent(MainActivity.this, HW3Activity.class);
                startActivity(intent);


            }
        });




    }
}
