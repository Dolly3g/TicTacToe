package com.TicTacToe;

public class Game {
    private Board board;
    private final static String[] symbols = {"O","X"};
    private int turn;

    public Game() {
        board = new Board();
        turn = 1;
    }

    public void playAt(int row, int col) throws InvalidMoveException, OutOfBoardException {
        turn = (turn == 0) ? 1 : 0;
        if (isOutOfBoard(row, col)){
            throw new OutOfBoardException("You cant play outside the Board!!");
        }
        if(!isValidMove(row, col)){
            throw new InvalidMoveException("Invalid Move!!");
        }
        board.change(row,col,symbols[turn]);
    }

    private boolean isOutOfBoard(int row, int col) {
        return row >= board.getSize() || col >= board.getSize() || row < 0 || col < 0;
    }

    private boolean isValidMove(int row, int col) {
        return board.isPlaceEmpty(row, col);
    }

    public boolean isOver() {
        return board.isFull();
    }

    public String drawBoard() {
        return board.draw();
    }

    public boolean isWin() {
        return board.isRowComplete(symbols[turn]);
    }
}
