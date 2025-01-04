package DoctorAppointmentBooking.repository;

import DoctorAppointmentBooking.model.User;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {

    private Map<String, User> users; // Assumption :- Name will be unique
    private static UserRepository userRepository;

    private UserRepository(){
        users = new HashMap<>();
    }

    public static UserRepository getUserRepository(){
        if(userRepository == null){
            userRepository = new UserRepository();
        }
        return userRepository;
    }

    public User addUser(User u){
        // We can do error handlings here
        users.put(u.getName(), u);
        return u;
    }

    public User getUserById(Integer id){
        return users.get(id);
    }

    public User getUserByName(String name){
        return users.values().stream()
                .filter(user -> user.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}
