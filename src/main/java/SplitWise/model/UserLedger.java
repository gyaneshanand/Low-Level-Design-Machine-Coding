package SplitWise.model;

import java.util.ArrayList;
import java.util.List;

public class UserLedger {

    double balance;
    List<Transaction> transactionList;

    public UserLedger() {
        this.balance = 0.0;
        this.transactionList = new ArrayList<>();
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }
}
