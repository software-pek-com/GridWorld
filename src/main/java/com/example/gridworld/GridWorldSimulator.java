package com.example.gridworld;

import java.util.HashSet;

/**
 * Represents the GridWorld simulator which holds the state of the GridWorld and
 * moves the machine according to the rules.
 * 
 * REMARKS
 * The GridWorld is infinite.
 * The default (and arbitrary) choice of the starting position of the Machine is taken to be (0,0).
 * The default choice of the starting direction is right/east.
 * All cells are initially white i.e. blacklist is empty.
 */
class GridWorldSimulator {
    private int moveCount = 0;
    private HashSet<Position> blacklist;
    private MachineState machine = new MachineState(); // Default position and direction.

    /**
     * For unit test use only.
     * Creates an instance of this class initialized with the given blacklist.
     */
    protected GridWorldSimulator(HashSet<Position> blacklist) {
        this.blacklist = blacklist;
    }

    /**
     * Creates an instance of this class initialized with defaults.
     */
    public GridWorldSimulator() {
        this.blacklist = new HashSet<Position>();
    }

    /**
     * Returns true if cell is black and false otherwise.
     */
    public boolean isCellBlack(Position cell) {
        return blacklist.contains(cell);
    }

    /**
     * Flips the given cell's colour black to white or white to black.
     */
    public void flipCellColour(Position cell) {
        if (isCellBlack(cell)) {
            blacklist.remove(cell); // Black to white.
        }
        else {
            blacklist.add(cell); // White to black.
        }
    }

    /**
     * Performs one move of the machine as per the rules:
     * + If the machine is in a white square, turn 90° clockwise and move forward 1 unit.
     * + If the machine is in a black square, turn 90° counter-clockwise and move forward 1 unit.
     * + At every move flip the colour of the base square.
     */
    public void moveMachineOnce() {
        Position basePosition = machine.getPosition();

        if (isCellBlack(basePosition)) {
            machine.counterClockwiseMove();
        }
        else {
            machine.clockwiseMove();
        }

        flipCellColour(basePosition);

        ++moveCount;
    }

    /**
     * Returns the machine's state.
     */
    public MachineState getMachine() {
        return machine;
    }

    /**
     * Returns a snapshot of the GridWorld (simulator) state.
     */
    public GridWorldData getSnapshot() {
        return new GridWorldData(
            moveCount,
            blacklist,
            machine.getPosition(),
            machine.getDirection());
    }

    /**
     * For unit test use only.
     * Returns the set of black cells.
     */
    protected HashSet<Position> getBlacklist() {
        return blacklist;
    }
}