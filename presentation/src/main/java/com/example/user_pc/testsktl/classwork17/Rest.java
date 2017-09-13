package com.example.user_pc.testsktl.classwork17;

/**
 * Created by USER-PC on 11.09.2017.
 */

public class Rest {


    private OkHttp okHttp;
    private Gson gson;



    //лучше сзелать конструктор чтобы более было удобно тестировать например
    public Rest(OkHttp okHttp, Gson gson) {
        this.okHttp = okHttp;
        this.gson = gson;
    }
}
