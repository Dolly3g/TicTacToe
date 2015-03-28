package com.TicTacToe;

import java.util.Scanner;

public class PositionScanner{
    Scanner scanner = new Scanner(System.in);
    public Position readNext(){
        return new Position(scanner.nextInt()-1,scanner.nextInt()-1);
    }
}
