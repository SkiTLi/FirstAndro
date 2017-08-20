package com.example.user_pc.testsktl.classwork12;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.user_pc.testsktl.base.BaseItemViewHolder;
import com.example.user_pc.testsktl.databinding.ItemProfileBinding;
import com.example.user_pc.testsktl.domain.entity.ProfileModel;

public class ProfileItemViewHolder extends BaseItemViewHolder<ProfileModel,
        ProfileItemViewModel, ItemProfileBinding> {

    public ProfileItemViewHolder(ItemProfileBinding binding, ProfileItemViewModel viewModel) {
        super(binding, viewModel);
        binding.setViewModel(viewModel);
    }

    public static ProfileItemViewHolder create(LayoutInflater inflater, ViewGroup parent,
                                               ProfileItemViewModel viewModel) {
        ItemProfileBinding binding = ItemProfileBinding.inflate(inflater, parent, false);
        return new ProfileItemViewHolder(binding, viewModel);
    }
}
