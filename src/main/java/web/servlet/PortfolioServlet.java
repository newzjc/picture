package web.servlet;

import pogo.PageBean;
import pogo.Portfolio;
import service.impl.PortfolioServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/portfolio/*")
public class PortfolioServlet extends BaseServlet {
    private PortfolioServiceImpl portfolioService = new PortfolioServiceImpl();

    public void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String _currentPage = request.getParameter("currentPage");
        String _rows = request.getParameter("rows");
        String pname = request.getParameter("pname");
        String _flag = request.getParameter("flag");
        //解决中文乱码问题
        if (pname != null && pname.length() > 0 && !"null".equals(pname)) {
            pname = new String(pname.getBytes("ISO-8859-1"), "utf-8");
        }
        System.out.println(pname);
        //获取当前页数
        int currentPage;
        if (_currentPage != null && _currentPage.length() > 0 && !"null".equals(_currentPage)) {
            currentPage = Integer.parseInt(_currentPage);
        } else {
            currentPage = 1;
        }
        //获取每页展示上的数量
        int row = 0;
        if (_rows != null && _rows.length() > 0) {
            row = Integer.parseInt(_rows);
        } else {
            row = 4;
        }
        PageBean<Portfolio> pb = portfolioService.page(currentPage, row, pname,_flag);
        writeValue(pb, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
