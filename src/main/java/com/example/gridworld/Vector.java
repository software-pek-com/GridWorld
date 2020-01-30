package com.example.gridworld;

import java.util.Objects;

/**
 * The Vector class provides vectors in the GridWrold frame of reference.
 */
class Vector {
    private int x;
    private int y;

    public Vector(int x, int y) {
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
        Vector v = (Vector) o;
        return v.x == x && v.y == y;
    }

    @Override public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override public String toString() {
        return String.format("(%d,%d)", x, y);
    }
}