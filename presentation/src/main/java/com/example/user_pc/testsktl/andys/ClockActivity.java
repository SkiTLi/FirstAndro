/**
 * *1) Необходимо сделать анимацию перехода между двумя активити.
 * Тип анимации любой. Например текущая активити улетает влево,
 * а новая появляется справа.
 * *2) Ваша задача:
 * Скачать по следующей ссылке изображения Совы и добавить их в проект (xxhdpi):
 * https://www.dropbox.com/s/3awd77n3corpi5a/sova-xxhdpi.zip?dl=0
 * Далее вам необходимо отобразить Сову на экране используя ImageView.
 * Затем создать анимацию так, чтобы был вид как будто Сова моргает.
 * *3) Необходимо создать собственную View.
 * Т. е. Вам необходимо создать класс и наследоваться от класса View.
 * Затем используя метод onDraw() и другие по необходимости
 * нарисовать на экране часы (аналоговые).
 * На часах должны быть черточки для каждого раздела времени (1,2, 3 часа и т. д,),
 * цифры для чисел 12, 3, 6 и 9, а также стрелки для часов и минут.
 * Часы должны показывать текущее время,
 * делать отслеживание времени и изменение часов на экране не обязательно,
 * главное показать то время, которые было на момент открытия часов.
 * Дизайн часов может быть любой на ваш вкус.
 * Для того чтобы облегчить себе жизнь, обратите внимание на метод rotate(),
 * который есть у canvas, он позволяет ворочить view по градусам,
 * что то вроде того как вы бы крутили лист бумаги по кругу относительно центра,
 * это позволит вам всегда рисовать черточки и цифры по одним и тем же координатам
 * но двигая по кругу canvas получится эффект, что все нарисовано по кругу.
 * Если кто то хочет сделать это задание более круто,
 * то добавьте сюда еще секундную стрелку и сделайте изменение времени на экране,
 * т. е. чтобы было видно как двигаются стрелки в зависимости от текущего времени.
 * Также в центр часов можно попробовать добавить мигающую сову
 * из предыдущего задания.
 */

package com.example.user_pc.testsktl.andys;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user_pc.testsktl.R;

import java.util.ArrayList;
import java.util.List;

import static java.security.AccessController.getContext;

public class ClockActivity extends Activity {
    Thread thread;
    private TextView clockTextView;
    private TextView textView;
    private SktlClockView clockView;
    private List<View> listOfButtons;
    private String str;

    public static void show(Activity activity) {
        Intent intent = new Intent(activity, ClockActivity.class);
        activity.startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {


                    while (!thread.isInterrupted()) {
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                setContentView(R.layout.activity_clock_4_johny);
                                clockTextView = (TextView) findViewById(R.id.clock_textView);
                                clockView = (SktlClockView) findViewById(R.id.clock_View);

                                clockTextView.setText("listofbuttons = "

                                        + "now "
                                        + clockView.timeHour
                                        + " : "
                                        + clockView.timeMin
                                        + " : "
                                        + clockView.timeSec);
                            }
                        });
                    }
                } catch (Exception e) {
                    Log.d("sktl", "ошибка в потоке когда запустили часы " + e);
                }
            }
        });
        thread.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (thread.isAlive()) {
            thread.interrupt();
        }
    }
}
