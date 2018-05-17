package com.talentomobile.samplearch.domain;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;


/**
 * Defines Accounts domain's model layer
 */
public class Accounts {
    @SerializedName("accounts")
    private ArrayList<Account> accountList;
    private String failedAccountTypes;
    private String returnCode;

    public List<Account> getAccounts() {
        return accountList;
    }

    public void setAccounts(List<Account> accounts) {
        this.accountList = (ArrayList<Account>) accounts;
    }

    public String getFailedAccountTypes() {
        return failedAccountTypes;
    }

    public void setFailedAccountTypes(String failedAccountTypes) {
        this.failedAccountTypes = failedAccountTypes;
    }

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }
}
