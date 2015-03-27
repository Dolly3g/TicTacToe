package com.TicTacToe;

public class Board {
    private final static int SIZE =3;
    private String[][] coordinates = new String[SIZE][SIZE];

    public Board() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                coordinates[i][j] = "-";
            }
        }
    }

    public static int getSize() {
        return SIZE;
    }

    public String draw() {
        StringBuilder board = new StringBuilder();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board.append(coordinates[i][j]);
                board.append("\t");
            }
            board.append(System.lineSeparator());
        }
        return board.toString();
    }

    public void change(int row, int col, String symbol) {
        coordinates[row][col] = symbol;
    }

    public boolean isPlaceEmpty(int row, int col) {
        return coordinates[row][col].equals("-");
    }

    public boolean isFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if(isPlaceEmpty(i,j))
                    return false;
            }
        }
        return true;
    }



    public boolean isComplete(WinningCondition wc, String symbol) {
        boolean status = true;
        for (int i = 0; i < SIZE; i++,status = true) {
            for (int j = 0; j < SIZE; j++) {
                status = getStatus(wc, symbol, status, i, j);
            }
            if (status) return true;
        }
        return false;
    }

    private boolean getStatus(WinningCondition wc, String symbol, boolean status, int i, int j) {
        status = (wc==WinningCondition.ROW) ?
                checkSymbol(i,j, symbol, status) :
                checkSymbol(j,i, symbol, status);
        return status;
    }

    private boolean checkSymbol(int i, int j, String symbol, boolean status) {
        if(!coordinates[j][i].equals(symbol))
            status = false;
        return status;
    }

    public boolean isLeftDiagonalComplete(String symbol) {
        for (int i = 0; i < SIZE ; i++) {
            if(!coordinates[i][i].equals(symbol)){
                return false;
            }
        }
        return true;
    }

    public boolean isRightDiagonalComplete(String symbol) {
        for (int i = 0; i < SIZE ; i++) {
            for (int j = 0; j < SIZE; j++) {
                if(i+j == Math.ceil(SIZE/2.0)){
                    if(!coordinates[i][j].equals(symbol)){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
