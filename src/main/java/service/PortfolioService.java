package service;

import pogo.PageBean;
import pogo.Portfolio;

public interface PortfolioService {
    PageBean<Portfolio> page(int currentPage, int row,String pname,String flag);
}
