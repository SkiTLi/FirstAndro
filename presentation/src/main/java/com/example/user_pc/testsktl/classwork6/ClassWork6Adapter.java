package com.example.user_pc.testsktl.classwork6;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user_pc.testsktl.R;

import java.util.ArrayList;


/**
 * Created by USER-PC on 04.08.2017.
 */


public class ClassWork6Adapter extends RecyclerView.Adapter<ClassWork6Adapter.Holder> {

    private ArrayList<String> items;

    public ClassWork6Adapter(ArrayList<String> items) {
        this.items = items;
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
        //holderimage view - дома


        holder.textView.setText(item);

    }

    //количество элементов
    @Override
    public int getItemCount() {
//        вот так это делается)))
        return items == null ? 0 : items.size();
    }

    public static class Holder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;


        public Holder(View itemView2) {
            super(itemView2);

            imageView = (ImageView) itemView2.findViewById(R.id.gallery_imageView);
            textView = (TextView) itemView2.findViewById(R.id.gallery_textView);
        }
    }
}
