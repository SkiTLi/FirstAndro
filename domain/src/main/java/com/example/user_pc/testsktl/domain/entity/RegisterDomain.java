package com.example.user_pc.testsktl.domain.entity;

/**
 * Created by USER-PC on 19.09.2017.
 */

public class RegisterDomain implements DomainModel {

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
