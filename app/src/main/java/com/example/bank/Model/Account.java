package com.example.bank.Model;

public class Account {
    private int profileID;
    private String account_no;
    private String unique_code;
    private String cvv;
    private String expires;
    private String card_pin;
    private String account_name;
    private String account_balance;
    private String isBlocked;

    public Account(int profileID, String account_no, String unique_code, String cvv, String expires, String card_pin, String account_name, String account_balance, String isBlocked) {
        this.profileID = profileID;
        this.account_no = account_no;
        this.unique_code = unique_code;
        this.cvv = cvv;
        this.expires = expires;
        this.card_pin = card_pin;
        this.account_name = account_name;
        this.account_balance = account_balance;
        this.isBlocked = isBlocked;
    }

    public Account(int profileID, String account_no, String unique_code, String cvv, String expires, String card_pin, String account_name, String account_balance) {
        this.profileID = profileID;
        this.account_no = account_no;
        this.unique_code = unique_code;
        this.cvv = cvv;
        this.expires = expires;
        this.card_pin = card_pin;
        this.account_name = account_name;
        this.account_balance = account_balance;
    }

    public int getProfileID() {
        return profileID;
    }

    public void setProfileID(int profileID) {
        this.profileID = profileID;
    }

    public String getAccount_no() {
        return account_no;
    }

    public void setAccount_no(String account_no) {
        this.account_no = account_no;
    }

    public String getUnique_code() {
        return unique_code;
    }

    public void setUnique_code(String unique_code) {
        this.unique_code = unique_code;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getExpires() {
        return expires;
    }

    public void setExpires(String expires) {
        this.expires = expires;
    }

    public String getCard_pin() {
        return card_pin;
    }

    public void setCard_pin(String card_pin) {
        this.card_pin = card_pin;
    }

    public String getAccount_name() {
        return account_name;
    }

    public void setAccount_name(String account_name) {
        this.account_name = account_name;
    }

    public String getAccount_balance() {
        return account_balance;
    }

    public void setAccount_balance(String account_balance) {
        this.account_balance = account_balance;
    }

    public String getIsBlocked() {
        return isBlocked;
    }

    public void setIsBlocked(String isBlocked) {
        this.isBlocked = isBlocked;
    }
}
