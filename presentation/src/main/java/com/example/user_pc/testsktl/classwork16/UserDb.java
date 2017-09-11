package com.example.user_pc.testsktl.classwork16;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by USER-PC on 08.09.2017.
 */
//особенность того что только конкретный объект нужно extend от Realm напрямую, т.е. он не передается по наследованию
public class UserDb extends RealmObject {

    //нельзя здесь переопределить иквлз и хэшкод
    @PrimaryKey
    private int id;

    private String name;

    //можно зато так:
//    private Country country;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
