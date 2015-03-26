package com.TicTacToe;
import java.util.Scanner;

public class GameMaster {
    Game game;

    public GameMaster() {
        game = new Game();
    }

    public void runGame() {
        Scanner ui = new Scanner(System.in);
        showBoard();
        while(!game.isOver() && !game.isWin()){
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
        try {
            System.out.print("Enter Coordinates : ");
            game.playAt(ui.nextInt(), ui.nextInt());
        } catch (InvalidMoveException e) {
            System.out.println(e.getMessage());
        } catch (OutOfBoardException e) {
            System.out.println(e.getMessage());
        }
    }

    private void showBoard() {
        System.out.println(game.drawBoard());
    }
}