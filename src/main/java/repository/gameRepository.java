package repository;

import jdbc.myConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalTime;

public class gameRepository {



    public void createGameR(String GameID, int targetGame, LocalTime startTime, LocalTime endTime,int iscomplete, String userName, int isActive ) throws SQLException {
        String sql = "INSERT INTO Game (GameID, targetGame,startTime,endTime,iscomplete,userName,isActive ) VALUES (?, ?,?,?,?,?,?)";
        Connection connection = myConnection.getConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, GameID);
            preparedStatement.setInt(2, targetGame);
            preparedStatement.setTimestamp(3, java.sql.Timestamp.valueOf(startTime.toString()));
            preparedStatement.setTimestamp(4, java.sql.Timestamp.valueOf(endTime.toString()));
            preparedStatement.setInt(5, iscomplete);
            preparedStatement.setString(6, userName);
            preparedStatement.setInt(7, isActive);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Insert successful!");
            } else {
                System.out.println("Insert failed!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Đóng kết nối
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
