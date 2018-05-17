package com.talentomobile.samplearch.common.utils;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.IOException;
import java.io.InputStream;


public final class CommonUtils {

    /**
     * Can not instance class
     */
    private CommonUtils() {
    }

    public static InputStream loadJSONFromAsset(Context context, String fileName)
            throws IOException {
        AssetManager assetManager = context.getAssets();
        return assetManager.open(fileName);
    }
}
