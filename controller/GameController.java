package com.example.lldbasics.machineCoding.tictactoe.controller;

import com.example.lldbasics.machineCoding.tictactoe.exception.InvalidBotCountException;
import com.example.lldbasics.machineCoding.tictactoe.exception.SymbolAlreadyUsedException;
import com.example.lldbasics.machineCoding.tictactoe.models.Game;
import com.example.lldbasics.machineCoding.tictactoe.models.Player;
import com.example.lldbasics.machineCoding.tictactoe.strategies.winningStrategies.WinningStrategy;

import java.util.List;

public class GameController {

    public Game startGame(int dimension, List<Player> players, List<WinningStrategy> winningStrategies)
            throws InvalidBotCountException, SymbolAlreadyUsedException {

        return Game.getBuilder()
            .setDimension(dimension)
            .setPlayers(players)
            .setWinningStrategies(winningStrategies)
            .build();
    }

    public void printGame(){

    }

    public void makeMove(Game game){
        game.makeMove();
    }

    public Player getWinner(){
        return null;
    }
}
