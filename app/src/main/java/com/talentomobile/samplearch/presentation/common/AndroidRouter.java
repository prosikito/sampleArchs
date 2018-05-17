package com.talentomobile.samplearch.presentation.common;

import android.app.Activity;

/**
 * Implements all activity transitions to other activities
 */
public class AndroidRouter implements Router {

    private final Activity activity;

    public AndroidRouter(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void goBack() {
        activity.finish();
    }


    /**
     * This is just a simple sample for showing routing capabilities.
     */
    @Override
    public void routeSample() {
//        Intent intent = new Intent(this.activity, SampleActivity.class);
//        this.activity.startActivity(intent);
    }




}