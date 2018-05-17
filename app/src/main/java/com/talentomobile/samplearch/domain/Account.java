package com.talentomobile.samplearch.domain;

import java.io.Serializable;

/**
 * Defines Account domain's model layer
 */
public class Account implements Serializable {
    private Integer accountBalanceInCents;
    private String accountCurrency;
    private Long accountId;
    private String accountName;
    private String accountNumber;
    private String accountType;
    private String alias;
    private Boolean isVisible;
    private String iban;
    private Integer linkedAccountId;
    private String productName;
    private Integer productType;
    private Integer savingsTargetReached;
    private Integer targetAmountInCents;

    public Integer getAccountBalanceInCents() {
        return accountBalanceInCents;
    }

    public void setAccountBalanceInCents(Integer accountBalanceInCents) {
        this.accountBalanceInCents = accountBalanceInCents;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountCurrency() {
        return accountCurrency;
    }

    public void setAccountCurrency(String accountCurrency) {
        this.accountCurrency = accountCurrency;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Boolean getVisible() {
        return isVisible;
    }

    public void setVisible(Boolean visible) {
        isVisible = visible;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public Integer getLinkedAccountId() {
        return linkedAccountId;
    }

    public void setLinkedAccountId(Integer linkedAccountId) {
        this.linkedAccountId = linkedAccountId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getProductType() {
        return productType;
    }

    public void setProductType(Integer productType) {
        this.productType = productType;
    }

    public Integer getSavingsTargetReached() {
        return savingsTargetReached;
    }

    public void setSavingsTargetReached(Integer savingsTargetReached) {
        this.savingsTargetReached = savingsTargetReached;
    }

    public Integer getTargetAmountInCents() {
        return targetAmountInCents;
    }

    public void setTargetAmountInCents(Integer targetAmountInCents) {
        this.targetAmountInCents = targetAmountInCents;
    }
}
