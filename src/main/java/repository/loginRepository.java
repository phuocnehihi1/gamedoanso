package repository;

import jdbc.myConnection;
import model.Player;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class loginRepository {

    public Player getPlayer(String username ) throws SQLException {

        Player player = null;
        String sql = "select * from Player where username=?";
        Connection coon = myConnection.getConnection();
        try{
            PreparedStatement st = coon.prepareStatement(sql);
            st.setString(1,username);
            ResultSet result = st.executeQuery();


            while (result.next()){
                player = new Player();
                player.setUsername(result.getString("Username"));
                player.setPassword(result.getString("Password"));

            }
        }  catch (SQLException e) {

            // Display the DB exception if any
            System.out.println(e);
        }finally {
            if(coon != null){
                coon.close();
            }
        }
        return player;

    }
    public void Save(String username, String password) throws SQLException{

        Player player =getPlayer(username);
        String sql = " insert into Player (Username, Password) values (?,?) ";
        Connection conn  = myConnection.getConnection();
        try {
            if (player == null) {

                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, username);
                ps.setString(2, password);
                ps.executeUpdate();
            }

        }catch ( SQLException e){

        }finally {
            if (conn != null){
                conn.close();
            }

        }
    }

}
