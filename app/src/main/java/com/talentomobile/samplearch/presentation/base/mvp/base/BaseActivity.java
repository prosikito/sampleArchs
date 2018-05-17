package com.talentomobile.samplearch.presentation.base.mvp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.talentomobile.samplearch.App;
import com.talentomobile.samplearch.R;
import com.talentomobile.samplearch.common.di.DiComponent;
import com.talentomobile.samplearch.common.di.components.ApplicationComponent;
import com.talentomobile.samplearch.presentation.base.mvp.presenters.BasePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;



public abstract class BaseActivity extends AppCompatActivity {

    protected View rootView;
    protected BasePresenter presenter;
    protected DiComponent component;
    private boolean isInjected = false;

    @Nullable
    @BindView(R.id.toolbar)
    protected Toolbar toolbar;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getContentView() != 1) {
            setContentView(getContentView());
        }

        ButterKnife.bind(this);
        // Dependency injection
        injectDependencies();

        if (presenter == null) {
            presenter = this.getPresenter();
        }
        initToolbar();
        initViews();
    }

    protected abstract int getContentView();

    /**
     * @return The presenter attached to the activity. This must extends from {@link BasePresenter}
     */
    protected abstract BasePresenter getPresenter();

    /**
     * Initialize all views
     */
    protected abstract void initViews();


    /**
     * Setup the object graph and inject the dependencies needed on this activity.
     */
    private void injectDependencies() {
        if (!isInjected) {
            setupComponent(App.getApp(this).getApplicationComponent());
            isInjected = true;
        }
    }

    /**
     * Set up dagger 2 component
     *
     * @param appComponent Application component
     */
    protected abstract void setupComponent(ApplicationComponent appComponent);

    private void initToolbar() {
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            if (getSupportActionBar() != null) {
                getSupportActionBar().setElevation(getToolbarElevation());
            }
        }
    }

    private float getToolbarElevation() {
        return getResources().getDimensionPixelSize(R.dimen.tiny_block);
    }

    public void replaceFragment(int destinationLayout, Fragment fragment, String tag, String stack) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(destinationLayout, fragment, tag);
        if (stack != null && !stack.isEmpty()) {
            fragmentTransaction.addToBackStack(stack);
        }
        fragmentTransaction.commit();
    }
}
