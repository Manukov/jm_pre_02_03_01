package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();
    void addUser(User user);
    User findById(long id);
    void deleteUser(long id);
    void updateUser(User user);
}
