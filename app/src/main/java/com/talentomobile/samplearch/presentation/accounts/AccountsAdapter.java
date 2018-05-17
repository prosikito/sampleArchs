package com.talentomobile.samplearch.presentation.accounts;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.talentomobile.samplearch.R;
import com.talentomobile.samplearch.domain.Account;
import com.talentomobile.samplearch.presentation.base.mvp.base.BaseRecyclerViewAdapter;
import com.talentomobile.samplearch.presentation.base.mvp.common.controllers.ClickableCollectionItemsController;
import com.talentomobile.samplearch.presentation.base.mvp.common.listeners.OnItemClickedListener;


public class AccountsAdapter extends BaseRecyclerViewAdapter<Account> implements
        ClickableCollectionItemsController<Account> {
    private OnItemClickedListener<Account> onItemClickedListener;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View layoutView = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.accounts_item, parent, false);
        return new AccountViewHolder(layoutView, onItemClickedListener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((AccountViewHolder) holder).setView(getItem(position));
    }

    @Override
    public void setOnItemClickedListener(OnItemClickedListener<Account> onItemClickedListener) {
        this.onItemClickedListener = onItemClickedListener;
    }
}


