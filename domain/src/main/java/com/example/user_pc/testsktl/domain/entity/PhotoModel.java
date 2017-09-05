package com.example.user_pc.testsktl.domain.entity;

/**
 * Created by USER-PC on 15.08.2017.
 */

public class PhotoModel implements DomainModel {
    private String url;
    private String name;

    public PhotoModel(String url, String name) {
        this.url = url;
        this.name = name;
    }

    public PhotoModel() {

    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}