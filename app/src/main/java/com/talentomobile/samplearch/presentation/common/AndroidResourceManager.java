package com.talentomobile.samplearch.presentation.common;


import android.content.Context;
import android.os.Build;

import com.talentomobile.samplearch.R;

import java.util.Locale;

/**
 * Implements methods for getting all string resources
 */
public class AndroidResourceManager implements ResourceManager {

    private final Context context;

    public AndroidResourceManager(Context context) {
        this.context = context;
    }

    @Override
    public Locale getLocale() {
        Locale locale;
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
            locale = context.getResources().getConfiguration().locale;
        } else {
            locale = context.getResources().getConfiguration().getLocales().get(0);
        }
        return locale;
    }

    @Override
    public String getAccountsToolbarName() {
        return context.getResources().getString(R.string.title_toolbar_accounts);
    }

    @Override
    public CharSequence getNotVisibleAccounts() {
        return context.getString(R.string.account_not_visible);
    }

    @Override
    public CharSequence getVisibleAccounts() {
        return context.getString(R.string.account_visible);
    }
}
