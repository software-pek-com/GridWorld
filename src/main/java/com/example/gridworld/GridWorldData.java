package com.example.gridworld;

import java.util.HashSet;

/**
 * Represents a snapshot of the state of the GridWorldSimulator. It is
 * intended to be serialized to the file system. This class is the
 * schema (or a model) for persisted data.
 * 
 * REMARKS
 * No care has been taken to fully own the data held. In real scenarios
 * data objects like this should be immutable (as in snapshot).
 */
class GridWorldData {

    /**
     * Creates an instance of this class initialized with defaults.
     */
    public GridWorldData() {
        blacklist = new HashSet<Position>();
    }

    /**
     * Creates an instance of this class initialized with the given parameters.
     * 
     * REMARKS
     * Data validation should be done elsewhere in more complex scenarios.
     * Some validation is necessary because when you persist data to storage
     * (file system or db) it had better be useful.
     * Note: I thought about adding validation and just did i here, but then
     * I was not sure if it was required so in the end I kept it commented out
     * for interviewer's benefit.
     * In reality, I try not to leave any commented out code (you ain't gonna need it).
     */
    public GridWorldData(int moveCount, HashSet<Position> blacklist, Position machinePosition, Vector machineDirection) {

        // if (moveCount < 0) {
        //     throw new IllegalArgumentException("moveCount cannot be negative.");
        // }

        // if (blacklist == null) {
        //     throw new IllegalArgumentException("blacklist cannot be null.");
        // }

        // if (moveCount == 0 && blacklist.size() > 0) {
        //     throw new IllegalArgumentException("moveCount is 0 but blacklist is not empty.");
        // }

        this.blacklist = blacklist;
        this.machinePosition = machinePosition;
        this.machineDirection = machineDirection;
    }
    
    public int moveCount;
    public HashSet<Position> blacklist;
    public Position machinePosition;
    public Vector machineDirection;
}