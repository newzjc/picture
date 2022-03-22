package dao.Impl;

import dao.UserDao;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import pogo.User;
import util.JDBCUtils;

import java.util.List;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 查询用户是否存在
     *
     * @param username
     * @return
     */
    @Override
    public User findOne(String username) {
        User user = null;
        try {
            String sql = "select  *from tab_user where username = ?";
            user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return user;
    }

    /**
     * 注册添加用户
     *
     * @param user
     * @return
     */
    @Override
    public void register(User user) {
        String sql = "insert into tab_user(username,password,email,statue) values(?,?,?,?)";
        template.update(sql, user.getUsername(), user.getPassword(), user.getEmail(), user.getStatus());
    }

    /**
     * 通过username 和 password 查询用户
     *
     * @param username
     * @param password
     * @return
     */
    @Override
    public User login(String username, String password) {
        User user = null;
        try {
            String sql = "select *from tab_user where username = ? and password = ?";
            user = template.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), username, password);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return user;
    }
}

