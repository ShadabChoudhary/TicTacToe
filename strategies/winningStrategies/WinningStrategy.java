package com.example.lldbasics.machineCoding.tictactoe.strategies.winningStrategies;

import com.example.lldbasics.machineCoding.tictactoe.models.Board;
import com.example.lldbasics.machineCoding.tictactoe.models.Move;

public interface WinningStrategy {
    boolean checkWinner(Board board, Move move);
}
