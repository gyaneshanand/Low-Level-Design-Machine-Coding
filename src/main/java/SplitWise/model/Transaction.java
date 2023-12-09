package SplitWise.model;

import SplitWise.constant.TransactionType;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Transaction {

    TransactionType transactionType;
    double amount;
    User paidUser;
    Map<String, Double> owedAmountMap;
    String name;
    String notes;
    LocalDateTime timeStamp;

    // Other Metadata


    public Transaction(TransactionType transactionType, double amount, User paidUser) {
        this.transactionType = transactionType;
        this.amount = amount;
        this.paidUser = paidUser;
        this.owedAmountMap = new HashMap<>();
        this.timeStamp = LocalDateTime.now();
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public User getPaidUser() {
        return paidUser;
    }

    public void setPaidUser(User paidUser) {
        this.paidUser = paidUser;
    }

    public Map<String, Double> getOwedAmountMap() {
        return owedAmountMap;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
