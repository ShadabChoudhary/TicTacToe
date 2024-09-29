package com.example.lldbasics.machineCoding.tictactoe.models;

import com.example.lldbasics.machineCoding.tictactoe.exception.InvalidBotCountException;
import com.example.lldbasics.machineCoding.tictactoe.exception.SymbolAlreadyUsedException;
import com.example.lldbasics.machineCoding.tictactoe.strategies.winningStrategies.WinningStrategy;
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

    public void printBoard(){
        board.printBoard();
    }

    public void makeMove(){
        Player currPlayer = players.get(nextPlayerMoveIndex);
        System.out.println(currPlayer.getName()+"'s turn");

        Move move = currPlayer.makeMove(board);

        System.out.println(currPlayer.getName()+"'s is making a move at "+move.getCell().getRow()+" "+move.getCell().getCol());

        //Validate move when player enters the coordinates

        //change the state of a cell when used
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        Cell cellToChange = board.getBoard().get(row).get(col);
        cellToChange.setCellState(CellState.FILLED);
        cellToChange.setPlayer(currPlayer);

        //adding the curr move state in a list for undo feature
        Move finalMoveObject = new Move(currPlayer, cellToChange);
        moves.add(finalMoveObject);

        nextPlayerMoveIndex += 1;
        nextPlayerMoveIndex %= players.size();
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
            Set<Symbol> usedSymbol  = new HashSet<>();
            for(Player player : players){
                Symbol currSymbol = player.getSymbol();
                //check symbol is already used or not
                if(usedSymbol.contains(currSymbol)){
                    throw new SymbolAlreadyUsedException("This symbol is already used");
                }
                usedSymbol.add(currSymbol);
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
