package com.example.user_pc.testsktl.homework9_new_gallery;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.user_pc.testsktl.R;
import com.example.user_pc.testsktl.base.*;
import com.example.user_pc.testsktl.databinding.ActivityHw9NewGalleryBinding;;


/**
 * Вам необходимо переделать на новую архитектуру задание 6 с RecyclerView,
 * т.е. создать view model, новый Use Case и необходимые entity.
 * Все необходимо сделать по примеру того, что делали на занятии,
 * т. е. ваши ссылки для галереи будут приходить из Use Case.
 * Так же крайне желательно переделать адаптер на android binding,
 * т. е. у item появится свой view model.
 */


//продолжение темы mvvm
public class HW9Activity extends BaseActivity {
//
//
//    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
//
        HW9ViewModel viewModel = new HW9ViewModel();// дописали this и переписалитроху класворк8вьюмодел
        this.viewModel = viewModel;
//
//        ActivityHw9NewGalleryBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_hw9_new_gallery);
//
////        binding.setViewModel(viewModel);//сгенерирована сама
        super.onCreate(savedInstanceState);//f вообще закоментить нужно




    }
}
