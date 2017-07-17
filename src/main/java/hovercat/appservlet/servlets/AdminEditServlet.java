package hovercat.appservlet.servlets;

import hovercat.appservlet.domain.Users;
import hovercat.appservlet.domain.UsersDaoImpl;
import static hovercat.appservlet.utils.ValidationCheck.nameValidate;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EditServlet", urlPatterns = {"/admin/edit"})
public class AdminEditServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UsersDaoImpl dao = new UsersDaoImpl();
        Users user = dao.getUserById(Integer.parseInt(req.getParameter("id")));

        String name = req.getParameter("name");

        if (!nameValidate(name)) {
            req.setAttribute("name", name);
            req.setAttribute("nameErr", "Wrong input. Name can't be empty or shorter than two characters. "
                    + "No whitespace or special characters allowed also.");
            req.getRequestDispatcher("/WEB-INF/edit.jsp").forward(req, resp);
        } else {
            user.setName(req.getParameter("name"));
            user.setRole(req.getParameter("role"));

            dao.updateUser(user);
            resp.sendRedirect("/AppServlet/admin");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = 0;

        try {
            id = Integer.parseInt(req.getParameter("id"));
        } catch (NumberFormatException e) {
            resp.sendRedirect("/AppServlet/admin");
        }
        req.setAttribute("user", new UsersDaoImpl().getUserById(id));
        req.getRequestDispatcher("/WEB-INF/edit.jsp").forward(req, resp);
    }
}
