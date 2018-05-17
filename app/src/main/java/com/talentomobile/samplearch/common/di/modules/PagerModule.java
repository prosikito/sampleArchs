package com.talentomobile.samplearch.common.di.modules;

import com.talentomobile.samplearch.common.di.scopes.PerActivity;
import com.talentomobile.samplearch.presentation.common.ResourceManager;
import com.talentomobile.samplearch.presentation.common.Router;
import com.talentomobile.samplearch.presentation.pager.PagerActivity;
import com.talentomobile.samplearch.presentation.pager.PagerAdapter;
import com.talentomobile.samplearch.presentation.pager.PagerPresenter;
import com.talentomobile.samplearch.presentation.pager.PagerView;

import dagger.Module;
import dagger.Provides;



/**
 * Provides Pager functionalists for injection purposes
 */
@Module
public class PagerModule {

    private PagerActivity activity;

    public PagerModule(PagerActivity activity) {
        this.activity = activity;
    }

    @PerActivity
    @Provides
    public PagerView providesView() {
        return this.activity;
    }

    @PerActivity
    @Provides
    public PagerPresenter providesPresenter(PagerView pagerView, ResourceManager resourceManager,
                                            Router router) {
        return new PagerPresenter(pagerView, resourceManager, router);
    }

    @PerActivity
    @Provides
    public PagerAdapter providesAdapter(ResourceManager resourceManager) {
        return new PagerAdapter(activity.getSupportFragmentManager(), resourceManager);
    }

}
