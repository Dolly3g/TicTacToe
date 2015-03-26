package com.TicTacToe;

public class OutOfBoardException extends Exception{
    String message;

    public OutOfBoardException(String message) {
        this.message = message;
    }
    @Override
    public String getMessage() {
        return message;
    }
}
