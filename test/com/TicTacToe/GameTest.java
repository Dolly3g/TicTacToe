package com.TicTacToe;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class GameTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void testPlayer1CanPlayAt_0_0_WithHisSymbol_O() throws InvalidPlayException, OutOfBoardException {
        Game game = new Game();
        game.playAt(0, 0, "O");
        StringBuilder expected = new StringBuilder();
        expected.append("O\t-\t-\t");
        expected.append(System.lineSeparator());
        expected.append("-\t-\t-\t");
        expected.append(System.lineSeparator());
        expected.append("-\t-\t-\t");
        expected.append(System.lineSeparator());
        assertEquals(expected.toString(), game.drawBoard());
    }

    @Test
    public void testPlayer2CanPlayAt_0_1_WithHisSymbol_X() throws InvalidPlayException, OutOfBoardException {
        Game game = new Game();
        game.playAt(0, 0, "O");
        game.playAt(0, 1, "X");
        StringBuilder expected = new StringBuilder();
        expected.append("O\tX\t-\t");
        expected.append(System.lineSeparator());
        expected.append("-\t-\t-\t");
        expected.append(System.lineSeparator());
        expected.append("-\t-\t-\t");
        expected.append(System.lineSeparator());
        assertEquals(expected.toString(), game.drawBoard());
    }

    @Test
    public void testPlayer1CanPlayAgainAt_2_2_WithHisSymbol_O() throws InvalidPlayException, OutOfBoardException {
        Board board = new Board();
        Game game = new Game();
        game.playAt(0, 0, "O");
        game.playAt(0, 1, "X");
        game.playAt(2, 2, "O");
        StringBuilder expected = new StringBuilder();
        expected.append("O\tX\t-\t");
        expected.append(System.lineSeparator());
        expected.append("-\t-\t-\t");
        expected.append(System.lineSeparator());
        expected.append("-\t-\tO\t");
        expected.append(System.lineSeparator());
        assertEquals(expected.toString(), game.drawBoard());
    }

    @Test
    public void testPlayer2CanPlayAgainAt_2_1_WithHisSymbol_X() throws InvalidPlayException, OutOfBoardException {
        Board board = new Board();
        Game game = new Game();
        game.playAt(0, 0, "O");
        game.playAt(0, 1, "X");
        game.playAt(2, 2, "O");
        game.playAt(2, 1, "X");
        StringBuilder expected = new StringBuilder();
        expected.append("O\tX\t-\t");
        expected.append(System.lineSeparator());
        expected.append("-\t-\t-\t");
        expected.append(System.lineSeparator());
        expected.append("-\tX\tO\t");
        expected.append(System.lineSeparator());
        assertEquals(expected.toString(), game.drawBoard());
    }

    @Test
    public void testPlayerCantPlayAtThePlaceAlreadyPlayed() throws InvalidPlayException, OutOfBoardException {
        Game game = new Game();
        game.playAt(0, 0, "O");
        exception.expect(InvalidPlayException.class);
        exception.expectMessage("That has already been played!!");
        game.playAt(0, 0, "X");
    }

    @Test
    public void testPlayerCantPlayOutOfTheBoard() throws OutOfBoardException, InvalidPlayException {
        Game game = new Game();
        exception.expect(OutOfBoardException.class);
        exception.expectMessage("You cant play outside the Board!!");
        game.playAt(3, 3, "O");
    }

    @Test
    public void testPlayerCantPlayOnNegativeCoordinates() throws OutOfBoardException, InvalidPlayException {
        Game game = new Game();
        exception.expect(OutOfBoardException.class);
        exception.expectMessage("You cant play outside the Board!!");
        game.playAt(0, -1, "O");
    }

    @Test
    public void testIsOverReturnsFalseIfTheGameIsRunning() throws OutOfBoardException, InvalidPlayException {
        Game game = new Game();
        assertFalse(game.isOver());
    }

    @Test
    public void testisOverGivesTrueIfTheBoardIsFilledCompletely() throws InvalidPlayException, OutOfBoardException {
        Game game = new Game();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                game.playAt(i, j, "O");
            }
        }
        assertTrue(game.isOver());
    }

    @Test
    public void testisWinGivesTrueIfTheBoardHasAll_O_OnFirstRow() throws InvalidPlayException, OutOfBoardException {
        Game game = new Game();
        game.playAt(0, 0, "O");
        game.playAt(1, 0, "X");
        game.playAt(0, 1, "O");
        game.playAt(2, 0, "X");
        game.playAt(0, 2, "O");
        assertTrue(game.isWin("O"));
    }

    @Test
    public void testisWinGivesTrueIfTheBoardHasAll_O_OnSecondRow() throws InvalidPlayException, OutOfBoardException {
        Game game = new Game();
        game.playAt(1, 0, "O");
        game.playAt(0, 0, "X");
        game.playAt(1, 1, "O");
        game.playAt(2, 2, "X");
        game.playAt(1, 2, "O");
        assertTrue(game.isWin("O"));
    }

    @Test
    public void testisWinGivesFalseIfTheBoardDoesNotHaveAll_X_OnFirstRow() throws InvalidPlayException, OutOfBoardException {
        Game game = new Game();
        game.playAt(0, 0, "O");
        game.playAt(1, 2, "X");
        game.playAt(0, 1, "O");
        game.playAt(0, 2, "X");
        game.playAt(2, 2, "O");
        assertFalse(game.isWin("X"));
    }

    @Test
    public void testisWinGivesTrueIfTheBoardHasAll_O_OnFirstColumn() throws InvalidPlayException, OutOfBoardException {
        Game game = new Game();
        game.playAt(0, 0, "O");
        game.playAt(0, 1, "X");
        game.playAt(1, 0, "O");
        game.playAt(2, 2, "X");
        game.playAt(2, 0, "O");
        assertTrue(game.isWin("O"));
    }

    @Test
    public void testisWinGivesTrueIfTheBoardHasAll_O_OnLeftDiagonal() throws InvalidPlayException, OutOfBoardException {
        Game game = new Game();
        game.playAt(0, 0, "O");
        game.playAt(0, 1, "X");
        game.playAt(1, 1, "O");
        game.playAt(2, 0, "X");
        game.playAt(2, 2, "O");
        assertTrue(game.isWin("O"));
    }

    @Test
    public void testisWinGivesTrueIfTheBoardHasAll_O_OnRightDiagonal() throws InvalidPlayException, OutOfBoardException {
        Game game = new Game();
        game.playAt(0, 2, "O");
        game.playAt(0, 1, "X");
        game.playAt(1, 1, "O");
        game.playAt(2, 2, "X");
        game.playAt(2, 0, "O");
        assertTrue(game.isWin("O"));
    }
}
