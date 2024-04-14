package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.loginService;
import urls.Jsputils;
import urls.Urlutils;

import java.io.IOException;
import java.sql.SQLException;


@WebServlet(urlPatterns = Urlutils.REGISTER)
public class registerSerlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(Jsputils.REGISTER).forward(req, resp);
    }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        if(Urlutils.REGISTER.equals(req.getServletPath())){

            String Nameuser =  req.getParameter("user");
            String Password = req.getParameter("password");
            String configPassword = req.getParameter("configpassword");
            loginService lg = new loginService();
            if (!configPassword.equals(Password)){
                req.setAttribute("Error","Password is not match");
                req.getRequestDispatcher(Jsputils.REGISTER).forward(req,resp);
            }else {

                String error = null;
                try {
                    error = lg.cretedUser(Nameuser,Password);
                    if (error == null){
                        resp.sendRedirect(req.getContextPath() + Urlutils.LOGIN);
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

            }
        }
    }
}
