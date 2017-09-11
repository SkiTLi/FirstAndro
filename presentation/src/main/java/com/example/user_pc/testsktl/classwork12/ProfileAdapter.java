package com.example.user_pc.testsktl.classwork12;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.user_pc.testsktl.base.BaseAdapter;
import com.example.user_pc.testsktl.base.BaseItemViewHolder;
import com.example.user_pc.testsktl.domain.entity.ProfileModel;

/**
 * Created by USER-PC on 18.08.2017.
 */

public class ProfileAdapter extends BaseAdapter<ProfileModel, ProfileItemViewModel> {

//    private Context context;

//    public ProfileAdapter(Context context) {
//        this.context = context;
//    }

    @Override
    public BaseItemViewHolder<ProfileModel, ProfileItemViewModel, ?> onCreateViewHolder
            (ViewGroup parent, int viewType) {
        ProfileItemViewModel itemViewModel = new ProfileItemViewModel();
        // return new ProfileItemViewHolder.create(LayoutInflater.from(context),
        return ProfileItemViewHolder
                .create(LayoutInflater.from(parent.getContext()), parent, itemViewModel);
    }
}