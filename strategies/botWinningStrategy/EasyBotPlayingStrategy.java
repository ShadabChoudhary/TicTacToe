package com.example.lldbasics.machineCoding.tictactoe.strategies.botWinningStrategy;

import com.example.lldbasics.machineCoding.tictactoe.models.Board;
import com.example.lldbasics.machineCoding.tictactoe.models.Cell;
import com.example.lldbasics.machineCoding.tictactoe.models.CellState;
import com.example.lldbasics.machineCoding.tictactoe.models.Move;

import java.util.List;

public class EasyBotPlayingStrategy implements BotPlayingStrategy{
    @Override
    public Move makeMove(Board board) {
        for(List<Cell> row : board.getBoard()){
            for(Cell cell : row){
                if(cell.getCellState().equals(CellState.EMPTY)){
                    return new Move(null, cell);
                }
            }
        }
        return null;
    }
}
