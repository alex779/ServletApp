package hovercat.appservlet.servlets;

import hovercat.appservlet.domain.UsersDaoImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AdminServlet", urlPatterns = {"/admin"})
public class AdminServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie c[] = req.getCookies();
        String cookie = c[0].getValue();

        req.setAttribute("cookie", cookie);
        req.setAttribute("users", new UsersDaoImpl().getAllUsers());

        req.getRequestDispatcher("/WEB-INF/admin.jsp").forward(req, resp);
    }
}
