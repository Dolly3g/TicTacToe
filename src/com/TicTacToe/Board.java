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

    public boolean isRowComplete(String symbol) {
        for (int i = 0; i < SIZE; i++) {
            boolean status = true;
            for (int j = 0; j < SIZE; j++) {
                if(!coordinates[i][j].equals(symbol))
                    status = false;
            }
            if(status)
                return true;
        }
        return false;
    }
}
