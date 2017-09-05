package com.example.user_pc.testsktl.classwork14;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.user_pc.testsktl.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by USER-PC on 26.07.2017.
 */


public class Classwork14Activity extends FragmentActivity {


    //это  butterknife
    @BindView(R.id.editText)
    EditText editText;

    @BindView(R.id.button14)//d kotlin button14 сразу будет, ее не нужно инициализировать
            Button button;
    //сохраняет инфу в xml файлик
    SharedPreferences preferences;
    private static final String SHARED_PREFERENCIS = "Name_of_your_xml_file";
    private static final String KEY_NAME = "лKEY_NAMEр";


    public static void show(Activity activity) {
        Intent intent = new Intent(activity, Classwork14Activity.class);
        activity.startActivity(intent);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classwork14);

        ButterKnife.bind(this);
        // editText = (EditText) findViewById(R.id.editText);//это эквивалентно butterknife
        // editText.setText("вот пробныый текст");
        // getCacheDir()//метод для поиска папки для сохранения нпример текста
        //можно создать assert dir и туда ложить свои файлы
//        getAssets()//возможно assert

        preferences = getSharedPreferences(SHARED_PREFERENCIS, Context.MODE_PRIVATE);


        //вешаем клик
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //сохраняем текст из EditText в sharedprefernce
                preferences.edit().
                        putString(KEY_NAME, String.valueOf(editText.getText()))
                        .apply();
            }
        });
        //берем данные из SharedPreferences которые сохранили и задаем их в editText

        String data = preferences.getString(KEY_NAME, null);
        if (data != null) {
            editText.setText(data);
        }
    }
}

