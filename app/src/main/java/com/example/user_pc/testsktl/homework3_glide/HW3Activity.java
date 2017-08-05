/**
 * *1) Разместить на экране элемент EditText, ImageView и Button.
 * Дизайн и расположение может быть любое - на ваш вкус.
 * В поле EditText будет вводиться ссылка на картинку (например https://goo.gl/oaZVyX).
 * Можете указать ссылку в атрибутах xml EditText или в коде,
 * чтобы для тестирования не вводить каждый раз.
 * Используя одну из библиотек для картинок сделать отображение картинки в ImageView
 * (картинка которая загружается по ссылке).
 * Библиотеку для картинок обязательно подключать ссылкой в Gradle, никаких jar файлов!
 * *2) Подключить библиотеку LeakCanary к проекту.
 * *3) В Gradle добавить переменную String: API_ENDPOINT с любым содержимым
 * так что-бы эту переменную можно было прочитать в коде через класс BuildConfig.
 * Как это сделать есть в статье про Gradle.
 * Содержимое этой переменной выведите на экран - можете вывести на экран с первым заданием про картинки
 * (например в отдельное поле TextView).
 * Напоминаю, что на данный момент у вас в проекте должно быть уже
 * как минимум 4 activity: 3 дз, а также activity на которой 3 кнопки
 * при нажатии на которые происходят переходы к соответствующим дз.
 * *4*)Используя выбранную библиотеку сделайте так, чтобы картинка отображалась круглой,
 * т. е. картинка загружается, а затем с помощью выбранной библиотеки она становится круглой.
 * Это позволяют сделать все библиотеки(ну как минимум все которые я указал)
 * но в каждой из них это делается по своему, поэтому читайте документацию.
 */

package com.example.user_pc.testsktl.homework3_glide;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
//import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.user_pc.testsktl.BuildConfig;
import com.example.user_pc.testsktl.R;


public class HW3Activity extends Activity implements OnClickListener {

    private Button downloadButton;
    private TextView linkImageTextView;
    private TextView gradleStrTextView;

    private String url = "https://images4.alphacoders.com/283/thumb-1920-283338.jpg";
    //    private String url = "https://goo.gl/oaZVyX";
    private ImageView picImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hw3_images);
        linkImageTextView = (TextView) findViewById(R.id.linkImage_textView);
        linkImageTextView.setText(url);
        //// Пример использования BuildConfig
        gradleStrTextView = (TextView) findViewById(R.id.gradleString_textView);

        picImageView = (ImageView) findViewById(R.id.capsol_imageView);
        downloadButton = (Button) findViewById(R.id.download_button);
        //через имплемент интерфейса
        downloadButton.setOnClickListener(this);
    }

    //через имплемент интерфейса
    @Override
    public void onClick(View view) {
        //строка из gradle походу
        gradleStrTextView.setText(BuildConfig.API_ENDPOINT);

        //// (старая версия 3) glide и делает круглой
        Log.d("AAA", this.toString());
        Glide.with(this)
                .load(url)
                .asBitmap()
                .placeholder(R.drawable.ic_cloud_download_black_24dp)//отбражаетя во время загрузки
                .error(R.drawable.ic_error_black_24dp)//заглушка в случае ошибки
                .centerCrop()
                //  .into(picImageView) ;//просто загрузка картинки без скругления
                .into(new BitmapImageViewTarget(picImageView) {
                    @Override
                    protected void setResource(Bitmap resource) {
                        RoundedBitmapDrawable circularBitmapDrawable =
                                RoundedBitmapDrawableFactory.create(HW3Activity.this.getResources(), resource);
                        circularBitmapDrawable.setCircular(true);
                        picImageView.setImageDrawable(circularBitmapDrawable);
                    }
                });


        ////делает картинку круглой (новая версия 4) но без заглушек
//        Glide.with(this)
//                .load(url)
//                .apply(RequestOptions.circleCropTransform())
//                .into(picImageView);

        ////другая библиотека
//        Picasso.with(this)
//                .load(url.toString())
//                .placeholder(R.drawable.round_button)//отбражаетя во время загрузки
//                .error(R.drawable.super_button)//заглушка в случае ошибки
////                .resize(55,88)//подрезать
//                .into(picImageView);
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
