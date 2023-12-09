package SplitWise.service;

import ParkingLot.model.Floor;
import SplitWise.constant.SplitType;
import SplitWise.constant.TransactionType;
import SplitWise.model.Transaction;
import SplitWise.model.User;

import java.util.ArrayList;
import java.util.List;

public class TransactionService {

    UserService userService;
    SplitService splitService;

    public Transaction createTransaction(String transactionString){

        // Take the String and Split
        String[] txnData = transactionString.split(" ");

        TransactionType transactionType = TransactionType.valueOf(txnData[0]);
        User paidByUser = userService.getUser(txnData[1]);
        Double amount = Double.parseDouble(txnData[2]);

        int numOwedByUser = Integer.parseInt(txnData[3]);

        List<User> owedByUserList = new ArrayList<>();
        for (int i = 4; i < (4+numOwedByUser); i++) {
            owedByUserList.add(userService.getUser(txnData[i]));
        }

        SplitType splitType = SplitType.valueOf(txnData[4+numOwedByUser]);

        List<Float> splitList = new ArrayList<>();
        for (int i = (5+numOwedByUser); i < (txnData.length); i++) {
            splitList.add(Float.parseFloat(txnData[1]));
        }



        // Using Get User and Split Map by passing Split Array , User Array and Split TYpe

        // Add the Expense to users

        return null;
    }
}
