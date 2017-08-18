package com.example.user_pc.testsktl.homework7_mvvm;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;

//import android.databinding.generated.callback.OnClickListener;
import android.os.Bundle;
import android.support.annotation.BoolRes;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import com.example.user_pc.testsktl.R;
import com.example.user_pc.testsktl.databinding.ActivityHw7MvvmBinding;

/**
 * Created by USER-PC on 26.07.2017.
 */

public class HW7Activity extends Activity {

    private ActivityHw7MvvmBinding binding;

    User user = new User("Jennifer Walters", 23, "https://s-media-cache-ak0.pinimg.com/originals/c6/f8/b5/c6f8b56fd96b315f7d3ea43aa1c6e9c2.png", false);
    User user2 = new User("Dr. Robert Bruce Banner", 35, "http://vignette2.wikia.nocookie.net/fictionalcrossover/images/d/d5/Hulk.png", true);

    public void unGenderA(View view) {
        if (binding.getUser().equals(user)) {
            binding.setUser(user2);
        } else {
            binding.setUser(user);
        }
        Log.d("sktl", "должен был смениться пол" + binding.getUser().getGender());
        Log.d("sktl", "должен был смениться пол " + user.getGender());
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_hw7_mvvm);
        binding.setActivity(this);
        binding.setUser(user);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

}
