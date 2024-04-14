package model;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
public class Game {

    private  String GameID;
    private int tagertGame;
    private int tarGetNumber;
    private  LocalDateTime startTime;
    private  LocalDateTime endTime;
    private int iscomplete;
    private Player userName;

}
