package com.example.lldbasics.machineCoding.tictactoe.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bot extends Player{
    BotDifficultyLevel botDifficultyLevel;

    public Bot(int id, String name, Symbol symbol, PlayerType playerType, BotDifficultyLevel botDifficultyLevel){
        super(id, name, symbol, playerType);
        this.botDifficultyLevel = botDifficultyLevel;
    }
}
