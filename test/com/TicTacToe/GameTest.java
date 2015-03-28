package com.TicTacToe;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class GameTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void testPlayer1CanPlayAt_0_0_WithHisSymbol_O(){
        Game game = new Game();
        game.mark(0, 0, "O");
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
    public void testPlayer2CanPlayAt_0_1_WithHisSymbol_X(){
        Game game = new Game();
        game.mark(0, 0, "O");
        game.mark(0, 1, "X");
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
    public void testPlayer1CanPlayAgainAt_2_2_WithHisSymbol_O() {
        Board board = new Board();
        Game game = new Game();
        game.mark(0, 0, "O");
        game.mark(0, 1, "X");
        game.mark(2, 2, "O");
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
    public void testPlayer2CanPlayAgainAt_2_1_WithHisSymbol_X() {
        Board board = new Board();
        Game game = new Game();
        game.mark(0, 0, "O");
        game.mark(0, 1, "X");
        game.mark(2, 2, "O");
        game.mark(2, 1, "X");
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
    public void testPlayerCantPlayAtThePlaceAlreadyPlayed() {
        Game game = new Game();
        game.mark(0, 0, "O");
        Game.MarkResult actual = game.mark(0, 0, "X");
        assertEquals(Game.MarkResult.AlreadyMarked,actual);

    }

    @Test
    public void testIsOverReturnsFalseIfTheGameIsRunning(){
        Game game = new Game();
        assertFalse(game.isOver());
    }

    @Test
    public void testisOverGivesTrueIfTheBoardIsFilledCompletely() {
        Game game = new Game();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                game.mark(i, j, "O");
            }
        }
        assertTrue(game.isOver());
    }

    @Test
    public void testisWinGivesTrueIfTheBoardHasAll_O_OnFirstRow() {
        Game game = new Game();
        game.mark(0, 0, "O");
        game.mark(1, 0, "X");
        game.mark(0, 1, "O");
        game.mark(2, 0, "X");
        game.mark(0, 2, "O");
        assertTrue(game.isWonBy("O"));
    }

    @Test
    public void testisWinGivesTrueIfTheBoardHasAll_O_OnSecondRow() {
        Game game = new Game();
        game.mark(1, 0, "O");
        game.mark(0, 0, "X");
        game.mark(1, 1, "O");
        game.mark(2, 2, "X");
        game.mark(1, 2, "O");
        assertTrue(game.isWonBy("O"));
    }

    @Test
    public void testisWinGivesFalseIfTheBoardDoesNotHaveAll_X_OnFirstRow() {
        Game game = new Game();
        game.mark(0, 0, "O");
        game.mark(1, 2, "X");
        game.mark(0, 1, "O");
        game.mark(0, 2, "X");
        game.mark(2, 2, "O");
        assertFalse(game.isWonBy("X"));
    }

    @Test
    public void testisWinGivesTrueIfTheBoardHasAll_O_OnFirstColumn() {
        Game game = new Game();
        game.mark(0, 0, "O");
        game.mark(0, 1, "X");
        game.mark(1, 0, "O");
        game.mark(2, 2, "X");
        game.mark(2, 0, "O");
        assertTrue(game.isWonBy("O"));
    }

    @Test
    public void testisWinGivesTrueIfTheBoardHasAll_O_OnLeftDiagonal() {
        Game game = new Game();
        game.mark(0, 0, "O");
        game.mark(0, 1, "X");
        game.mark(1, 1, "O");
        game.mark(2, 0, "X");
        game.mark(2, 2, "O");
        assertTrue(game.isWonBy("O"));
    }

    @Test
    public void testisWinGivesTrueIfTheBoardHasAll_O_OnRightDiagonal() {
        Game game = new Game();
        game.mark(0, 2, "O");
        game.mark(0, 1, "X");
        game.mark(1, 1, "O");
        game.mark(2, 2, "X");
        game.mark(2, 0, "O");
        assertTrue(game.isWonBy("O"));
    }
}
