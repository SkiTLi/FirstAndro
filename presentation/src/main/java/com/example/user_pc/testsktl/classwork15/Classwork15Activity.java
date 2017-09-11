package com.example.user_pc.testsktl.classwork15;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import com.example.user_pc.testsktl.R;

/**
 * Created by USER-PC on 26.07.2017.
 */


public class Classwork15Activity extends FragmentActivity {


    public static void show(Activity activity) {
        Intent intent = new Intent(activity, Classwork15Activity.class);
        activity.startActivity(intent);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classwork14);


    }
}

