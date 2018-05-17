package com.talentomobile.samplearch.presentation.base.mvp.base;

import android.support.v7.widget.RecyclerView;

import com.talentomobile.samplearch.presentation.base.mvp.common.controllers.CollectionItemsController;

import java.util.List;


/**
 * Base abstract adapter
 */
public abstract class BaseRecyclerViewAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements CollectionItemsController<T> {

    private List<T> items;

    @Override
    public void setItems(List<T> items) {
        this.items = items;
    }

    @Override
    public int getItemCount() {
        return items != null ? items.size() : 0;
    }

    protected T getItem(final int position) {
        if(getItemCount() > position) {
            return items.get(position);
        }
        return null;
    }

    public List<T> getItems() {
        return items;
    }
}
