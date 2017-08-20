package com.example.user_pc.testsktl.classwork12;

import android.databinding.ObservableField;
import android.util.Log;

import com.example.user_pc.testsktl.base.BaseItemViewModel;

import com.example.user_pc.testsktl.domain.entity.ProfileModel;


public class ProfileItemViewModel extends BaseItemViewModel<ProfileModel> {

    public ObservableField<String> name = new ObservableField<>("");

    @Override
    public void setItem(ProfileModel item, int position) {
        Log.e("AAA", "ITEM " + position);
        Log.e("AAA", "ITEM name " + item.getName());
        name.set(item.getName());
    }
}