package com.TicTacToe;

public class GameMaster {
    public static final String BANNER = "Tic-Tac-Toe\n";
    Game game = new Game();
    private boolean isFirstPlayersTurn = true;

    public String nextMove(Position position) {
        String currentPlayer = isFirstPlayersTurn ? "X" : "O";
        String nextPlayer = isFirstPlayersTurn ? "O" : "X";
        String playErrorMessage = playGame(position, currentPlayer);
        if (playErrorMessage != null)
            return playErrorMessage;
        isFirstPlayersTurn = !isFirstPlayersTurn;
        return game.isWonBy(currentPlayer) ?
                "Player " + currentPlayer + " Won the Game!!" :
                "Player " + nextPlayer + ": ";
    }

    private String playGame(Position position, String symbol) {
        Game.MarkResult result = game.mark(position.row, position.col, symbol);
        if (result == Game.MarkResult.OutOfBoard)
            return "You cant play outside the Board!!";
        if (result == Game.MarkResult.AlreadyMarked)
            return "That has already been played!!";
        return null;
    }

    public String showBoard() {
        return game.drawBoard();
    }

    public boolean isGameOn() {
        boolean finished = game.isOver() ||
                game.isWonBy("X") || game.isWonBy("O");
        return !finished;
    }
}