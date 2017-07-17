package hovercat.appservlet.servlets;

import hovercat.appservlet.domain.Users;
import hovercat.appservlet.domain.UsersDaoImpl;
import hovercat.appservlet.utils.DataFill;
import static hovercat.appservlet.utils.ValidationCheck.loginValidate;
import static hovercat.appservlet.utils.ValidationCheck.mailValidate;
import static hovercat.appservlet.utils.ValidationCheck.nameValidate;
import static hovercat.appservlet.utils.ValidationCheck.passwordValidate;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AddUserServlet", urlPatterns = {"/admin/add"})
public class AddUserServlet extends HttpServlet {

    UsersDaoImpl dao = new UsersDaoImpl();

    DataFill data = new DataFill();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("login");
        String pass = req.getParameter("pass");
        String passConf = req.getParameter("passConf");
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String role = req.getParameter("role");

        Users user = dao.loadByLogin(login);

        if (user == null) {
            if (!loginValidate(login)) {
                data.fill(req);
                req.setAttribute("loginErr", "Wrong input. Login can't be empty or has whitespaces and special characters");
                req.getRequestDispatcher("/WEB-INF/add.jsp").forward(req, resp);
            } else if (!nameValidate(name)) {
                data.fill(req);
                req.setAttribute("nameErr", "Wrong input. Name can't be empty or shorter than three characters. "
                        + "No whitespace or special characters allowed also.");
                req.getRequestDispatcher("/WEB-INF/add.jsp").forward(req, resp);
            } else if (!passwordValidate(pass)) {
                data.fill(req);
                req.setAttribute("passErr", "Wrong input. "
                        + "Password must contain at least one digit, one lower and upper case, \n"
                        + "                        special character and at lest 8 characters long. \n"
                        + "                        No whitespace allowed also.");
                req.getRequestDispatcher("/WEB-INF/add.jsp").forward(req, resp);
            } else if (!pass.equals(passConf)) {
                data.fill(req);
                req.setAttribute("passConfErr", "Password confirmation doesn't match");
                req.getRequestDispatcher("/WEB-INF/add.jsp").forward(req, resp);
            } else if (!mailValidate(email)) {
                data.fill(req);
                req.setAttribute("mailErr", "Wrong email address");
                req.getRequestDispatcher("/WEB-INF/add.jsp").forward(req, resp);
            } else {
                dao.addUser(login, name, pass, email, role);
                resp.sendRedirect("/AppServlet/admin");
            }
        } else {
            data.fill(req);
            req.setAttribute("loginErr", "login already occupied");
            req.getRequestDispatcher("/WEB-INF/add.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/add.jsp").forward(req, resp);
    }

}