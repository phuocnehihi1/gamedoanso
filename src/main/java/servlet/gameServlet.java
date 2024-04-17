package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Game;
import model.Player;
import service.gameService;
import urls.Jsputils;
import urls.Urlutils;

import java.io.IOException;

@WebServlet(urlPatterns = {Urlutils.GAME, Urlutils.NEW_GAME})
public class gameServlet extends HttpServlet {
    gameService gameService = new gameService();
    private String name;


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(Jsputils.GAME).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        System.out.println(req.getServletPath());
        switch (req.getServletPath()){


            case Urlutils.NEW_GAME:
                /* Get name Player take url parameter*/
                name = req.getParameter("username");
              Game game =  gameService.createGame(name);

              req.getSession().setAttribute("game", game);
                resp.sendRedirect(req.getContextPath() + Urlutils.GAME);
            break;

            case  Urlutils.GAME:
                int number = Integer.parseInt(req.getParameter("number-guess"));
                name = req.getParameter("username");
                System.out.println("Tên Người Chơi: " + name + " ");
                System.out.println("Number gusee: " + number);
                resp.sendRedirect(req.getContextPath() + Urlutils.GAME);
                break;

        }

    }
}
