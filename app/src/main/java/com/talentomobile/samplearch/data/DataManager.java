package com.talentomobile.samplearch.data;

import com.talentomobile.samplearch.domain.Account;
import com.talentomobile.samplearch.domain.Accounts;

import java.util.List;


public interface DataManager  {

    Accounts getDataAccounts();

    List<Account> getNotVisibleDataAccounts();

    List<Account> getVisibleDataAccounts();
}
