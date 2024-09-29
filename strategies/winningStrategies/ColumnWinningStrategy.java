package com.example.lldbasics.machineCoding.tictactoe.strategies.winningStrategies;

import com.example.lldbasics.machineCoding.tictactoe.models.Board;
import com.example.lldbasics.machineCoding.tictactoe.models.Move;
import com.example.lldbasics.machineCoding.tictactoe.models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class ColumnWinningStrategy implements WinningStrategy {
    Map<Integer, Map<Symbol, Integer>> counts = new HashMap<>();
    @Override
    public boolean checkWinner(Board board, Move move) {
        int col = move.getCell().getCol();
        Symbol symbol = move.getPlayer().getSymbol();

        if(!counts.containsKey(col)) {//if col does not present in the map create one.
            counts.put(col, new HashMap<>());
        }

        Map<Symbol, Integer> colMap = counts.get(col);
//        colMap.put(symbol, colMap.getOrDefault(symbol, 0)+1);
        if(!colMap.containsKey(symbol)) {
            colMap.put(symbol, 0);
        }
        colMap.put(symbol, colMap.get(symbol) + 1);

        return colMap.get(symbol) == board.getDimension();
    }
}
