package com.talentomobile.samplearch.common.di.components;

import com.talentomobile.samplearch.common.di.DiComponent;
import com.talentomobile.samplearch.common.di.modules.PagerModule;
import com.talentomobile.samplearch.common.di.modules.PresentationModule;
import com.talentomobile.samplearch.common.di.scopes.PerActivity;
import com.talentomobile.samplearch.presentation.pager.PagerActivity;

import dagger.Component;


@PerActivity
@Component(
        modules = {
                PagerModule.class,
                PresentationModule.class
        },
        dependencies = {
                ApplicationComponent.class
        }
)

public interface PagerComponent extends DiComponent {
    void inject(PagerActivity pagerActivity);

}
