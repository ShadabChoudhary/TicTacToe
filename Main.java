package com.example.lldbasics.machineCoding.tictactoe;

import com.example.lldbasics.machineCoding.tictactoe.controller.GameController;
import com.example.lldbasics.machineCoding.tictactoe.exception.InvalidBotCountException;
import com.example.lldbasics.machineCoding.tictactoe.exception.SymbolAlreadyUsedException;
import com.example.lldbasics.machineCoding.tictactoe.models.*;
import com.example.lldbasics.machineCoding.tictactoe.winningStrategies.ColumnWinningStrategy;
import com.example.lldbasics.machineCoding.tictactoe.winningStrategies.DiagonalWinningStrategy;
import com.example.lldbasics.machineCoding.tictactoe.winningStrategies.RowWinningStrategy;
import com.example.lldbasics.machineCoding.tictactoe.winningStrategies.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InvalidBotCountException, SymbolAlreadyUsedException {
        int dimension = 3;

        List<Player> players = new ArrayList<>();
        players.add(new Player(1, "Shadab1", new Symbol('X'), PlayerType.HUMAN));
        players.add(new Player(1, "Shadab2", new Symbol('O'), PlayerType.HUMAN));

        List<WinningStrategy> winningStrategies = new ArrayList<>();
        winningStrategies.add(new RowWinningStrategy());
        winningStrategies.add(new ColumnWinningStrategy());
        winningStrategies.add(new DiagonalWinningStrategy());

        //create the game
        GameController gameController = new GameController();

        Game game = gameController.startGame(dimension, players, winningStrategies);

        while(game.getGameState().equals(GameState.IN_PROGRESS)){
            gameController.makeMove();
            gameController.printGame();
        }
    }
}
