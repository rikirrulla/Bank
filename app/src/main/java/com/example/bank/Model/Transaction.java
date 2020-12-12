package com.example.bank.Model;

public class Transaction {
    private int profileID;
    private String account_no;
    private String transaction_id;
    private String timestamp;
    private String sending_account;
    private String destination_account;
    private String transaction_payee;
    private String transaction_amount;
    private String trans_type;

    public Transaction(int profileID, String account_no, String transaction_id, String timestamp, String sending_account, String destination_account, String transaction_payee, String transaction_amount, String trans_type) {
        this.profileID = profileID;
        this.account_no = account_no;
        this.transaction_id = transaction_id;
        this.timestamp = timestamp;
        this.sending_account = sending_account;
        this.destination_account = destination_account;
        this.transaction_payee = transaction_payee;
        this.transaction_amount = transaction_amount;
        this.trans_type = trans_type;
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

    public String getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getSending_account() {
        return sending_account;
    }

    public void setSending_account(String sending_account) {
        this.sending_account = sending_account;
    }

    public String getDestination_account() {
        return destination_account;
    }

    public void setDestination_account(String destination_account) {
        this.destination_account = destination_account;
    }

    public String getTransaction_payee() {
        return transaction_payee;
    }

    public void setTransaction_payee(String transaction_payee) {
        this.transaction_payee = transaction_payee;
    }

    public String getTransaction_amount() {
        return transaction_amount;
    }

    public void setTransaction_amount(String transaction_amount) {
        this.transaction_amount = transaction_amount;
    }

    public String getTrans_type() {
        return trans_type;
    }

    public void setTrans_type(String trans_type) {
        this.trans_type = trans_type;
    }
}
