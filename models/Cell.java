package com.example.lldbasics.machineCoding.tictactoe.models;

public class Cell {
    private int row;
    private int col;
    CellState cellState;
    private Player player;

    public Cell(int row, int col){
        this.row = row;
        this.col = col;
        this.cellState = CellState.EMPTY;
    }
}
