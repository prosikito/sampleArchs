package com.talentomobile.samplearch.presentation.accounts;

import com.talentomobile.samplearch.data.DataManager;
import com.talentomobile.samplearch.domain.Account;
import com.talentomobile.samplearch.presentation.base.mvp.views.BaseView;

import java.util.List;


public interface AccountsView extends BaseView {
    DataManager getDataManager();

    void notifyDataChange(List<Account> accounts);
}
