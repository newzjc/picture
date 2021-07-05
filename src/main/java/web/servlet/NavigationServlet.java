package web.servlet;

import pogo.Navigation;
import service.impl.NavigationServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/nav/*")
public class NavigationServlet extends BaseServlet {

    private NavigationServiceImpl navigationService = new NavigationServiceImpl();

    public void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Navigation> list = navigationService.findAll();
        writeValue(list, response);

    }
}
