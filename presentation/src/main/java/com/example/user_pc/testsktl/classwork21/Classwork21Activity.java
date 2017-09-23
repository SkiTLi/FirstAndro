package com.example.user_pc.testsktl.classwork21;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.user_pc.testsktl.R;

/**
 * Created by USER-PC on 26.07.2017.
 */

//этот урок нужно скачать у Тимофея
public class Classwork21Activity extends Activity implements RegisterView {


    public void showProgress(){
        progressBar.setVisibility(View.VISIBLE);
    }
    public void dismissProgress(){  progressBar.setVisibility(View.GONE);}
    public void showError(){}
    public void goToActivity(){}



    Button button;
    ProgressBar progressBar;

    RegisterPresenter presenter;

    public static void show(Activity activity) {
        Intent intent = new Intent(activity, Classwork21Activity.class);
        activity.startActivity(intent);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //rest_API выносят обычно в gradle

//        BuildConfig.API_REST //эта фишка из градл

        presenter = new RegisterPresenter();

        button = (Button) findViewById((R.id.button1));
        progressBar = (ProgressBar) findViewById((R.id.progressBar));
    }


    @Override
    protected void onResume() {
        super.onResume();
presenter.onResume();
    }


    @Override
    protected void onPause() {
        super.onPause();
        presenter.onPause();

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


}

