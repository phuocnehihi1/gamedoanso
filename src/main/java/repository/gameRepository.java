package repository;

import jdbc.myConnection;
import model.Game;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.sql.Timestamp;

public class gameRepository extends AbtracRepository<Game> {



    public void createGameR(Game game) throws SQLException {


            ExcuteQueryUpdate(connection -> {
            String sql = "INSERT INTO Game (GameID, targetGame,startTime,userName) VALUES (?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            int i = 1;
            preparedStatement.setString(i++, game.getGameID());
            preparedStatement.setInt(i++, game.getTagertGame());
            preparedStatement.setTimestamp(i++, Timestamp.valueOf(game.getStartTime()));
            System.out.println(i);
            preparedStatement.setString(i++, game.getUserName());
            preparedStatement.executeUpdate();
            return game;

        });

    }

}
