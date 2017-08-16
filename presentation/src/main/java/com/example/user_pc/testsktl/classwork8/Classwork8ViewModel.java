package com.example.user_pc.testsktl.classwork8;

import android.app.Activity;
import android.content.Intent;
import android.databinding.ObservableField;
import android.os.AsyncTask;
import android.util.Log;

import com.example.user_pc.testsktl.base.BaseViewModel;
import com.example.user_pc.testsktl.classwork4.Classwork4Activity;

import java.util.Observable;

/**
 * Created by USER-PC on 09.08.2017.
 */


//плюс тема ПОТОКИ
public class Classwork8ViewModel implements BaseViewModel {

    public ObservableField<String> helloText = new ObservableField<>("hEllo");

    public Activity activity;

    public Classwork8ViewModel(Activity activity) {
//        super();
        this.activity = activity;
    }

    @Override
    public void init() {

        //натыкать везде логи

    }

    @Override
    public void release() {
        //натыкать везде логи
    }

    @Override
    public void resume() {
        //натыкать везде логи
    }

    @Override
    public void pause() {
        //натыкать везде логи
    }

    public void onSuperButtonClick() {
        Log.d("AAA", "on supre click");

        Intent intent = new Intent(activity, Classwork4Activity.class);
        activity.startActivity(intent);

        Classwork8Activity.show(activity);
    }

//часто явл источником утечки памяти т.к.есть вариат что пользователь выйдет из активити
    //не использовать для объемных операций . тк нужно красиво из него выходить
    public class MyAsyncTak extends AsyncTask<Void, Integer, String> { // что-то, входящий, результат


        @Override
        protected void onPreExecute() {

            //тут все выполится UI потоке
            //например показать прогрессбар

            //выполняется первым как вызвали старт
            super.onPreExecute();
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            ////тут все выполится UI потоке
            //например показать о состоянии загрузки
            //yj его нужно взывать самостоятедьно из doInBackground
        }

        @Override
        protected String doInBackground(Void... params) {

            //тут все выполнитя в отдельномпотоке
            //затем передает данные в метод onPostExecute
            publishProgress(20);//вызвать метод onProgressUpdate
            return "хабр ";


        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            //сначала выполнится doInBackground
            //тут все выполится UI потоке
//            входное s передается из doInBackground
        }
    }

}
