package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import urls.Urlutils;

import java.io.IOException;


@WebServlet(urlPatterns = Urlutils.LOGOUT)
public class logoutServlet extends HttpServlet {




    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(Urlutils.LOGOUT.equals(req.getServletPath())){
            req.getSession().invalidate();
            resp.sendRedirect(req.getContextPath() + Urlutils.LOGIN);

        }
    }
}
