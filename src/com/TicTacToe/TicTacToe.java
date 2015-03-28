package com.TicTacToe;

public class TicTacToe {
    public static void main(String[] args) {
        GameMaster gameMaster = new GameMaster();
        PositionScanner scanner = new PositionScanner();
        System.out.println(gameMaster.BANNER);
        System.out.println(gameMaster.showBoard());
        while (gameMaster.isGameOn()){
            String message = gameMaster.nextMove(scanner.readNext());
            System.out.println(gameMaster.showBoard());
            System.out.println(message);
        }
    }
}
