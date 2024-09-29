package com.example.lldbasics.machineCoding.tictactoe.models;

import com.example.lldbasics.machineCoding.tictactoe.factory.BotPlayingStrategyFactory;
import com.example.lldbasics.machineCoding.tictactoe.strategies.botWinningStrategy.BotPlayingStrategy;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bot extends Player{
    BotDifficultyLevel botDifficultyLevel;
    BotPlayingStrategy botPlayingStrategy;

    public Bot(int id, String name, Symbol symbol, PlayerType playerType, BotDifficultyLevel botDifficultyLevel) {
        super(id, name, symbol, playerType);
        this.botDifficultyLevel = botDifficultyLevel;
        this.botPlayingStrategy = BotPlayingStrategyFactory.getBotPlayingStrategy(botDifficultyLevel);
    }

    @Override
    public Move makeMove(Board board){
        Move move = botPlayingStrategy.makeMove(board);
        move.setPlayer(this);
        return move;
    }
}
