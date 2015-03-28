package com.TicTacToe;
public class Game {
    private Board board = new Board();
    public enum MarkResult{
        OutOfBoard,AlreadyMarked,OK
    }
    public MarkResult mark(int row, int col, String symbol) {
        int size = board.getSize();
        boolean isOutOfBoard = row >= size ||
                col >= size || row < 0 || col < 0;
        if (isOutOfBoard) return MarkResult.OutOfBoard;
        if(!board.isPlaceEmpty(row, col)) return MarkResult.AlreadyMarked;
        board.mark(row, col, symbol);
        return MarkResult.OK;
    }

    public boolean isOver() {
        return board.isFull();
    }

    public String drawBoard() {
        return board.draw();
    }

    //TODO: Combine 4 method calls and ask once
    public boolean isWonBy(String symbol) {
        return board.isComplete(WinningCondition.ROW , symbol) ||
                board.isComplete(WinningCondition.COL, symbol) ||
                board.isLeftDiagonalComplete(symbol) ||
                board.isRightDiagonalComplete(symbol);
    }
}
