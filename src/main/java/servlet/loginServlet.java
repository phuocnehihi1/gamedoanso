package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Player;
import service.loginService;
import urls.Jsputils;
import urls.Urlutils;

import java.io.IOException;


//utils u = new utils();
//Jsputils jsp = new Jsputils();
@WebServlet(urlPatterns = Urlutils.LOGIN)
public class loginServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(Jsputils.LOGIN).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

      if(Urlutils.LOGIN.equals(req.getServletPath())){
            String username = req.getParameter("user");
            String password = req.getParameter("password");
            loginService loginService = new loginService();
            Player player = loginService.login(username, password);

            if(player != null){
                req.getSession().setAttribute("loginuser", player);
                resp.sendRedirect(req.getContextPath() + Urlutils.GAME);


            }else {
                req.setAttribute("Error", "Username or password is not found");
                req.getRequestDispatcher(Jsputils.LOGIN).forward(req, resp);

            }

      }

    }

}
