package com.example.user_pc.testsktl.base;

import android.support.v7.widget.RecyclerView;
import com.example.user_pc.testsktl.data.entity.Profile;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by USER-PC on 18.08.2017.
 */

public abstract class BaseAdapter
        <Model,
                ViewModel extends BaseItemViewModel<Model>>
        extends RecyclerView.Adapter<BaseItemViewHolder<Model, ViewModel, ?>> {

    private List<Model> items = new ArrayList<>();

    public void setItems(List<Model> newItems) {
        items.clear();
        items.addAll(newItems);
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(BaseItemViewHolder<Model, ViewModel, ?> holder, int position) {
        Model item = items.get(position);
        holder.bindTo(item, position);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
