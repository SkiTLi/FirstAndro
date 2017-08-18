package com.example.user_pc.testsktl.homework11_profiles;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.user_pc.testsktl.R;

import java.util.ArrayList;


/**
 * Created by USER-PC on 04.08.2017.
 */


public class HW11Adapter extends RecyclerView.Adapter<HW11Adapter.Holder> {
    private ArrayList<String> items;
    private ArrayList<String> images;

    public void setListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    private OnItemClickListener listener;

    public HW11Adapter(ArrayList<String> items, ArrayList<String> images) {
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
                .inflate(R.layout.recycle_view_hw11_name, parent, false);

        Log.d("AAA", "onCreateViewHolder");
        return new Holder(root);
    }

    //будем заполнять данными этот элемент
    //    для каждой строчки
    @Override
    public void onBindViewHolder(Holder holder, int position) {
        Log.d("AAA", "onBindViewHolder position()=" + position);
        final String item = items.get(position);
//        Uri image = images.get(position);
        String image = images.get(position);

        //holderimage view - дома
        holder.textView.setText(item);

        Log.d("AAA", holder.imageView3.getContext().toString());
        Log.d("AAA", holder.textView.getContext().toString());

        Glide.with(holder.imageView3.getContext())
                .load(image)
                .placeholder(R.drawable.ic_cloud_download_black_24dp)//отбражаетя во время загрузки
                .error(R.drawable.ic_error_black_24dp)//заглушка в случае ошибки
                // .resize(55, 88)//подрезать
                .into(holder.imageView3);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onItemClick(item);
                }
            }
        });
    }

    //количество элементов
    @Override
    public int getItemCount() {
//        вот так это делается)))
        return items == null ? 0 : items.size();
    }


    //    для того чтобы повесить клик на ваш ресайклвью
    interface OnItemClickListener {
        public void onItemClick(String item);
    }


}
