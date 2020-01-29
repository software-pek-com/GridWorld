package com.example.gridworld;

public abstract class AbstractGrid {

    public abstract CellStatus getCellStatus(int x, int y);
    public abstract Cell getMachinePosition();
}