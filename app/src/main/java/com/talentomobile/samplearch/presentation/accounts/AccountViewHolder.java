package com.talentomobile.samplearch.presentation.accounts;

import android.view.View;
import android.widget.TextView;

import com.talentomobile.samplearch.R;
import com.talentomobile.samplearch.domain.Account;
import com.talentomobile.samplearch.presentation.base.mvp.base.BaseViewHolder;
import com.talentomobile.samplearch.presentation.base.mvp.common.listeners.OnItemClickedListener;

import butterknife.BindView;


public class AccountViewHolder extends BaseViewHolder<Account> {

    @BindView(R.id.tv_account_name)
    TextView tvAccountName;
    @BindView(R.id.tv_account_iban)
    TextView tvAccountIban;
    @BindView(R.id.tv_account_balance)
    TextView tvAccountBalance;

    AccountViewHolder(View layoutView, OnItemClickedListener<Account> onItemClickedListener) {
        super(layoutView, onItemClickedListener);
    }

    @Override
    protected void initViews(Account account) {
        tvAccountName.setText(account.getAccountName());
        tvAccountIban.setText(account.getIban());
        tvAccountBalance.setText(String.valueOf(account.getAccountBalanceInCents()));
    }
}
