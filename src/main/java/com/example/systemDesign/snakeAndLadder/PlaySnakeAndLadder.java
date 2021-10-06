package com.example.systemDesign.snakeAndLadder;

import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class PlaySnakeAndLadder {

    public static void main(String[] args) {
        Dice dice = new Dice(1);
        Queue<Player> allPlayers = new LinkedList<>();
        allPlayers.offer(new Player(1,"Ashish"));
        allPlayers.offer(new Player(2,"Raj"));

        Map<Integer,Integer> snakes = new HashMap<>();
        snakes.put(10,2);
        snakes.put(99,12);

        Map<Integer,Integer> ladders = new HashMap<>();
        ladders.put(5,25);
        ladders.put(40,100);

        Map<Integer,Integer> playersCurrentPosition = new HashMap<>();
        playersCurrentPosition.put(1,0);
        playersCurrentPosition.put(2,0);
        GameBoard gameBoard = GameBoard.builder().boardSize(100).dice(dice).ladders(ladders).snakes(snakes).
                nextTurn(allPlayers).playerCurrentPosition(playersCurrentPosition).build();
        gameBoard.startGame();
    }

}
