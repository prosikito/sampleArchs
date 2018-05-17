package com.talentomobile.samplearch.presentation.common;



import java.util.Locale;

/**
 * Defines methods for getting all string resources

 */
public interface ResourceManager {


    Locale getLocale();

    String getAccountsToolbarName();

    CharSequence getNotVisibleAccounts();

    CharSequence getVisibleAccounts();
}
