package com.example.user_pc.testsktl.domain.entity;

import android.content.Context;

/**
 * Created by USER-PC on 06.09.2017.
 */

public class AddUser {

    private Context context;
    private User user;

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
