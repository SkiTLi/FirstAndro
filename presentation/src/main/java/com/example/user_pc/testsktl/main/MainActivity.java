package com.example.user_pc.testsktl.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.example.user_pc.testsktl.R;
import com.example.user_pc.testsktl.classwork12.Classwork12Activity;
import com.example.user_pc.testsktl.classwork13.Classwork13Activity;
import com.example.user_pc.testsktl.classwork14.Classwork14Activity;
import com.example.user_pc.testsktl.classwork2.Classwork2Activity;
import com.example.user_pc.testsktl.classwork3.Classwork3Activity;
import com.example.user_pc.testsktl.classwork4.Classwork4Activity;
import com.example.user_pc.testsktl.classwork5.Classwork5Activity;
import com.example.user_pc.testsktl.classwork6.Classwork6Activity;
import com.example.user_pc.testsktl.classwork7.Classwork7Activity;
import com.example.user_pc.testsktl.classwork8.Classwork8Activity;
import com.example.user_pc.testsktl.classwork9_10_11.Classwork9Activity;
import com.example.user_pc.testsktl.homework1.Dz1Activity;
import com.example.user_pc.testsktl.homework10_timer.HW10Activity;
import com.example.user_pc.testsktl.homework11_profiles.HW11Activity;
import com.example.user_pc.testsktl.homework2.HW2Activity;
import com.example.user_pc.testsktl.homework3_glide.HW3Activity;
import com.example.user_pc.testsktl.homework4.HW4Activity;
import com.example.user_pc.testsktl.homework5.HW5Activity;
import com.example.user_pc.testsktl.homework6_gallery.HW6Activity;
import com.example.user_pc.testsktl.homework7_mvvm.HW7Activity;
import com.example.user_pc.testsktl.homework9_new_gallery.HW9Activity;

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


// решит за нас какая версия андроида для разреения (permission )ContextCompat


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


        Button classWork4Button = (Button) findViewById(R.id.classwork4Button);
        classWork4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //переход на новую активити

                //нужно указать MainActivity. иначе ошибка т.к. находимся в анонимном классе
                Intent intent = new Intent(MainActivity.this, Classwork4Activity.class);
                //анимация только на открыти
//                overridePendingTransition(R.anim.dsfdsfsdfs, R.anim.dfdsfs;//здесь описна анимация
                startActivity(intent);


            }
        });

        Button homeWork4Button = (Button) findViewById(R.id.homework4Button);
        homeWork4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HW4Activity.class);
                startActivity(intent);
                //это анимация по смене MainActivity.this на HW4Activity.class
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
            }
        });


        Button classWork5Button = (Button) findViewById(R.id.classwork5Button);
        classWork5Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Classwork5Activity.class);
                startActivity(intent);
            }
        });

        Button homeWork5Button = (Button) findViewById(R.id.homework5Button);
        homeWork5Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HW5Activity.class);
                startActivity(intent);
            }
        });


        Button classWork6Button = (Button) findViewById(R.id.classwork6Button);
        classWork6Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Classwork6Activity.class);
                startActivity(intent);
            }
        });

        Button homeWork6Button = (Button) findViewById(R.id.homework6Button);
        homeWork6Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HW6Activity.class);
                startActivity(intent);
            }
        });


        Button classWork7Button = (Button) findViewById(R.id.classwork7Button);
        classWork7Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Classwork7Activity.class);
                startActivity(intent);
            }
        });


        Button homeWork7Button = (Button) findViewById(R.id.homework7Button);
        homeWork7Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HW7Activity.class);
                startActivity(intent);
            }
        });


        Button classWork8Button = (Button) findViewById(R.id.classwork8Button);
        classWork8Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Classwork8Activity.class);
                startActivity(intent);
            }
        });

        Button classWork9Button = (Button) findViewById(R.id.classwork9Button);
        classWork9Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Classwork9Activity.class);
                startActivity(intent);
            }
        });

        Button homeWork9Button = (Button) findViewById(R.id.homework9Button);
        homeWork9Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HW9Activity.class);
                startActivity(intent);
            }
        });

        Button homeWork10Button = (Button) findViewById(R.id.homework10Button);
        homeWork10Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HW10Activity.class);
                startActivity(intent);
            }
        });

        Button homeWork11Button = (Button) findViewById(R.id.homework11Button);
        homeWork11Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HW11Activity.class);
                startActivity(intent);
            }
        });


//        Button classWork12Button = (Button) findViewById(R.id.classwork12Button);
//        classWork12Button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, Classwork12Activity.class);
//                startActivity(intent);
//            }
//        });


        Button classwork12Button = (Button) findViewById(R.id.classwork12Button);
        classwork12Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Classwork12Activity.show(MainActivity.this);
            }
        });

        Button classwork13Button = (Button) findViewById(R.id.classwork13Button);
        classwork13Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Classwork13Activity.show(MainActivity.this);
            }
        });

//        Button classWork13Button = (Button) findViewById(R.id.classwork13Button);
//        classWork13Button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, Classwork14Activity.class);
//                startActivity(intent);
//            }
//        });

        Button classwork14Button = (Button) findViewById(R.id.classwork14Button);
        classwork14Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Classwork14Activity.show(MainActivity.this);
            }
        });

    }

    //для закрытия
    public void onBackPressed() {
        super.onBackPressed();
    }

}

