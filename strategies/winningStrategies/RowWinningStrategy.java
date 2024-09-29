package com.example.lldbasics.machineCoding.tictactoe.strategies.winningStrategies;

import com.example.lldbasics.machineCoding.tictactoe.models.Board;
import com.example.lldbasics.machineCoding.tictactoe.models.Move;

public class RowWinningStrategy implements WinningStrategy {
    @Override
    public boolean checkWinner(Board board, Move move) {
        return false;
    }
}
