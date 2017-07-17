package hovercat.appservlet.auth;

import hovercat.appservlet.domain.Users;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(filterName = "CookieFilter", urlPatterns = {"/AppServlet"})
public class CookieFilter implements Filter {

    Users user;

    private final String cookieName = "cookie";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        Cookie[] cookies = req.getCookies();

        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals(cookieName)) {
                    if (!c.getValue().isEmpty()) {
                        if (AuthenticationStorage.tokens.contains(c.getValue())) {
                            chain.doFilter(request, response);
                        } else {
                            ((HttpServletResponse) response).sendRedirect("hello");
                        }
                    }
                }
            }
        }
    }

    @Override
    public void destroy() {
    }

    @Override
    public void init(FilterConfig filterConfig) {

    }

}
