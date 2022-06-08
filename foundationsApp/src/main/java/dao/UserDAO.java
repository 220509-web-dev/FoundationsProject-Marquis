package dao;

import entities.User;

import java.util.List;

// May 26 lesson-video3-4:18
public interface UserDAO {

    // Create
    User createUser(User user);

    // Read
    User getUserById(int id);
    User getUserByUsername(String username);
    List<User> getUsers();

    // Update
    User updateUser(User user);

    // Delete
    User deleteUser(int id);
    //or void User deleteUser(int id);
}
