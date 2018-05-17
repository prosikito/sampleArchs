package com.talentomobile.samplearch.common.di.components;

import com.talentomobile.samplearch.common.di.DiComponent;
import com.talentomobile.samplearch.common.di.modules.AccountModule;
import com.talentomobile.samplearch.common.di.modules.DataManagerModule;
import com.talentomobile.samplearch.common.di.modules.PresentationModule;
import com.talentomobile.samplearch.common.di.scopes.PerFragment;
import com.talentomobile.samplearch.presentation.accounts.AccountsFragment;

import dagger.Component;



@PerFragment
@Component(
        modules = {
                AccountModule.class,
                PresentationModule.class,
                DataManagerModule.class
        },
        dependencies = {
                ApplicationComponent.class
        }
)

public interface AccountComponent extends DiComponent {
    void inject(AccountsFragment fragment);
}
