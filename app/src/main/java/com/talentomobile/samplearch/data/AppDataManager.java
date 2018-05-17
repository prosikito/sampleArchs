package com.talentomobile.samplearch.data;

import android.content.Context;

import com.talentomobile.samplearch.common.utils.CommonUtils;
import com.talentomobile.samplearch.common.utils.Logger;
import com.talentomobile.samplearch.data.storage.StorageParser;
import com.talentomobile.samplearch.data.storage.StorageParserImpl;
import com.talentomobile.samplearch.domain.Account;
import com.talentomobile.samplearch.domain.Accounts;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class AppDataManager implements DataManager {

    private static final String FILE = "accounts.json";
    private Context context;
    private StorageParser storageParser;

    public AppDataManager(Context context) {
        this.context = context;
        this.storageParser = new StorageParserImpl();
    }

    @Override
    public Accounts getDataAccounts() {
        Accounts accounts = null;
        try {
            accounts = storageParser.parseToEntity(CommonUtils.loadJSONFromAsset(context,FILE), Accounts.class);
        } catch (IOException e) {
            Logger.e(e);
        }
        return accounts;
    }

    @Override
    public List<Account> getNotVisibleDataAccounts() {
        ArrayList<Account> accounts = new ArrayList<>();
        for (Account account : getDataAccounts().getAccounts()) {
            if (account.getVisible()) {
                accounts.add(account);
            }
        }
        return accounts;
    }

    @Override
    public List<Account> getVisibleDataAccounts() {
        ArrayList<Account> accounts = new ArrayList<>();
        for (Account account : getDataAccounts().getAccounts()) {
            if (!account.getVisible()) {
                accounts.add(account);
            }
        }
        return accounts;
    }
}
