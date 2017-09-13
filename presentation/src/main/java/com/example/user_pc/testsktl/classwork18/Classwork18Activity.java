package com.example.user_pc.testsktl.classwork18;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.user_pc.testsktl.R;
import com.example.user_pc.testsktl.classwork17.Classwork17Activity;

/**
 * Created by USER-PC on 26.07.2017.
 */

public class Classwork18Activity extends Activity {

    public static void show(Activity activity) {
        Intent intent = new Intent(activity, Classwork18Activity.class);
        activity.startActivity(intent);
    }



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classwork18);


    }
}
