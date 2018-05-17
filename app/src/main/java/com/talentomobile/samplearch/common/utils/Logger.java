package com.talentomobile.samplearch.common.utils;

import android.util.Log;

import com.talentomobile.samplearch.BuildConfig;

public class Logger {

    private static final String TAG = "sampleArchs";

    private Logger(){
        // hide public constructor
    }

    public static void e (Exception e){
        if (BuildConfig.DEBUG){
            Log.e(TAG, e.getLocalizedMessage());
        }
    }
}
