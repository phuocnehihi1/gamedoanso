package service;

import model.Game;
import repository.gameRepository;

import java.sql.SQLException;
import java.time.LocalDateTime;


public class gameService {
    gameRepository gameRepo = new gameRepository();


    public Game createGame(String game) {
        Game createdGame = new Game(game);
        try {
            gameRepo.createGameR(createdGame);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return createdGame;
    }
}
