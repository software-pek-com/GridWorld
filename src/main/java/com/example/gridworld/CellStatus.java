package com.example.gridworld;

public enum CellStatus {

    White(" "), Black("X");

    String status;
    
    private CellStatus(String status) 
    { 
        this.status = status; 
    }
}