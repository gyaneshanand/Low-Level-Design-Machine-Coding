package SplitWise.service;

import SplitWise.model.User;
import SplitWise.repository.InMemoryCommonRepository;

import java.util.List;
import java.util.Map;

public class UserService {

    Map<String, User> userMap;

    public UserService(){
        this.userMap = InMemoryCommonRepository.getInMemoryCommonRepository().getUserMap();
    }

    public User addUser(String userId){
        if(userMap.containsKey(userId)){
            return userMap.get(userId);
        }
        User user = new User(userId);
        userMap.put(userId, user);
        return user;
    }

    public User getUser(String userId){
        return addUser(userId);
    }

}
