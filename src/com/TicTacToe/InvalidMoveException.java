package com.TicTacToe;

public class InvalidMoveException extends Exception{
    String message;

    public InvalidMoveException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
