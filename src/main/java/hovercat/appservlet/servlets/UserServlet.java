package hovercat.appservlet.servlets;

import hovercat.appservlet.domain.Users;
import hovercat.appservlet.domain.UsersDaoImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UserServlet", urlPatterns = {"/user"})
public class UserServlet extends HttpServlet {

    UsersDaoImpl dao = new UsersDaoImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");

        Users user = dao.loadByLogin(login);
        req.setAttribute("user", user);
        req.getRequestDispatcher("/WEB-INF/user.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie c[] = req.getCookies();
        String value;
        String login;

        for (Cookie c1 : c) {
            if (c1.getName().equals("cookie")) {
                value = c1.getValue();
                String[] tokens = value.split("-");
                login = dao.getUserById(Integer.parseInt(tokens[0])).getLogin();
                Users user = dao.loadByLogin(login);
                req.setAttribute("user", user);
                req.getRequestDispatcher("WEB-INF/user.jsp").forward(req, resp);
            }
        }
    }
}
