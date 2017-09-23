package com.example.user_pc.testsktl.data.entity;

import com.google.gson.annotations.SerializedName;

public class AccessTokenData implements DataModel {

    @SerializedName("access-token")
    private String accessToken;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
