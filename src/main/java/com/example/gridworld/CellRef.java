package com.example.gridworld;

import java.util.Objects;

/**
 * The CellRef class provides cell coordinates in the GridWrold frame of
 * reference.
 * 
 * REMARKS
 * Since the GridWorld is infinite, the default (and arbitrary) choice
 * of (0,0) is taken to be the starting position of the Machine.
 */
class CellRef {
    private int x;
    private int y;

    public CellRef() {
        this.x = 0;
        this.y = 0;
    }

    public CellRef(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override public boolean equals(Object o) {
        CellRef c = (CellRef) o;
        return c.x == x && c.y == y;
    }

    @Override public int hashCode() {
        return Objects.hash(x, y);
    }
}