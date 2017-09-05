package com.example.user_pc.testsktl.homework11_profiles;

import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.support.annotation.Nullable;

import com.example.user_pc.testsktl.base.BaseActivity;


import io.reactivex.disposables.Disposable;

/**
 * Created by USER-PC on 26.07.2017.
 */

public class HW11Activity extends BaseActivity {
    private ScriptGroup.Binding binding;
    Disposable disposable;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        HW11ViewModel viewModel = new HW11ViewModel();// дописали this и переписалитроху класворк8вьюмодел
        this.viewModelInBaseActivity = viewModel;

//         binding = DataBindingUtil.setContentView(this, R.layout.recycle_view_hw11_name);
//
//        binding.setViewModel(viewModelInBaseActivity);
        super.onCreate(savedInstanceState);



    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (!disposable.isDisposed()) {
            disposable.dispose();
        }
    }
}
