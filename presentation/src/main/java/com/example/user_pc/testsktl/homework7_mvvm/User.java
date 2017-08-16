package com.example.user_pc.testsktl.homework7_mvvm;

import android.databinding.BindingAdapter;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.user_pc.testsktl.R;

/**
 * Created by USER-PC on 11.08.2017.
 */

public class User {
    private String name;
    private int age;
    private String image;
    private boolean gender;

    public User(String name, int age, String image, boolean gender) {
        this.name = name;
        this.age = age;
        this.image = image;
        this.gender = gender;
    }

    @BindingAdapter({"bind:srcSktl"})
    public static void loadImage(ImageView iv, String str) {
        Glide.with(iv.getContext())
                .load(str)
                .placeholder(R.drawable.ic_cloud_download_black_24dp)//отбражаетя во время загрузки
                .error(R.drawable.ic_error_black_24dp)//заглушка в случае ошибки
                // .resize(55, 88)//подрезать
                .into(iv);
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean getGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }
}
