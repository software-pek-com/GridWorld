package com.example.gridworld;

import java.util.HashSet;

/**
 * The GridWorldState class holds the state of the GridWorld which means
 * the MachineState (position and direction) and a list of black cells.
 * 
 * REMARKS
 * The GridWorld is infinite.
 * The default (and arbitrary) choice of the starting position of the Machine is taken to be (0,0).
 * All cells are initially white.
 */
class GridWorldState {
    private HashSet<Position> blacklist;
    private MachineState machine;

    public GridWorldState() {
        this.blacklist = new HashSet<Position>();
        this.machine = new MachineState();
    }

    public GridWorldState(Position position, Vector direction) {
        this.blacklist = new HashSet<Position>();
        this.machine = new MachineState(position, direction);
    }

    /**
     * Returns true if cell is black and false otherwise.
     */
    public boolean isCellBlack(Position cell) {
        return blacklist.contains(cell);
    }

    /**
     * Returns the given cell's colour.
     */
    public CellColour getCellColour(Position cell) {
        if (isCellBlack(cell)) {
            return CellColour.Black;
        }
        else {
            return CellColour.White;
        }
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
     * Performs one move as per the rules:
     * + If the machine is in a white square, turn 90° clockwise and move forward 1 unit.
     * + If the machine is in a black square, turn 90° counter-clockwise and move forward 1 unit.
     * + At every move flip the colour of the base square.
     */
    public void moveOnce() {
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
     * Returns the set of black cells.
     */
    public HashSet<Position> getBlacklist() {
        return blacklist;
    }

    /**
     * Returns the machine's state.
     */
    public MachineState getMachine() {
        return machine;
    }
}