package SplitWise.repository;

import SplitWise.model.Transaction;
import SplitWise.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryCommonRepository {

    private static InMemoryCommonRepository inMemoryCommonRepository;

    private Map<String, User> userMap;
    private List<Transaction> transactionList;

    private InMemoryCommonRepository(){
        userMap = new HashMap<>();
        transactionList = new ArrayList<>();
    }

    public static InMemoryCommonRepository getInMemoryCommonRepository(){
        if(inMemoryCommonRepository==null){
            inMemoryCommonRepository = new InMemoryCommonRepository();
        }
        return inMemoryCommonRepository;
    }

    public Map<String, User> getUserMap() {
        return userMap;
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }
}
