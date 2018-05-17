package com.talentomobile.samplearch.common.di.modules;

import android.content.Context;

import com.talentomobile.samplearch.App;
import com.talentomobile.samplearch.common.di.scopes.PerApplication;

import dagger.Module;
import dagger.Provides;

/**
 * Module that provides dependencies for application
 * Must be injected in main app component
 */
@Module
public class ApplicationModule {

    private final App application;

    public ApplicationModule(App application) {
        this.application = application;
    }

    @PerApplication
    @Provides
    public App provideApplication() {
        return application;
    }

    @PerApplication
    @Provides
    public Context provideContext() {
        return application;
    }

}
