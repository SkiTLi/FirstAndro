package com.example.user_pc.testsktl.classwork8;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;


import com.example.user_pc.testsktl.R;
import com.example.user_pc.testsktl.base.*;
import com.example.user_pc.testsktl.base.BaseViewModel;
import com.example.user_pc.testsktl.classwork4.Classwork4Activity;
import com.example.user_pc.testsktl.databinding.ActivityClasswork8Binding;

/**
 * Created by USER-PC on 26.07.2017.
 */


//продолжение темы mvvm
public class Classwork8Activity extends BaseActivity {

    //это для быстрогоотбражения Classwork9Activity
    public static void  show(Activity activity){
        Intent intent = new Intent(activity, Classwork8Activity.class);
        activity.startActivity(intent);
    }



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        Classwork8ViewModel viewModel = new Classwork8ViewModel(this);// дописали this и переписалитроху класворк8вьюмодел
        this.viewModel = viewModel;

        ActivityClasswork8Binding binding = DataBindingUtil.setContentView(this, R.layout.activity_classwork8);

        binding.setViewModel(viewModel);//сгенерирована сама
        super.onCreate(savedInstanceState);
    }
}
