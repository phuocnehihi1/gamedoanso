package model;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Data
@AllArgsConstructor
public class Game {
    private  Random random;
    private  String  GameID;
    private int tagertGame;
    private int tarGetNumber;
    private  LocalDateTime startTime;
    private  LocalDateTime endTime;
    private List<Guess> guessList;
    private int iscomplete;
    private  int isActive;
    private String userName;


    public  Game(String userName){

        this.GameID ="GAME"+ String.format( "%04d",randomTagertGame(1000));
        this.tagertGame = randomTagertGame(1000);
        this.startTime = LocalDateTime.now();
        this.endTime = null;
        this.guessList = new ArrayList<>();
        this.iscomplete = -1;
        this.isActive = 1;
        this.userName = userName;
    }




    public int randomTagertGame(int max){

       if (random == null){
           random = new Random();
       }
       return  random.nextInt(max);
    }

}
