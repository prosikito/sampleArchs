package com.talentomobile.samplearch;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

import com.talentomobile.samplearch.common.di.components.ApplicationComponent;
import com.talentomobile.samplearch.common.di.components.DaggerApplicationComponent;
import com.talentomobile.samplearch.common.di.modules.ApplicationModule;



public class App extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        // Initialize application
        initApp();
    }

    /**
     * Initialize application
     */
    private void initApp() {
        setupInjector();
    }

    /**
     * Setup Dagger 2 injector
     */
    private void setupInjector() {
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        applicationComponent.inject(this);
    }

    /**
     * Retrieve an Application instance
     *
     * @param context Current context
     * @return Application
     */
    public static App getApp(@NonNull Context context) {
        return (App) context.getApplicationContext();
    }

    /**
     * @return Dagger2's application component, so dependencies can be handled.
     */
    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }


}

