package repository;

import jdbc.myConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalTime;
import java.sql.Timestamp;

public class gameRepository {



    public void createGameR(String GameID, int targetGame, LocalTime startTime, LocalTime endTime,int iscomplete, String userName, int isActive ) throws SQLException {

        System.out.println(GameID);/*1*/
        System.out.println(targetGame);/*2*/
        System.out.println(startTime);/*3*/
        System.out.println(endTime); /*4*/
        System.out.println(iscomplete);/*5*/
        System.out.println(userName);/*6*/
        System.out.println(isActive);/*7*/
//        System.out.println(GameID);




        String sql = "INSERT INTO Game (GameID, targetGame,startTime,endTime,iscomplete,userName,isActive ) VALUES (?, ?,?,?,?,?,?)";
        Connection conn = myConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        try{
            ps.setString(1, GameID);
            ps.setInt(2, targetGame);
            ps.setTimestamp(3,LocalTime.now(startTime));
            ps.setObject(4, endTime);
            ps.setInt(5, iscomplete);
            ps.setString(6, userName);
            ps.setInt(7, isActive);
            Timestamp timestamp = Timestamp.valueOf(now);
            int rowsAffected = ps.executeUpdate();

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
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
