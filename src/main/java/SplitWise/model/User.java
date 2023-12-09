package SplitWise.model;

import java.util.HashMap;
import java.util.Map;

public class User {

    String userId;
    Map<String, UserLedger> owedByUserMap;

    public User(String userId) {
        this.userId = userId;
        this.owedByUserMap = new HashMap<>();
    }

    public String getUserId() {
        return userId;
    }

    public Map<String, UserLedger> getOwedByUserMap() {
        return owedByUserMap;
    }
}
