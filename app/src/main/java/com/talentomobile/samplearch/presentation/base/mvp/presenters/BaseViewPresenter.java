package com.talentomobile.samplearch.presentation.base.mvp.presenters;



import com.talentomobile.samplearch.presentation.base.mvp.views.BaseView;
import com.talentomobile.samplearch.presentation.common.ResourceManager;
import com.talentomobile.samplearch.presentation.common.Router;

public abstract class BaseViewPresenter<T extends BaseView> implements BasePresenter {

    private T view;
    protected Router router;
    protected ResourceManager resourceManager;

    public BaseViewPresenter(ResourceManager resourceManager, Router router, T view) {
        this.resourceManager = resourceManager;
        this.router = router;
        this.view = view;
    }

    @Override
    public void onBackPressed() {
        router.goBack();
    }
}