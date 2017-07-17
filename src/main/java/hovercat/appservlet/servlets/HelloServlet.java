package hovercat.appservlet.servlets;

import hovercat.appservlet.domain.UsersDaoImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "HelloServlet", urlPatterns = {"/hello"})
public class HelloServlet extends HttpServlet {

    UsersDaoImpl dao = new UsersDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        boolean flag = false;
        Cookie c[] = req.getCookies();
        String value;

        if (req.getCookies() != null) {
            for (Cookie c1 : c) {
                if (c1.getName().equals("cookie")) {
                    flag = true;
                }
            }
            if (flag) {
                for (Cookie c1 : c) {
                    if (c1.getName().equals("cookie")) {
                        value = c1.getValue();
                        String[] tokens = value.split("-");
                        switch (dao.getUserById(Integer.parseInt(tokens[0])).getRole()) {
                            case "admin":
                                resp.sendRedirect("admin");
                                break;
                            case "user":
                                resp.sendRedirect("user");
                                break;
                            default:
                                req.getRequestDispatcher("WEB-INF/hello.jsp").forward(req, resp);
                                break;
                        }
                    }
                }
            } else {
                req.getRequestDispatcher("WEB-INF/hello.jsp").forward(req, resp);
            }

        } else {
            req.getRequestDispatcher("WEB-INF/hello.jsp").forward(req, resp);
        }
    }
}
