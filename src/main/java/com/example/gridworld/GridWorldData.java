package com.example.gridworld;

import java.util.HashSet;

/**
 * The GridWorldData class holds a snapshot of the state of the GridWorldSimulator.
 */
class GridWorldData {

    /**
     * Creates an instance of this class initialized with defaults.
     */
    public GridWorldData() {}

    /**
     * Creates an instance of this class initialized with give parameters.
     */
    public GridWorldData(HashSet<Position> blacklist, Position machinePosition, Vector  machineDirection) {
        this.blacklist = blacklist;
        this.machinePosition = machinePosition;
        this.machineDirection = machineDirection;
    }
    
    public HashSet<Position> blacklist;
    public Position machinePosition;
    public Vector machineDirection;
}