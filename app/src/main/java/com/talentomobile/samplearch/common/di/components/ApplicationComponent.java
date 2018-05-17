package com.talentomobile.samplearch.common.di.components;

import android.content.Context;

import com.talentomobile.samplearch.App;
import com.talentomobile.samplearch.common.di.modules.ApplicationModule;
import com.talentomobile.samplearch.common.di.scopes.PerApplication;

import dagger.Component;



@PerApplication
@Component(
        modules = {
            ApplicationModule.class
        }
)

public interface ApplicationComponent {
    void inject(App component);

    Context getContext();

}
