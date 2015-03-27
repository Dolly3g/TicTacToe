package com.TicTacToe;
import java.util.Scanner;

public class GameMaster {
    Game game;
    private final static String[] symbols = {"O","X"};
    private int turn;

    public GameMaster() {
        turn = 1;
        game = new Game();
    }


    public void runGame() {
        Scanner ui = new Scanner(System.in);
        showBoard();
        while(!game.isOver()){
            if(game.isWin(symbols[turn])){
                declareWinner();
                break;
            }
            playGame(ui);
            showBoard();
        }
        declareGameOver();
    }

    private void declareGameOver() {
        System.out.println("Game Over!");
    }

    private void declareWinner() {
        System.out.println("You Won the Game!!");
    }

    private void playGame(Scanner ui) {
        switchTurn();
        try {
            System.out.print("Player "+symbols[turn]+": ");
            game.playAt(ui.nextInt(), ui.nextInt(), symbols[turn]);
        } catch (InvalidPlayException e) {
            System.out.println(e.getMessage());
            switchTurn();
        } catch (OutOfBoardException e) {
            System.out.println(e.getMessage());
            switchTurn();
        }
    }

    private void switchTurn() {
        turn = (turn == 0) ? 1 : 0;
    }

    private void showBoard() {
        System.out.println(game.drawBoard());
    }
}