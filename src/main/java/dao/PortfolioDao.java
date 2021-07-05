package dao;

import pogo.Portfolio;

import java.util.List;

public interface PortfolioDao {
    int totalCount(String pname);

    List<Portfolio> portfolio(int start,int row,String pname);

    List<Portfolio> new_portfolio(int start, int row, String pname);

    List<Portfolio> hot_portfolio(int start, int row, String pname);
}

