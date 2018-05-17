package com.talentomobile.samplearch.presentation.pager;


import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.talentomobile.samplearch.R;
import com.talentomobile.samplearch.common.di.components.ApplicationComponent;
import com.talentomobile.samplearch.common.di.components.DaggerPagerComponent;
import com.talentomobile.samplearch.common.di.components.PagerComponent;
import com.talentomobile.samplearch.common.di.modules.PagerModule;
import com.talentomobile.samplearch.common.di.modules.PresentationModule;
import com.talentomobile.samplearch.presentation.base.mvp.base.BaseActivity;
import com.talentomobile.samplearch.presentation.base.mvp.presenters.BasePresenter;

import javax.inject.Inject;

import butterknife.BindView;

public class PagerActivity extends BaseActivity implements PagerView {

    @BindView(R.id.vp_pager)
    ViewPager viewPager;

    @BindView(R.id.tl_tabLayout)
    TabLayout tabLayout;

    @Inject
    PagerPresenter pagerPresenter;

    @Inject
    PagerAdapter pagerAdapter;

    @Override
    protected int getContentView() {
        return R.layout.activity_accounts;
    }

    @Override
    protected void setupComponent(ApplicationComponent appComponent) {
        component = DaggerPagerComponent.builder()
                .applicationComponent(appComponent)
                .pagerModule(new PagerModule(this))
                .presentationModule(new PresentationModule(this))
                .build();
        ((PagerComponent) component).inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        pagerPresenter.onViewAttached(this);
    }
    @Override protected void onStop() {
        super.onStop();
        pagerPresenter.onViewDetached();
    }

    @Override
    protected void initViews() {
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    protected BasePresenter getPresenter() {
        return pagerPresenter;
    }

    @Override
    public void finishView() {
        finish();
    }

    @Override
    public void setTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }

    @Override
    protected void onDestroy() {
        pagerPresenter = null;
        super.onDestroy();
    }

}
