package com.talentomobile.samplearch.presentation.base.mvp.common.controllers;

import com.talentomobile.samplearch.presentation.base.mvp.common.listeners.OnItemClickedListener;

import java.util.List;



/**
 * Adapter interface for those adapters to whom items can be clicked
 */

public interface ClickableCollectionItemsController<T> extends CollectionItemsController<T> {

    void setOnItemClickedListener(OnItemClickedListener<T> onItemClickedListener);

    List<T> getItems();
}
