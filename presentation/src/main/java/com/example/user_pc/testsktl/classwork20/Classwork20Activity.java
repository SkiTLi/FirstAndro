package com.example.user_pc.testsktl.classwork20;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.user_pc.testsktl.BuildConfig;
import com.example.user_pc.testsktl.R;

/**
 * Created by USER-PC on 26.07.2017.
 */

//пока этот класс не нужен (создали толко раззные классы объектов)
public class Classwork20Activity extends Activity {

    public static void show(Activity activity) {
        Intent intent = new Intent(activity, Classwork20Activity.class);
        activity.startActivity(intent);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classwork20);
        //rest_API выносят обычно в gradle

//        BuildConfig.API_REST //эта фишка из градл

    }


    @Override
    protected void onResume() {
        super.onResume();

    }


    @Override
    protected void onPause() {
        super.onPause();

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


}

