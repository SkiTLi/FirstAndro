package com.example.user_pc.testsktl.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.example.user_pc.testsktl.R;
import com.example.user_pc.testsktl.classwork2.Classwork2Activity;
import com.example.user_pc.testsktl.homework1.Dz1Activity;

/**
 * Created by USER-PC on 26.07.2017.
 */

public class MainActivity extends Activity {

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

        Button classwork2Button = (Button) findViewById(R.id.classwork2Button);

        classwork2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //переход на новую активити

                //нужно указать MainActivity. иначе ошибка т.к. находимся в анонимном классе
                Intent intent = new Intent(MainActivity.this, Classwork2Activity.class);
                startActivity(intent);


            }
        });
    }
}
