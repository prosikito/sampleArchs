package com.talentomobile.samplearch.presentation.accounts;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.talentomobile.samplearch.R;
import com.talentomobile.samplearch.common.di.components.ApplicationComponent;
import com.talentomobile.samplearch.common.di.components.DaggerAccountComponent;
import com.talentomobile.samplearch.common.di.modules.AccountModule;
import com.talentomobile.samplearch.common.di.modules.PresentationModule;
import com.talentomobile.samplearch.data.DataManager;
import com.talentomobile.samplearch.domain.Account;
import com.talentomobile.samplearch.presentation.base.mvp.base.BaseFragment;
import com.talentomobile.samplearch.presentation.base.mvp.presenters.BasePresenter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

import static com.talentomobile.samplearch.common.Constants.BUNDLE_CONST_TITLE;
import static com.talentomobile.samplearch.common.Constants.BUNDLE_CONST_VISIBLE_ACCOUNT;


public class  AccountsFragment extends BaseFragment implements AccountsView {

    @Inject
    AccountsPresenter presenter;

    @Inject
    AccountsAdapter adapter;

    @Inject
    DataManager dataManager;

    @BindView(R.id.rv_acounts)
    protected RecyclerView recyclerView;

    @Override
    protected int getLayoutResourceId() {
        return R.layout.fragment_accounts;
    }

    @Override
    protected BasePresenter getPresenter() {
        return presenter;
    }

    public static AccountsFragment newInstance(boolean visible) {
        AccountsFragment accountsFragment = new AccountsFragment();
        Bundle args = new Bundle();
        args.putBoolean(BUNDLE_CONST_VISIBLE_ACCOUNT, visible);
        args.putString(BUNDLE_CONST_TITLE, Boolean.toString(visible));
        accountsFragment.setArguments(args);
        return accountsFragment;
    }
    @Override
    protected void setupComponent(ApplicationComponent applicationComponent) {
        DaggerAccountComponent.builder()
                .applicationComponent(applicationComponent)
                .presentationModule(new PresentationModule(getActivity()))
                .accountModule(new AccountModule(this))
                .build().inject(this);
    }

    @Override
    protected void initViews(View rootView) {
        setupRecyclerView();
    }


    @Override
    protected void destroyViews() {
        if (recyclerView != null) {
            recyclerView.removeAllViewsInLayout();
            recyclerView = null;
        }
    }

    @Override
    protected void destroy() {
      presenter = null;
        adapter = null;
    }

    private void setupRecyclerView() {
        recyclerView.setLayoutManager(
                new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.onViewAttached(this);
    }

    @Override
    public void onDestroyView() {
        presenter.onViewDetached();
        super.onDestroyView();
    }

    @Override
    public void setTitle(String title) {
        // unused
    }

    @Override
    public DataManager getDataManager() {
        return dataManager;
    }

    @Override
    public void notifyDataChange(List<Account> accounts) {
        adapter.setItems(accounts);
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void setDataToPresenter() {
        Bundle args = getArguments();
        Boolean visible = args != null && args.getBoolean(BUNDLE_CONST_VISIBLE_ACCOUNT);
        presenter.showDataVisibilityBasedOn(visible);
    }
}
