package com.example.systemDesign.snakeAndLadder;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Dice {

    int numberOfDice;

    public int rollDice(){
        return ((int) (Math.random() * ((6*numberOfDice) - (numberOfDice-1))))+numberOfDice;
    }
}
