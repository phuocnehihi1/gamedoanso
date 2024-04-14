package filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.Player;
import urls.Jsputils;
import urls.Urlutils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebFilter(urlPatterns = Urlutils.GAME)
public class loginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        Player player = (Player) req.getSession().getAttribute("loginuser");
        if (player == null) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }
        chain.doFilter(request,response);


    }
    public boolean CheckUrl(HttpServletRequest req) {
        return req.getServletPath().equals(Urlutils.LOGIN) || req.getServletPath().equals(Urlutils.REGISTER);


    }
}
