package service.impl;

import dao.Impl.UserDaoImpl;
import pogo.User;
import service.UserService;

public class UserServiceImpl implements UserService {
    private UserDaoImpl dao = new UserDaoImpl();

    /**
     * 查找是否被注册过
     *
     * @param username
     * @return
     */
    @Override
    public boolean findOne(String username) {

        User user = dao.findOne(username);
        if (user == null) {
            //用户不存在
            return true;
        }
        return false;
    }

    /**
     * 注册
     *
     * @param user
     * @return
     */
    @Override
    public boolean register(User user) {
        ;
        user.setStatus("N");
        dao.register(user);
        return true;
    }

    /**
     * 登录
     *
     * @param username
     * @param password
     * @return
     */
    @Override
    public User login(String username, String password) {
        User user = dao.login(username, password);

        return user;
    }
}
