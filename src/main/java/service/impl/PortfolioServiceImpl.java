package service.impl;

import dao.Impl.PortfolioDaoImpl;
import pogo.PageBean;
import pogo.Portfolio;
import service.PortfolioService;

import java.util.ArrayList;
import java.util.List;

public class PortfolioServiceImpl implements PortfolioService {
    private PortfolioDaoImpl dao = new PortfolioDaoImpl();

    @Override
    public PageBean<Portfolio> page(int currentPage, int row, String pname, String flag) {
        PageBean<Portfolio> pb = new PageBean<>();
        int totalCount = dao.totalCount(pname);
        pb.setTotalCount(totalCount);
        pb.setCurrentPage(currentPage);
        pb.setRows(row);
        int totalPage = totalCount % row == 0 ? totalCount / row : totalCount / row + 1;
        pb.setTotalPage(totalPage);
        int start = (currentPage - 1) * row;
        List<Portfolio> list = null;
        if ("1".equals(flag) || "2".equals(flag)) {
            list = dao.portfolio(start, row, pname);
        } else if ("3".equals(flag)) {
            list = dao.new_portfolio(start, row, pname);
        } else if ("4".equals(flag)) {
            list = dao.hot_portfolio(start, row, pname);
        }
        pb.setList(list);
        return pb;
    }
}
