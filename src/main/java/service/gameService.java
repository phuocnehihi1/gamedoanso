package service;

import model.Game;
import repository.gameRepository;

import java.sql.SQLException;
import java.time.LocalTime;

public class gameService {
    gameRepository gameRepo = new gameRepository();


    public Game createGame(String game) {
        Game createdGame = new Game(game);
      String GameID = createdGame.getGameID();
      int targetGame = createdGame.getTagertGame();
      LocalTime startTime = LocalTime.from(createdGame.getStartTime());
      LocalTime endTime = null;
      int iscomplete = createdGame.getIscomplete();
      String userName = createdGame.getUserName();
      int isActive = createdGame.getIsActive();
        try {
            gameRepo.createGameR(GameID,targetGame,startTime, endTime, iscomplete,userName,isActive);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return createdGame;
    }
}
