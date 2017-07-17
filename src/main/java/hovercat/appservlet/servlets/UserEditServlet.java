package hovercat.appservlet.servlets;

import hovercat.appservlet.domain.Users;
import hovercat.appservlet.domain.UsersDaoImpl;
import static hovercat.appservlet.utils.ValidationCheck.mailValidate;
import static hovercat.appservlet.utils.ValidationCheck.passwordValidate;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@WebServlet(name = "UserEditServlet", urlPatterns = {"/userEdit"})
public class UserEditServlet extends HttpServlet {

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UsersDaoImpl dao = new UsersDaoImpl();
        Users user = dao.getUserById(Integer.parseInt(req.getParameter("id")));

        String pass = req.getParameter("pass");
        String passConf = req.getParameter("passConf");
        String email = req.getParameter("email");

        if (!mailValidate(email)) {
            req.setAttribute("user", user);
            req.setAttribute("mailErr", "Wrong email address");
            req.getRequestDispatcher("/WEB-INF/userEdit.jsp").forward(req, resp);
        } else if (!passwordValidate(pass)) {
            req.setAttribute("user", user);
            req.setAttribute("passErr", "Wrong input. "
                    + "Password must contain at least one digit, one lower and upper case, \n"
                    + "                        special character and at lest 8 characters long. \n"
                    + "                        No whitespace allowed also.");
            req.getRequestDispatcher("/WEB-INF/userEdit.jsp").forward(req, resp);
        } else if (!pass.equals(passConf)) {
            req.setAttribute("user", user);
            req.setAttribute("passConfErr", "Password confirmation doesn't match");
            req.getRequestDispatcher("/WEB-INF/userEdit.jsp").forward(req, resp);
        } else {
            user.setEmail(email);
            user.setPassword(encoder.encode(req.getParameter("pass")));

            dao.updateUser(user);
            req.setAttribute("user", user);
            req.getRequestDispatcher("/WEB-INF/user.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = 0;

        try {
            id = Integer.parseInt(req.getParameter("id"));
        } catch (NumberFormatException e) {
            resp.sendRedirect("/AppServlet/user");
        }
        req.setAttribute("user", new UsersDaoImpl().getUserById(id));
        req.getRequestDispatcher("/WEB-INF/userEdit.jsp").forward(req, resp);
    }

}
