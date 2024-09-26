package com.example.lldbasics.machineCoding.tictactoe.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;

@Getter
@Setter
public class Player {
    private int id;
    private String name;
    private Symbol symbol;
    private PlayerType playerType;
    Scanner sc = new Scanner(System.in);

    public Player(int id, String name, Symbol symbol, PlayerType playerType) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.playerType = playerType;
    }

    public Move makeMove(Board board){
        System.out.println("Please enter the row number: ");
        int row = sc.nextInt();

        System.out.println("Please enter the column number: ");
        int col = sc.nextInt();

        return new Move(this, new Cell(row, col));
    }
}
