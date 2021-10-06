package com.example.systemDesign.ticTacToe;

public class Game {
    public static void main(String [] args){
        TicTacToe ticTacToe = new TicTacToe(3);
       System.out.println(ticTacToe.move(0, 1, 2));
    }
}
