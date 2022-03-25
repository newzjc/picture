package web.servlet;

import org.apache.commons.beanutils.BeanUtils;
import pogo.ResultInfo;
import pogo.User;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/user/*")
public class UserServlet extends BaseServlet {
    private UserServiceImpl userService = new UserServiceImpl();
    private ResultInfo info = new ResultInfo();

    /**
     * 注册功能
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void findName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String check = request.getParameter("check");
        //将info转换为json对象
        /*ObjectMapper mapper = new ObjectMapper();
        //  将json数据写回前台，设置响应格式
        response.setContentType("application/json;charset=utf-8");*/
        //封装了后台向前台发送数据的对象
        Map<String, String[]> parameterMap = request.getParameterMap();
        User user = new User();
        try {
            BeanUtils.populate(user, parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        if (check == null || check.length() == 0) {
            boolean flag = userService.findOne(user.getUsername());
            if (flag) {
                info.setFlag(true);
            } else {
                info.setFlag(false);
                info.setErrorMsg("用户名已存在");
            }
            writeValue(info, response);
        } else {
            HttpSession session = request.getSession();
            String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
            //验证码只能使用一次,移除
            session.removeAttribute("CHECKCODE_SERVER");
            //验证码错误不等于给定的验证码时
            if (!checkcode_server.equalsIgnoreCase(check)) {
                info.setFlag(false);
                info.setErrorMsg("验证码已过期");
                writeValue(info, response);
            } else {
                userService.register(user);
                info.setFlag(true);
                writeValue(info, response);
            }
        }
    }

    /**
     * 登录 login
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = userService.login(username, password);
        if (user == null) {

            info.setFlag(false);
            info.setErrorMsg("用户名或密码错误");

        } else {
            info.setFlag(true);
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
        }
        writeValue(info, response);
    }

    public void name(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        writeValue(user, response);
    }


    public void out(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //销毁session自己
        request.getSession().invalidate();
        //重定向时可给其添加动态路径
        response.sendRedirect(request.getContextPath() + "/index.html");
    }
}
