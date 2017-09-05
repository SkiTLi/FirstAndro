package com.example.user_pc.testsktl.homework9_new_gallery;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.user_pc.testsktl.databinding.PhotoRecycleViewBinding;


/**
 * Created by USER-PC on 04.08.2017.
 */


public class HW9Adapter extends RecyclerView.Adapter<HW9Adapter.MyItemHolder> {

    private HW9ItemViewModel[] items;

    HW9Adapter(HW9ItemViewModel[] items) {
        this.items = items;
    }

    @Override
    public MyItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        PhotoRecycleViewBinding binding = PhotoRecycleViewBinding
                .inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new MyItemHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(MyItemHolder holder, int position) {
        holder.binding.setItemModel(items[position]);
    }

    @Override
    public int getItemCount() {
        return items.length;
    }


    class MyItemHolder extends RecyclerView.ViewHolder {

        PhotoRecycleViewBinding binding;

        MyItemHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
    }

    @BindingAdapter({"bind:item_image"})
    public static void loadImg(ImageView view, String url) {
        Glide.with(view.getContext())
                .load(url)
                .into(view);
    }
}
