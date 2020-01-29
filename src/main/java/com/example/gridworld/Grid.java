package com.example.gridworld;

import java.util.HashSet;

public class Grid {

    private HashMap<Cell> cells;

    public Grid() {
        this.cells = new HashSet<Cell>();
    }

    public CellStatus getCellStatus(int x, int y) {
        return cells[y][x];
    }
    public Cell getMachinePosition();

}