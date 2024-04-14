package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import urls.Jsputils;
import urls.Urlutils;

import java.io.IOException;

@WebServlet(urlPatterns = {Urlutils.GAME, Urlutils.NEW_GAME})
public class gameServlet extends HttpServlet {
    @Overridegit init
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(Jsputils.GAME).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        switch (req.getServletPath()){
            case Urlutils.NEW_GAME:
                System.out.println("VO HUU PHUOC");
            break;

            case  Urlutils.GAME:

                break;

        }

    }
}
