package com.example.user_pc.testsktl.classwork17;

/**
 * Created by USER-PC on 11.09.2017.
 */

public class UseCase2 {
    private Rest rest;



    public UseCase2() {

        rest = new Rest (new OkHttp(), new Gson());

    }


    public String getRestData(){
        return "";
    }
}
