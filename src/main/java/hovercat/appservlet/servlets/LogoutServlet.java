package hovercat.appservlet.servlets;

import hovercat.appservlet.auth.AuthenticationStorage;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "LogoutServlet", urlPatterns = {"/logout"})
public class LogoutServlet extends HttpServlet {

    private final String cookieName = "cookie";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie[] cookies = req.getCookies();
        for (Cookie c : cookies) {
            if (c.getName().equals(cookieName)) {
                AuthenticationStorage.tokens.remove(c.getValue());
                Cookie c1 = new Cookie(cookieName, "");
                c1.setMaxAge(0);
                resp.addCookie(c1);
            }
        }
        resp.sendRedirect("hello");
    }
}
