package com.example.gridworld;

import java.util.HashSet;

/**
 * The GridWorldSimulator class holds the state of the GridWorld and
 * makes moves with the machine.
 * 
 * REMARKS
 * The GridWorld is infinite.
 * The default (and arbitrary) choice of the starting position of the Machine is taken to be (0,0).
 * The default choice of the starting direction is right/east.
 * All cells are initially white i.e. blacklist is empty.
 */
class GridWorldSimulator {
    private HashSet<Position> blacklist;
    private MachineState machine;

    /**
     * For unit test use only.
     * Creates an instance of this class initialized with the given blacklist.
     */
    protected GridWorldSimulator(HashSet<Position> blacklist) {
        this.blacklist = blacklist;
        //Default position is (0,0) and direction is right/east.
        this.machine = new MachineState();
    }

    /**
     * Creates an instance of this class initialized with defaults.
     */
    public GridWorldSimulator() {
        this.blacklist = new HashSet<Position>();
        //Default position is (0,0) and direction is right/east.
        this.machine = new MachineState();
    }

    /**
     * Returns true if cell is black and false otherwise.
     */
    public boolean isCellBlack(Position cell) {
        return blacklist.contains(cell);
    }

    /**
     * Toggles the given cell's colour i.e. black -> white, white -> black.
     */
    public void toggleCellColour(Position cell) {
        if (isCellBlack(cell)) {
            blacklist.remove(cell);
        }
        else {
            blacklist.add(cell);
        }
    }

    /**
     * Performs one move of the machine as per the rules:
     * + If the machine is in a white square, turn 90° clockwise and move forward 1 unit.
     * + If the machine is in a black square, turn 90° counter-clockwise and move forward 1 unit.
     * + At every move flip the colour of the base square.
     */
    public void moveMachineOnce() {
        Position positionBeforeMove = machine.getPosition();

        if (isCellBlack(positionBeforeMove)) {
            machine.counterClockwiseMove();
        }
        else {
            machine.clockwiseMove();
        }

        toggleCellColour(positionBeforeMove);
    }

    /**
     * Returns the machine's state.
     */
    public MachineState getMachine() {
        return machine;
    }

    /**
     * For unit test use only.
     * Returns the set of black cells.
     */
    protected HashSet<Position> getBlacklist() {
        return blacklist;
    }

    /**
     * Returns a snapshot of the GridWorldSimulator state.
     */
    public GridWorldData getSnapshot() {
        return new GridWorldData(blacklist, machine.getPosition(), machine.getDirection());
    }
}