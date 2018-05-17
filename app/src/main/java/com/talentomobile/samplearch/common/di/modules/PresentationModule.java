package com.talentomobile.samplearch.common.di.modules;


import android.app.Activity;
import android.content.Context;

import com.talentomobile.samplearch.presentation.common.AndroidResourceManager;
import com.talentomobile.samplearch.presentation.common.AndroidRouter;
import com.talentomobile.samplearch.presentation.common.ResourceManager;
import com.talentomobile.samplearch.presentation.common.Router;

import dagger.Module;
import dagger.Provides;

/**
 * Provides presentation methods for injection purposes
 */
@Module
public class PresentationModule {

    private Activity activity;

    public PresentationModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    public Router provideRouter() {
        return new AndroidRouter(activity);
    }

    @Provides
    public ResourceManager provideResourceManager(Context context) {
        return new AndroidResourceManager(context);
    }


}
