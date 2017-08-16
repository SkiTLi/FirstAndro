/**
 * Нужно с помощью разных элементов (LinearLayout, FrameLayout и т. д.)
 * создать интерфейс в виде флагов нескольких государств.
 * Т.е. создайте активити в которой по очереди нарисованы флаги следующий стран:
 * Австрия, Польша, Италия, Колумбия, Мадагаскар, Таиланд и Дании.
 * Вам нужно задать такую разметку,
 * чтобы указав background нужного цвета в элементе получился флаг нужной страны.
 * Также необходимо использовать элемент ScrollView чтобы вместились все флаги по очереди сверху вниз.
 * Флаги должны корректно отображаться на различных разрешениях экрана телефона.
 */

package com.example.user_pc.testsktl.homework2;

import android.app.Activity;
import android.os.Bundle;

import com.example.user_pc.testsktl.R;


public class HW2Activity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hw2_flags);
    }


    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onRestart() {//может не вызываться
        super.onRestart();
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
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
