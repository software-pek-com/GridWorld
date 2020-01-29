package com.example.gridworld;

public enum CellStatus {

    White(" "), Black("X"), MachineOnWhite("M"), MachineOnBlack("m");

    String status;
    
    private CellStatus(String status) 
    { 
        this.status = status; 
    }
}