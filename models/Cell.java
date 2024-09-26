package com.example.lldbasics.machineCoding.tictactoe.models;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cell {
    private int row;
    private int col;
    private CellState cellState;
    private Player player;

    public Cell(int row, int col){
        this.row = row;
        this.col = col;
        this.cellState = CellState.EMPTY;
    }

    public void display(){
        if(cellState == CellState.EMPTY){
            System.out.print("|  |");
        }else{
            System.out.print("| "+player.getSymbol()+" |");
        }
    }
}
