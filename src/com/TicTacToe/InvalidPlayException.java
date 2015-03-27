package com.TicTacToe;

public class InvalidPlayException extends Exception{
    String message;

    public InvalidPlayException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}