package com.example.lldbasics.machineCoding.tictactoe.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player {
    private int id;
    private String name;
    private Symbol symbol;
    private PlayerType playerType;

    public Player(int id, String name, Symbol symbol, PlayerType playerType) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.playerType = playerType;
    }
}
