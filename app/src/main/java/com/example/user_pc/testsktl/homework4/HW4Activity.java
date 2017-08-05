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

package com.example.user_pc.testsktl.homework4;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.user_pc.testsktl.BuildConfig;
import com.example.user_pc.testsktl.R;

import java.util.Calendar;

//import com.bumptech.glide.request.RequestOptions;


public class HW4Activity extends Activity {



    AnimationDrawable  mAnimationDrawable;
    private TextView clockTextView;
    private SktlClockView clockView;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hw4_anim);









        clockTextView= (TextView) findViewById(R.id.clock_textView);
        clockView = (SktlClockView) findViewById(R.id.clock_View);
        clockTextView.setText("x = "+clockView.x+", y = "+clockView.y+"," +
                " время = "+clockView.timeHour+ " /*/ "+clockView.timeMin+ " /*/ "+clockView.timeSec);






        ImageView imageView = (ImageView) findViewById(R.id.owl_imageView);
//        imageView.setBackgroundResource(R.drawable.sova_anmation_1);

        mAnimationDrawable = (AnimationDrawable) imageView.getBackground();

        final Button btnStart = (Button) findViewById(R.id.start_button);
        btnStart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mAnimationDrawable.start();
            }
        });

        final Button btnStop = (Button) findViewById(R.id.stop_button);
        btnStop.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mAnimationDrawable.stop();
            }
        });




    }

}
