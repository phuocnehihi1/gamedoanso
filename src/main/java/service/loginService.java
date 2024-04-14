package service;

import model.Player;
import repository.loginRepository;

import java.sql.SQLException;

public class loginService {

    loginRepository loginRepo = new loginRepository();

//Hàm Login Đăng nhập Check != null
    public Player login(String username, String password){

        Player player = null;
        try {

            player = loginRepo.getPlayer(username);
            if(player != null && player.getPassword().equals(password)) return player;
            else  return null;
        } catch (SQLException e ) {
            throw new RuntimeException(e);
        }

    }
// Hàm Service dùng để giao tiếp với from end nhận tham số từ FE và BE.
    public String cretedUser(String username, String password) throws SQLException{

       Player player = loginRepo.getPlayer(username);
        if(player == null){

            loginRepo.Save(username,password);
        }else {

            return "User Name Exits";
        }
        return  null;
    }

}
