package com.example.user_pc.testsktl.base;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by USER-PC on 18.08.2017.
 */
public abstract class BaseItemViewHolder<Model,
        ViewModel extends BaseItemViewModel<Model>,
        DataBinding extends ViewDataBinding>
        extends RecyclerView.ViewHolder {

//public abstract class BaseItemViewHolder<Model,//имеется ввиду то что мы хотим распечатать(лист профайл модель)
//                ViewModel//обсервблфилд
//                        extends BaseItemViewModel<Model>,
//                DataBinding//это биндинг для одного айтома
//                        extends ViewDataBinding>   extends RecyclerView.ViewHolder {

    private DataBinding dataBinding;
    private ViewModel viewModel;

    public BaseItemViewHolder(DataBinding dataBinding, ViewModel viewModel) {
        super(dataBinding.getRoot());
        this.dataBinding = dataBinding;
        this.viewModel = viewModel;
        viewModel.init();
    }

    public void bindTo(Model item, int position) {
        viewModel.setItem(item, position);
        dataBinding.executePendingBindings();
    }

    public void release() {
        viewModel.release();
    }
}
