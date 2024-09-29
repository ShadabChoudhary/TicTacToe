package com.example.lldbasics.machineCoding.tictactoe.strategies.botWinningStrategy;

import com.example.lldbasics.machineCoding.tictactoe.models.Board;
import com.example.lldbasics.machineCoding.tictactoe.models.Move;

public interface BotPlayingStrategy {
    Move makeMove(Board board);
}
