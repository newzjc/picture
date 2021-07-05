package service;

import pogo.User;

import java.util.List;

public interface UserService {
    boolean findOne(String username);

   boolean  register(User user);

    User login(String username, String password);

}
