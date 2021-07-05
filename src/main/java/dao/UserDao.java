package dao;

import pogo.User;

import java.util.List;

public interface UserDao {
    User findOne(String username);

   void register(User user);

    User login(String username, String password);
}
