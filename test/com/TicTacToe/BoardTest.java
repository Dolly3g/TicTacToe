package com.TicTacToe;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class BoardTest {
    @Test
    public void testDrawBoardDrawsEmptyBoard() {
        Board board = new Board();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("-\t-\t-\t");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("-\t-\t-\t");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("-\t-\t-\t");
        stringBuilder.append(System.lineSeparator());
        assertEquals(stringBuilder.toString(), board.draw());
    }

    @Test
    public void testisFullGivesFalseIfTheBoardIsNotFull() {
        Board board = new Board();
        assertFalse(board.isFull());
    }

}
