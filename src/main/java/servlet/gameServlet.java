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


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(Jsputils.GAME).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        switch (req.getServletPath()){
            case Urlutils.NEW_GAME:
                Player player = (Player) req.getSession().getAttribute("loginuser");
                String playerName = player.getUsername();
                gameService.createGame(playerName);
                resp.sendRedirect(req.getContextPath() + Urlutils.GAME);
            break;

            case  Urlutils.GAME:

                break;

        }

    }
}
