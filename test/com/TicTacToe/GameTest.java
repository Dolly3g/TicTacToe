package com.TicTacToe;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GameTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void testPlayer1CanPlayAt_0_0_WithHisSymbol_O() throws InvalidMoveException, OutOfBoardException {
        Game game = new Game();
        game.playAt(0, 0);
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
    public void testPlayer2CanPlayAt_0_1_WithHisSymbol_X() throws InvalidMoveException, OutOfBoardException {
        Game game = new Game();
        game.playAt(0, 0);
        game.playAt(0, 1);
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
    public void testPlayer1CanPlayAgainAt_2_2_WithHisSymbol_O() throws InvalidMoveException, OutOfBoardException {
        Board board = new Board();
        Game game = new Game();
        game.playAt(0, 0);
        game.playAt(0, 1);
        game.playAt(2, 2);
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
    public void testPlayer2CanPlayAgainAt_2_1_WithHisSymbol_X() throws InvalidMoveException, OutOfBoardException {
        Board board = new Board();
        Game game = new Game();
        game.playAt(0, 0);
        game.playAt(0, 1);
        game.playAt(2, 2);
        game.playAt(2, 1);
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
    public void testPlayerCantPlayAtThePlaceAlreadyPlayed() throws InvalidMoveException, OutOfBoardException {
        Game game = new Game();
        game.playAt(0, 0);
        exception.expect(InvalidMoveException.class);
        exception.expectMessage("Invalid Move!!");
        game.playAt(0, 0);
    }

    @Test
    public void testPlayerCantPlayOutOfTheBoard() throws OutOfBoardException, InvalidMoveException {
        Game game = new Game();
        exception.expect(OutOfBoardException.class);
        exception.expectMessage("You cant play outside the Board!!");
        game.playAt(3, 3);
    }

    @Test
    public void testPlayerCantPlayOnNegativeCoordinates() throws OutOfBoardException, InvalidMoveException {
        Game game = new Game();
        exception.expect(OutOfBoardException.class);
        exception.expectMessage("You cant play outside the Board!!");
        game.playAt(0, -1);
    }

    @Test
    public void testIsOverReturnsFalseIfTheGameIsRunning() throws OutOfBoardException, InvalidMoveException {
        Game game = new Game();
        assertFalse(game.isOver());
    }

    @Test
    public void testisOverGivesTrueIfTheBoardIsFilledCompletely() throws InvalidMoveException, OutOfBoardException {
        Game game = new Game();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                game.playAt(i,j);
            }
        }
        assertTrue(game.isOver());
    }

    @Test
    public void testisWinGivesTrueIfTheBoardHasAll_O_OnFirstRow() throws InvalidMoveException, OutOfBoardException {
        Game game = new Game();
        game.playAt(0,0);
        game.playAt(1,0);
        game.playAt(0,1);
        game.playAt(2,0);
        game.playAt(0,2);
        assertTrue(game.isWin());
    }

    @Test
    public void testisWinGivesTrueIfTheBoardHasAll_X_OnSecondRow() throws InvalidMoveException, OutOfBoardException {
        Game game = new Game();
        game.playAt(1, 0);
        game.playAt(0, 0);
        game.playAt(1, 1);
        game.playAt(2, 2);
        game.playAt(1, 2);
        assertTrue(game.isWin());
    }

    @Test
    public void testisWinGivesFalseIfTheBoardDoesNotHaveAll_X_OnFirstRow() throws InvalidMoveException, OutOfBoardException {
        Game game = new Game();
        game.playAt(0, 0);
        game.playAt(1, 2);
        game.playAt(0, 1);
        game.playAt(0, 2);
        game.playAt(2, 2);
        assertFalse(game.isWin());
    }
}
