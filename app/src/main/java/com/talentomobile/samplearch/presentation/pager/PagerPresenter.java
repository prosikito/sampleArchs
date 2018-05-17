package com.talentomobile.samplearch.presentation.pager;


import com.talentomobile.samplearch.presentation.base.mvp.presenters.BaseViewPresenter;
import com.talentomobile.samplearch.presentation.base.mvp.views.BaseView;
import com.talentomobile.samplearch.presentation.common.ResourceManager;
import com.talentomobile.samplearch.presentation.common.Router;



public class PagerPresenter extends BaseViewPresenter<PagerView> {

    private PagerView pagerView;

    public PagerPresenter(PagerView pagerView, ResourceManager resourceManager,
                          Router router) {
        super(resourceManager, router, pagerView);
        this.pagerView = pagerView;

    }

    @Override
    public void onViewAttached(BaseView view) {
        view.setTitle(resourceManager.getAccountsToolbarName());
    }

    @Override
    public void onViewDetached() {
        // unused
    }

    @Override
    public void onBackPressed() {
        pagerView.finishView();
    }

}
