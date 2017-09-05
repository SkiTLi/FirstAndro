package com.example.user_pc.testsktl.homework9_new_gallery;

import android.databinding.ObservableField;


public class HW9ItemViewModel {

    public ObservableField<String> url = new ObservableField<>();

    HW9ItemViewModel(String url) {
        this.url.set(url);
    }

    @Override
    public String toString() {
        return "Item [" + url.get() + "]";
    }
}
