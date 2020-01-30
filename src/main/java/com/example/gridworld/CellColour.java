package com.example.gridworld;

/**
 * The CellColour enum defines the set of colours of GridWorld cells i.e. black or white.
 */
public enum CellColour {

    Black("X"), White(" ");

    private String status;
    
    private CellColour(String status) { 
        this.status = status; 
    }

    @Override public String toString() {
        return this.status;
    }
}