package dao.Impl;

import dao.PortfolioDao;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import pogo.Portfolio;
import util.JDBCUtils;

import java.util.ArrayList;
import java.util.List;

public class PortfolioDaoImpl implements PortfolioDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public int totalCount(String pname) {
        String sql = "select count(*) from tab_portfolio where 1 = 1";
        StringBuilder ssql = new StringBuilder(sql);
        ArrayList<Object> list = new ArrayList<>();
        if (pname != null && !"null".equals(pname)) {
            ssql.append(" and pname like ?");
            list.add("%" + pname + "%");
        }
        sql = ssql.toString();
        return template.queryForObject(sql, Integer.class, list.toArray());
    }

    @Override
    public List<Portfolio> portfolio(int start, int row, String pname) {
        List<Portfolio> list = null;
        //String sql = "select * from tab_portfolio limit ? , ? ";
        String sql = "select * from tab_portfolio where 1 = 1";
        StringBuilder ssql = new StringBuilder(sql);
        ArrayList<Object> list1 = new ArrayList<>();
        //防止sql注入
        if (pname != null && !"null".equals(pname)) {
            ssql.append(" and pname like ? ");
            list1.add("%" + pname + "%");
        }
        ssql.append(" limit ?, ?");
        list1.add(start);
        list1.add(row);
        sql = ssql.toString();
        return template.query(sql, new BeanPropertyRowMapper<Portfolio>(Portfolio.class), list1.toArray());
    }

    @Override
    public List<Portfolio> new_portfolio(int start, int row, String pname) {
        List<Portfolio> list = null;
        //String sql = "select * from tab_portfolio limit ? , ? ";
        String sql = "select * from tab_portfolio where 1 = 1";
        StringBuilder ssql = new StringBuilder(sql);
        ArrayList<Object> list1 = new ArrayList<>();
        //防止sql注入
        if (pname != null && !"null".equals(pname)) {
            ssql.append(" and pname like ? ");
            list1.add("%" + pname + "%");
        }
        ssql.append(" ORDER BY DATE DESC ");
        ssql.append(" limit ?, ?");
        list1.add(start);
        list1.add(row);
        sql = ssql.toString();
        return template.query(sql, new BeanPropertyRowMapper<Portfolio>(Portfolio.class), list1.toArray());
    }

    @Override
    public List<Portfolio> hot_portfolio(int start, int row, String pname) {
        List<Portfolio> list = null;
        //String sql = "select * from tab_portfolio limit ? , ? ";
        String sql = "select * from tab_portfolio where 1 = 1";
        StringBuilder ssql = new StringBuilder(sql);
        ArrayList<Object> list1 = new ArrayList<>();
        //防止sql注入
        if (pname != null && !"null".equals(pname)) {
            ssql.append(" and pname like ? ");
            list1.add("%" + pname + "%");
        }
        ssql.append(" ORDER BY VIEW DESC ");
        ssql.append(" limit ?, ?");
        list1.add(start);
        list1.add(row);
        sql = ssql.toString();
        return template.query(sql, new BeanPropertyRowMapper<Portfolio>(Portfolio.class), list1.toArray());
    }
}
