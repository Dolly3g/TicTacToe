package com.TicTacToe;

public class Game {
    private Board board;

    public Game() {
        board = new Board();
    }

    public void playAt(int row, int col, String symbol) throws InvalidPlayException, OutOfBoardException {
        if (isOutOfBoard(row, col)){
            throw new OutOfBoardException("You cant play outside the Board!!");
        }
        if(!isValidMove(row, col)){
            throw new InvalidPlayException("That has already been played!!");
        }
        board.change(row,col,symbol);
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

    public boolean isWin(String symbol) {
        return board.isComplete(WinningCondition.ROW , symbol) ||
                board.isComplete(WinningCondition.COL, symbol) ||
                board.isLeftDiagonalComplete(symbol) ||
                board.isRightDiagonalComplete(symbol);
    }
}
