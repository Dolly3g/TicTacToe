package com.TicTacToe;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class GameMaster {
    Game game;
    private final static String[] symbols = {"O", "X"};
    private int turn;

    public GameMaster() {
        turn = 0;
        game = new Game();
    }


    public void runGame() {
        Scanner ui = new Scanner(System.in);
        showBoard();
        while (!game.isOver()) {
            if (game.isWin(symbols[turn])) {
                declareWinner(symbols[turn]);
            }
            playGame(ui);
            showBoard();
        }
        declareGameOver();
    }

    private void declareGameOver() {
        System.out.println("Game Tied! Try again! Hit Ctrl+F5");
    }

    private void declareWinner(String symbol) {
        System.out.println("Player " + symbol + " Won the Game!!");
        System.exit(0);
    }

    private void playGame(Scanner ui) {
        try {
            displayPlayer();
            game.playAt(ui.nextInt(), ui.nextInt(), symbols[turn]);
            switchTurn();
        } catch (InvalidPlayException e) {
            System.out.println(e.getMessage());
        } catch (OutOfBoardException e) {
            System.out.println(e.getMessage());
        } catch (NoSuchElementException e) {
            System.out.println("Game Abnormally Terminated!");
            System.exit(1);
        }
    }

    private void displayPlayer() {
        System.out.print("Player " + symbols[turn] + ": ");
    }

    private void switchTurn() {
        turn = (turn == 0) ? 1 : 0;
    }

    private void showBoard() {
        System.out.println(game.drawBoard());
    }
}