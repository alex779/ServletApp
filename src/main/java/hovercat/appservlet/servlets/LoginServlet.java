
package hovercat.appservlet.servlets;

import hovercat.appservlet.auth.AuthenticationStorage;
import hovercat.appservlet.domain.Users;
import hovercat.appservlet.domain.UsersDaoImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    UsersDaoImpl dao = new UsersDaoImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String cookieValue = String.valueOf(System.currentTimeMillis());
        String login = req.getParameter("login");
        String pass = req.getParameter("pass");

        Users user = dao.loadByLogin(login);

        if (user != null && encoder.matches(pass, user.getPassword())) {

            if (user.getRole().equals(String.valueOf("admin"))) {
                String value = (String.valueOf(user.getId()) + "-" + cookieValue);
                Cookie c = new Cookie("cookie", value);
                c.setMaxAge(24 * 60 * 60);
                resp.addCookie(c);
                AuthenticationStorage.tokens.add(value);
                resp.sendRedirect("admin");
            } else {
                String value = (String.valueOf(user.getId()) + "-" + cookieValue);
                Cookie c = new Cookie("cookie", value);
                c.setMaxAge(24 * 60 * 60);
                resp.addCookie(c);
                AuthenticationStorage.tokens.add(value);

                req.getRequestDispatcher("user").forward(req, resp);
            }
        } else {
            req.setAttribute("login", login);
            req.setAttribute("errMsg", "invaild login or password");
            req.getRequestDispatcher("WEB-INF/login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/login.jsp").forward(req, resp);
    }
}