package co.newtonschool.socialmedia.repository;

import co.newtonschool.socialmedia.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private final List<User> userList = new ArrayList<>();

    public User saveUser(User user) {
        userList.add(user);
        return user;
    }

    public List<User> getAllUsers() {
        return userList;
    }

    public User getUserById(int id) {
        for (User user : userList) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null; // User not found
    }

    public User getUserByUsername(String username) {
        for (User user : userList) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null; // User not found
    }
}
