package com.talentomobile.samplearch.presentation.base.mvp.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.talentomobile.samplearch.App;
import com.talentomobile.samplearch.common.di.components.ApplicationComponent;
import com.talentomobile.samplearch.presentation.base.mvp.presenters.BasePresenter;

import butterknife.ButterKnife;


/**
 * Base fragment to whom all fragments must extend. Defines and uses MVP methods, as well as
 * initialize views
 */
public abstract class BaseFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(getLayoutResourceId(), container, false);

        // Bind views
        bindViews(rootView);

        // Inject objects with Dagger 2
        injectDependencies();

        // Init views
        initViews(rootView);

        // Parse extras in order to get the fragments' arguments
        parseArguments(savedInstanceState);

        if (getPresenter() != null) {
            setDataToPresenter();
        }

        return rootView;
    }

    protected void setDataToPresenter() {
    }

    @Override
    public void onDestroy() {
        destroy();
        super.onDestroy();
    }

    @Override
    public void onDestroyView() {
        // Destroy views
        destroyViews();
        super.onDestroyView();
    }

    /**
     * Replace all the annotated fields with ButterKnife annotations with the proper value
     */
    private void bindViews(View rootView) {
        ButterKnife.bind(this, rootView);
    }

    /**
     * Inject Dagger 2 dependencies
     */
    private void injectDependencies() {
        if (getActivity() != null)
            setupComponent(App.getApp(getActivity()).getApplicationComponent());
    }

    /**
     * Parse the arguments of the fragment
     *
     * @param savedInstanceState On create's saved instance state
     */
    private void parseArguments(final Bundle savedInstanceState) {
        final Bundle arguments;
        if (savedInstanceState != null) {
            arguments = savedInstanceState;
        } else {
            arguments = getArguments();
        }

        if (arguments != null) {
            onParseArguments(arguments);
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        final Bundle bundleToSave = getBundleToSave();
        if (bundleToSave != null) {
            outState.putAll(bundleToSave);
        }
        super.onSaveInstanceState(outState);
    }

    protected Bundle getBundleToSave() {
        return getArguments();
    }

    protected void onParseArguments(final Bundle arguments) {
        // Fill with code on each fragment that must need it
    }

    /**
     * Specify the layout of the fragment to be inflated in the {@link BaseFragment#onCreateView(LayoutInflater, ViewGroup, Bundle)}
     */
    protected abstract int getLayoutResourceId();

    /**
     * @return The presenter attached to the fragment. This must extends from {@link BasePresenter}
     */
    protected abstract BasePresenter getPresenter();

    /**
     * This method will setup the injector and will commit the dependencies injections.
     */
    protected abstract void setupComponent(ApplicationComponent applicationComponent);

    /**
     * Initialize all views for that fragment
     *
     * @param rootView Fragment's root view
     */
    protected abstract void initViews(View rootView);

    /**
     * Destroy all views for that fragment
     */
    protected abstract void destroyViews();

    /**
     * Destroy all objects for that fragment
     */
    protected abstract void destroy();


}
