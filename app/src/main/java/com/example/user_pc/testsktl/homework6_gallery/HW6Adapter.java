package com.example.user_pc.testsktl.homework6_gallery;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.user_pc.testsktl.R;
import com.example.user_pc.testsktl.classwork6.ClassWork6Adapter;
import com.example.user_pc.testsktl.homework3_glide.HW3Activity;
import com.squareup.leakcanary.LeakTraceElement;
import com.squareup.picasso.Picasso;

import java.net.URL;
import java.util.ArrayList;

import static java.lang.System.console;
import static java.lang.System.load;
import static java.security.AccessController.getContext;


/**
 * Created by USER-PC on 04.08.2017.
 */


public class HW6Adapter extends RecyclerView.Adapter<HW6Adapter.Holder> {
    private ArrayList<String> items;
    //    private ArrayList<Uri> images;
    private ArrayList<String> images;

    public HW6Adapter(ArrayList<String> items, ArrayList<String> images) {
        this.items = items;
        this.images = images;
    }

    public static class Holder extends RecyclerView.ViewHolder {

        ImageView imageView3;
        TextView textView;

        public Holder(View itemView2) {
            super(itemView2);
            imageView3 = (ImageView) itemView2.findViewById(R.id.gallery_imageView);
            textView = (TextView) itemView2.findViewById(R.id.gallery_textView);
        }
    }

    //    будем создавать похожий элемент
    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        //создаем модель нашего вью
        View root = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recycle_view, parent, false);

        Log.d("AAA", "onCreateViewHolder");
        return new Holder(root);
    }

    //будем заполнять данными этот элемент
    //    для каждой строчки
    @Override
    public void onBindViewHolder(Holder holder, int position) {
        Log.d("AAA", "onBindViewHolder position()=" + position);
        String item = items.get(position);
//        Uri image = images.get(position);
        String image = images.get(position);

        //holderimage view - дома
        holder.textView.setText(item);

        Log.d("AAA", holder.imageView3.getContext().toString());
        Log.d("AAA", holder.textView.getContext().toString());

        Glide.with(holder.imageView3.getContext())
                .load("http://community.comicbookresources.com/images/buttons/sortarrow-asc.png")
                .placeholder(R.drawable.ic_cloud_download_black_24dp)//отбражаетя во время загрузки
                .error(R.drawable.ic_error_black_24dp)//заглушка в случае ошибки
                // .resize(55, 88)//подрезать
                .into(holder.imageView3);
    }

    //количество элементов
    @Override
    public int getItemCount() {
//        вот так это делается)))
        return items == null ? 0 : items.size();
    }


}
