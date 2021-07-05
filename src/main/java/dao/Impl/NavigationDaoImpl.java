package dao.Impl;

import dao.NavigationDao;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import pogo.Navigation;
import util.JDBCUtils;

import java.util.List;

public class NavigationDaoImpl implements NavigationDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     *  查询 导航 Navigation内容
     * @return
     */
    @Override
    public List<Navigation> findAll() {
        List<Navigation> navigations = null;
        try {
            String sql = "select * from tab_navigation ";
            navigations = template.query(sql, new BeanPropertyRowMapper<Navigation>(Navigation.class));
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return navigations;
    }
}
