package com.example.systemDesign.snakeAndLadder;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.Queue;

@Builder
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GameBoard {

    int boardSize;
    Dice dice;
    Queue<Player> nextTurn;
    Map<Integer, Integer> snakes;
    Map<Integer, Integer> ladders;
    Map<Integer, Integer> playerCurrentPosition;

     void startGame(){
        while(nextTurn.size()>1){
            Player player = nextTurn.poll();
            int currentPosition = playerCurrentPosition.get(player.getId());
            int diceValue = dice.rollDice();
            log.info("Dice value {}", diceValue);
            int nextCell = diceValue +currentPosition;
            if(nextCell > boardSize){
                log.info("{} out of Board Size", player.getPlayerName());
                nextTurn.offer(player);
            }
            else if(nextCell == boardSize){
                log.info("{} won the game", player.getPlayerName());
            }else {
                int nextPosition = nextCell;
                if(snakes.containsKey(nextCell)){
                    nextPosition = snakes.get(nextCell);
                }
                if(nextPosition != nextCell){
                    log.info("{} Bitten by snake present at : {}",player.getPlayerName(), nextCell);
                }else {
                    if(ladders.containsKey(nextCell)){
                        nextPosition = ladders.get(nextCell);
                    }
                    if(nextPosition!= nextCell){
                        log.info("{} Got ladder at position : {}",player.getPlayerName(), nextCell);
                    }
                    if(nextPosition == boardSize){
                        log.info("{} won the game", player.getPlayerName());
                        continue;
                    }
                }
                playerCurrentPosition.put(player.getId(), nextPosition);
                log.info("{} is at position : {}",player.getPlayerName(), nextPosition);
                nextTurn.offer(player);

            }
        }
    }
}
