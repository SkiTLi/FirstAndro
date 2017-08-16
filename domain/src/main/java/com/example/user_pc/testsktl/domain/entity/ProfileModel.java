package com.example.user_pc.testsktl.domain.entity;
//  не в       com.example.user_pc.testsktl.data.entity

/**
 * Created by USER-PC on 11.08.2017.
 */

public class ProfileModel implements DomainModel {
    private String name;
    private String sername;
    private int age;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSername() {
        return sername;
    }

    public void setSername(String sername) {
        this.sername = sername;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
