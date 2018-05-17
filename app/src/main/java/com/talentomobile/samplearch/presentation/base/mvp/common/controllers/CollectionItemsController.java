package com.talentomobile.samplearch.presentation.base.mvp.common.controllers;

import java.util.List;



/**
 * Adapter interface that all adapters on application must implement,
 * so the presenter can communicate directly with the adapter's presenter.
 * We may understand adapters as a Presenter with its View, so the main presenter
 * will communicate directly to the adapter's presenter.
 */
public interface CollectionItemsController<T> {

    void setItems(final List<T> items);
}
