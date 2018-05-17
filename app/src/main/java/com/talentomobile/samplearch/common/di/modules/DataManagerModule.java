package com.talentomobile.samplearch.common.di.modules;

import android.content.Context;

import com.talentomobile.samplearch.data.AppDataManager;
import com.talentomobile.samplearch.data.DataManager;

import dagger.Module;
import dagger.Provides;



/**
 * Provides Data manager methods for injection purposes
 */
@Module
public class DataManagerModule  {

    @Provides
    DataManager providesDataManager(Context context) {
        return new AppDataManager(context);
    }
}
