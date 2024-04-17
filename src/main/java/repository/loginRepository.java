package repository;

import jdbc.myConnection;
import model.Player;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class loginRepository extends AbtracRepository<Player> {

    public Player getPlayer(String username ) throws SQLException {

       return ExcuteQuery(connection -> {
            Player player = null;
            String query = "SELECT * FROM Player WHERE username = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                player = new Player(resultSet.getString("username"), resultSet.getString("password"));

            }
            return  player;
        });
    }



    public Player Save(String username, String password) throws SQLException{


       return ExcuteQuery(connection -> {
            String query = "INSERT INTO Player (username, password) VALUES (?, ?)";
            PreparedStatement pr = connection.prepareStatement(query);
            pr.setString(1, username);
            pr.setString(2, password);
            pr.executeUpdate();
           return  null;
        });


    }

}
