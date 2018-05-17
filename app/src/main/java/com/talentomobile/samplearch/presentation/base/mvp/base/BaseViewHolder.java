package com.talentomobile.samplearch.presentation.base.mvp.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.talentomobile.samplearch.presentation.base.mvp.common.listeners.OnItemClickedListener;

import butterknife.ButterKnife;



/**
 * Base view holder that must be used for all view holders
 */
public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder implements View.OnClickListener {

    private T object;
    private final OnItemClickedListener<T> onItemClickedListener;

    public BaseViewHolder(View layoutView) {
        this(layoutView, null);
    }

    public BaseViewHolder(View layoutView, OnItemClickedListener<T> onItemClickedListener) {
        super(layoutView);
        ButterKnife.bind(this, layoutView);
        this.onItemClickedListener = onItemClickedListener;
        if(onItemClickedListener != null) {
            layoutView.setOnClickListener(this);
        }
    }

    public void setView(T object) {
        this.object = object;
        initViews(object);
    }

    protected abstract void initViews(T object);

    @Override
    public void onClick(View v) {
        if(onItemClickedListener == null) {
            return;
        }
        onItemClickedListener.onClicked(object, v);
    }
}
