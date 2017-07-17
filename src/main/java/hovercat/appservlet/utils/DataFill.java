package hovercat.appservlet.utils;

import javax.servlet.http.HttpServletRequest;

public class DataFill {

    public void fill(HttpServletRequest req) {
        req.setAttribute("login", req.getParameter("login"));
        req.setAttribute("name", req.getParameter("name"));
        req.setAttribute("email", req.getParameter("email"));
    }
}
