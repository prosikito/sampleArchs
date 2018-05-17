package com.talentomobile.samplearch.presentation.accounts;

import com.talentomobile.samplearch.domain.Account;
import com.talentomobile.samplearch.presentation.base.mvp.presenters.BaseViewPresenter;
import com.talentomobile.samplearch.presentation.base.mvp.views.BaseView;
import com.talentomobile.samplearch.presentation.common.ResourceManager;
import com.talentomobile.samplearch.presentation.common.Router;

import java.util.List;


public class AccountsPresenter extends BaseViewPresenter<AccountsView> {

    private AccountsView accountsView;

    public AccountsPresenter(AccountsView accountsview, ResourceManager resourceManager, Router router) {
        super(resourceManager, router, accountsview);
        this.accountsView = accountsview;
    }

    @Override
    public void onViewAttached(BaseView view) {
        view.setTitle(resourceManager.getAccountsToolbarName());
    }

    @Override
    public void onViewDetached() {
        // unused
    }

    @Override
    public void onBackPressed() {
        router.goBack();
    }

    public void showDataVisibilityBasedOn(Boolean visible) {
        List<Account> accounts;
        if (visible) {
            accounts = accountsView.getDataManager().getVisibleDataAccounts();
        } else {
            accounts = accountsView.getDataManager().getNotVisibleDataAccounts();
        }
        accountsView.notifyDataChange(accounts);
    }
}
