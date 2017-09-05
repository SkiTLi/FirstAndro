package com.example.user_pc.testsktl.homework10_timer;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.user_pc.testsktl.R;
import com.example.user_pc.testsktl.base.BaseActivity;
import com.example.user_pc.testsktl.databinding.ActivityHw10TimerBinding;

/**
 * Created by USER-PC on 26.07.2017.
 */

public class HW10Activity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        HW10ViewModel hw10ViewModel = new HW10ViewModel();
        this.viewModelInBaseActivity = hw10ViewModel;
        ActivityHw10TimerBinding activityTask10Binding = DataBindingUtil.setContentView(this,
                R.layout.activity_hw10_timer);

        activityTask10Binding.setViewModel(hw10ViewModel);
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
