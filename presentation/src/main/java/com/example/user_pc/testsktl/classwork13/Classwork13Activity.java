package com.example.user_pc.testsktl.classwork13;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
//именно в android.support. должен лежать  fragment
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.example.user_pc.testsktl.R;


/**
 * Created by USER-PC on 26.07.2017.
 */


//Fragment добавлять в манифест не нужно
public class Classwork13Activity extends FragmentActivity {

    public static void show(Activity activity) {
        Intent intent = new Intent(activity, Classwork13Activity.class);
        activity.startActivity(intent);
    }

    //bundle это то же что и intent только здесь не передается инфа
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classwork13);

        //FragmentManager fragmentManager = getSupportFragmentManager();//вынисли в отдельный метод
        //FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();//вынисли в отдельный метод
        //тразакция - этосписок операций только после прохождения полного перчня этих операций транзакция считается успешной

        if (savedInstanceState == null) {
            showFragment(getSupportFragmentManager(), new Classwork13Fragment(), false);
        }
        findViewById(R.id.fragment_button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFragment(getSupportFragmentManager(),
                        Classwork13Fragment.newInstance(getSupportFragmentManager(),
                                "какой-то текст где-то в 13 уроке"), true);
            }
        });

        findViewById(R.id.fragment_button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFragment(getSupportFragmentManager(),
                        new Classwork13SecondFragment(), true);
            }
        });
    }

    public static void showFragment(FragmentManager fragmentManager, Fragment fragment, boolean addToBackStack) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment, fragment.getClass().getName());
        if (addToBackStack) fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();//выполнить
    }
    //addToBackStack //позволяет сохранить состояниие, те будет работать кнопка назад

}

