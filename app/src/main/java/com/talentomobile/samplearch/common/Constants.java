package com.talentomobile.samplearch.common;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class Constants {

    public static final String BUNDLE_CONST_VISIBLE_ACCOUNT = "bundle_const_visible_account";
    public static final String BUNDLE_CONST_TITLE = "bundle_const_title";

    @Retention(RetentionPolicy.SOURCE)
    @StringDef({CurrencyTypes.EURO, CurrencyTypes.DOLLAR})
    public @interface CurrencyTypes{
        String EURO = "EUR";
        String DOLLAR = "DOLLAR";
    }

    @StringDef ({AccountTypes.PAYMENT, AccountTypes.SAVING})
    @Retention(RetentionPolicy.SOURCE)
    public @interface AccountTypes{
        String PAYMENT = "PAYMENT";
        String SAVING = "SAVING";
    }
}
