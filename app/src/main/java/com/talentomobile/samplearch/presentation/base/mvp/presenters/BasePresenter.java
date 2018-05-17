package com.talentomobile.samplearch.presentation.base.mvp.presenters;

import com.talentomobile.samplearch.presentation.base.mvp.views.BaseView;


/**
 * The presenter will be the bridge between Activity or Fragment and an interceptor.
 * Basically a presenter will communicate the results of background tasks (like a server request
 * or query to database) that are needed to affect the UI
 */
public interface BasePresenter<T extends BaseView> {

    /**
     * This method will be executed on activity onViewAttached method.
     * @param view the view passed on presenter construction
     */
    void onViewAttached(BaseView view);

    /**
     * This method will be executed on activity onViewDettached method.
     */
    void onViewDetached();

    void onBackPressed();
}
