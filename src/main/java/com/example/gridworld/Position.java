package com.example.gridworld;

import java.util.Objects;

/**
 * Represents cell coordinates in the GridWrold frame of reference.
 */
class Position {
    private int x;
    private int y;

    private static final Position zero = new Position();

    public static Position getDefault() { return zero; }

    private Position() {
        this.x = 0;
        this.y = 0;
    }

    /**
     * Creates an instance of this class initialized from the given parameters.
     */
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns the x-coordinate.
     */
    public int getX() {
        return x;
    }

    /**
     * Returns the y-coordinate.
     */
    public int getY() {
        return y;
    }

    @Override public boolean equals(Object o) {
        Position c = (Position) o;
        return c.x == x && c.y == y;
    }

    @Override public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override public String toString() {
        return String.format("(%d,%d)", x, y);
    }
}