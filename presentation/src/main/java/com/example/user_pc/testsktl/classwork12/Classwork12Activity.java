package com.example.user_pc.testsktl.classwork12;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;

import com.example.user_pc.testsktl.R;
import com.example.user_pc.testsktl.base.BaseActivity;

import com.example.user_pc.testsktl.databinding.ActivityClasswork12Binding;

/**
 * Created by USER-PC on 26.07.2017.
 */


//короче это качается с github


//nen нужно разобраться
public class Classwork12Activity extends BaseActivity {

    public static void show(Activity activity) {
        Intent intent = new Intent(activity, Classwork12Activity.class);
        activity.startActivity(intent);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        Classwork12ViewModel viewModel = new Classwork12ViewModel(this);
        this.viewModelInBaseActivity = viewModel;

        ActivityClasswork12Binding binding = DataBindingUtil
                .setContentView(this, R.layout.activity_classwork12);

        binding.setViewModel(viewModel);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(viewModel.adapter);

        super.onCreate(savedInstanceState);
    }
}

