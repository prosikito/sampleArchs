package com.talentomobile.samplearch.presentation.pager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.talentomobile.samplearch.presentation.accounts.AccountsFragment;
import com.talentomobile.samplearch.presentation.common.ResourceManager;



public class PagerAdapter extends FragmentPagerAdapter {

    private static final int NUM_PAGES = 2;
    private ResourceManager resourceManager;

    public PagerAdapter(FragmentManager fm, ResourceManager resourceManager) {
        super(fm);
        this.resourceManager = resourceManager;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return AccountsFragment.newInstance(true);
            case 1:
                return AccountsFragment.newInstance(false);
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return NUM_PAGES;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return resourceManager.getNotVisibleAccounts();
        } else if (position == 1) {
            return resourceManager.getVisibleAccounts();
        }
        return "";
    }
}
