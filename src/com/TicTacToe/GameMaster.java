package com.TicTacToe;

import java.util.Scanner;

public class GameMaster {
    Game game;

    public GameMaster() {
        game = new Game();
    }

    public void runGame() {
        Scanner ui = new Scanner(System.in);
        printBoard();
        while(!game.isOver()){
            playGame(ui);
            printBoard();
            if(game.isWin())break;
        }
    }

    private void playGame(Scanner ui) {
        try {
            System.out.print("Enter Coordinates : ");
            game.playAt(ui.nextInt(), ui.nextInt());
        } catch (InvalidMoveException e) {
            System.out.println(e.getMessage());
        } catch (OutOfBoardException e) {
            System.out.println(e.getMessage());
        }
    }

    private void printBoard() {
        System.out.println(game.drawBoard());
    }
}
