package com.example.gridworld;

import java.util.List;
import java.util.ArrayList;

class GridWorldSimulator {

    private int iterationCount;
    private AbstractGrid grid;
    private Cell machinePosition = new Cell();
    private List<Cell> machinePath = new ArrayList<>();

    public GridWorldSimulator(int iterationCount) {
        // Check parameter.

        this.iterationCount = iterationCount;
        // grid = new ConcreteGrid();
    }
}