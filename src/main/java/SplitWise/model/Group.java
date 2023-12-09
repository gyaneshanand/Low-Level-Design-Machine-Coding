package SplitWise.model;

import java.util.List;
import java.util.Map;

public class Group {

    String groupId;
    Map<String, User> userMap;;

    public Group(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupId() {
        return groupId;
    }

    public Map<String, User> getUserList() {
        return userMap;
    }
}
