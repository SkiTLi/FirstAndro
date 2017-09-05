package com.example.user_pc.testsktl.homework9_new_gallery;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.user_pc.testsktl.R;
import com.example.user_pc.testsktl.base.*;
import com.example.user_pc.testsktl.databinding.ActivityHw9NewGalleryBinding;

/**
 * Вам необходимо переделать на новую архитектуру задание 6 с RecyclerView,
 * т.е. создать view model, новый Use Case и необходимые entity.
 * Все необходимо сделать по примеру того, что делали на занятии,
 * т. е. ваши ссылки для галереи будут приходить из Use Case.
 * Так же крайне желательно переделать адаптер на android binding,
 * т. е. у item появится свой view model.
 */

public class HW9Activity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        HW9ViewModel hw9ViewModel = new HW9ViewModel();
        this.viewModelInBaseActivity = hw9ViewModel;
        ActivityHw9NewGalleryBinding binding = DataBindingUtil
                .setContentView(this, R.layout.activity_hw9_new_gallery);
//        this.viewModelInBaseActivity = hw9ViewModel;
        binding.setModel(hw9ViewModel);
    }

    @BindingAdapter({"bind:adapter"})
    public static void setAdapter(RecyclerView view, HW9ItemViewModel[] items) {
        view.setLayoutManager(new GridLayoutManager(view.getContext(), 2));
        view.setAdapter(new HW9Adapter(items));
    }
}
