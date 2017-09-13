package com.example.user_pc.testsktl.classwork17;

import android.content.SharedPreferences;

import javax.inject.Inject;

/**
 * Created by USER-PC on 11.09.2017.
 */

//создание этого класса написли в аппмодуле из di пакета
public class UseCase1 {


    private Rest rest;
    private SharedPrefs sharedPrefs;


    //нужен какбы конструктор, но так: - некрасиво
//    public UseCase1() {
//
//        rest = new Rest (new OkHttp(), new Gson());
//        sharedPrefs = new SharedPrefs();
//    }

    public UseCase1(Rest rest, SharedPrefs sharedPrefs) {

        this. rest = rest;
        this. sharedPrefs = sharedPrefs;
    }

    public String getRestData(){
        return "";
    }
}
