package com.example.lldbasics.machineCoding.tictactoe.factory;

import com.example.lldbasics.machineCoding.tictactoe.models.BotDifficultyLevel;
import com.example.lldbasics.machineCoding.tictactoe.strategies.botWinningStrategy.BotPlayingStrategy;
import com.example.lldbasics.machineCoding.tictactoe.strategies.botWinningStrategy.EasyBotPlayingStrategy;
import com.example.lldbasics.machineCoding.tictactoe.strategies.botWinningStrategy.HardBotPlayingStrategy;
import com.example.lldbasics.machineCoding.tictactoe.strategies.botWinningStrategy.MediumBotPlayingStrategy;

public class BotPlayingStrategyFactory {
    public static BotPlayingStrategy getBotPlayingStrategy(BotDifficultyLevel botDifficultyLevel){
        if(botDifficultyLevel.equals(BotDifficultyLevel.EASY)){
            return new EasyBotPlayingStrategy();
        }else if(botDifficultyLevel.equals(BotDifficultyLevel.MEDIUM)){
            return new MediumBotPlayingStrategy();
        }else if(botDifficultyLevel.equals(BotDifficultyLevel.HARD)){
            return new HardBotPlayingStrategy();
        }
        return null;
    }
}
