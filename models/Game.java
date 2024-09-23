package com.example.lldbasics.machineCoding.tictactoe.models;

import com.example.lldbasics.machineCoding.tictactoe.exception.InvalidBotCountException;
import com.example.lldbasics.machineCoding.tictactoe.exception.SymbolAlreadyUsedException;
import com.example.lldbasics.machineCoding.tictactoe.winningStrategies.WinningStrategy;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter

public class Game {
    private Board board;
    private List<Player> players;
    private GameState gameState;
    private List<Move> moves;
    private Player winner;
    private int nextPlayerMoveIndex;
    private List<WinningStrategy> winningStrategies;

    public static Builder getBuilder(){
        return new Builder();
    }

    private Game(int dimension, List<Player> players, List<WinningStrategy> winningStrategies){
        this.board = new Board(dimension);//creating new game
        this.players = players;
        this.gameState = GameState.IN_PROGRESS;
        this.winner = null;
        this.nextPlayerMoveIndex = 0;
        this.moves = new ArrayList<>();
        this.winningStrategies = winningStrategies;
    }

    public static class Builder{
        private int dimension;
        private List<Player> players;
        private List<WinningStrategy> winningStrategies;

        public Builder setDimension(int dimension){
            this.dimension = dimension;
            return this;
        }

        public Builder setPlayers(List<Player> players){
            this.players = players;
            return this;
        }

        public Builder setWinningStrategies(List<WinningStrategy> winningStrategies){
            this.winningStrategies = winningStrategies;
            return this;
        }

        private void validatePlayerCount(){
            if(players.size() != dimension-1){
                throw new IndexOutOfBoundsException("Number of Players is not correct");
            }
        }

        private void checkBotException() throws InvalidBotCountException {
            int botCount = 0;
            for(Player player : players){
                if(player.getPlayerType() == PlayerType.BOT){
                    botCount++;
                }
            }

            if(botCount > 1){
                throw new InvalidBotCountException("Number of Bots is not correct");
            }
        }

        public void diffSymbolForEachPlayer() throws SymbolAlreadyUsedException {
            Set<Symbol> useSymbol  = new HashSet<>();
            for(Player player : players){
                Symbol currSymbol = player.getSymbol();
                //check symbol is already used or not
                if(useSymbol.contains(currSymbol)){
                    throw new SymbolAlreadyUsedException("This symbol is already used");
                }
                useSymbol.add(currSymbol);
            }
        }

        public void validate() throws InvalidBotCountException, SymbolAlreadyUsedException {
            diffSymbolForEachPlayer();
            validatePlayerCount();
            checkBotException();
        }

        public Game build() throws InvalidBotCountException, SymbolAlreadyUsedException {
            //validation
            validate();
            return new Game(dimension, players, winningStrategies);
        }
    }
}
