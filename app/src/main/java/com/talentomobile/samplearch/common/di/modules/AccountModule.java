package com.talentomobile.samplearch.common.di.modules;

import com.talentomobile.samplearch.common.di.scopes.PerFragment;
import com.talentomobile.samplearch.presentation.accounts.AccountsAdapter;
import com.talentomobile.samplearch.presentation.accounts.AccountsFragment;
import com.talentomobile.samplearch.presentation.accounts.AccountsPresenter;
import com.talentomobile.samplearch.presentation.accounts.AccountsView;
import com.talentomobile.samplearch.presentation.common.ResourceManager;
import com.talentomobile.samplearch.presentation.common.Router;

import dagger.Module;
import dagger.Provides;


/**
 * Provides all account related functionalists for injection purposes
 */
@Module
public class AccountModule {

    private AccountsFragment fragment;

    public AccountModule(AccountsFragment fragment) {
        this.fragment = fragment;
    }

    @PerFragment
    @Provides
    public AccountsView providesFragment() {
        return fragment;
    }


    @PerFragment
    @Provides
    public AccountsPresenter providesPresenter(AccountsView accountsView, ResourceManager resourceManager,
                                               Router router) {
        return new AccountsPresenter(accountsView, resourceManager, router);
    }

    @PerFragment
    @Provides
    public AccountsAdapter providesAdapter() {
        return new AccountsAdapter();
    }
}
