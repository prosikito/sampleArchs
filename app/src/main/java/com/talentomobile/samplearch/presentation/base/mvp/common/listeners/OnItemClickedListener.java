package com.talentomobile.samplearch.presentation.base.mvp.common.listeners;

import android.view.View;



/**
 * Callback used to notify when a recycler view item has been clicked
 */
public interface OnItemClickedListener<T> {
    void onClicked(T clicked, View clickedView);
}
