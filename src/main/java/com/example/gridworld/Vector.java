package com.example.gridworld;

import java.util.Objects;

/**
 * Represents vectors in the GridWorld frame of reference.
 * 
 * REMARKS
 * This class could ensure only valid directions can be created.
 */
class Vector {
    private int x;
    private int y;

    /**
     * Creates an instance of this class initialized from given parameters.
     */
    public Vector(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns the vector's x-coordinate.
     */
    public int getX() {
        return x;
    }

    /**
     * Returns the vector's y-coordinate.
     */
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
        return String.format("[%d,%d]", x, y);
    }

    /**
     * Returns a vector resulting from rotation of
     * this vector clockwise (left) by 90 degrees.
     * This vector is unchanged.
     */
    public Vector rotateClockwiseBy90() {
        int directionIndex = Direction.getDirectionIndex(this);

        // If the new index points beyond our range then wrap it to the start.
        int newDirectionIndex = directionIndex + 1; // +1 for counter-clockwise.
        if (newDirectionIndex == 4) {
            newDirectionIndex = 0;
        }

        return Direction.NESW.get(newDirectionIndex);
    }

    /**
     * Returns a vector resulting from rotation of
     * this vector counter-clockwise (left) by 90 degrees.
     * This vector is unchanged.
     */
    public Vector rotateCounterClockwiseBy90() {
        int directionIndex = Direction.getDirectionIndex(this);

        // If the new index points before our range then wrap it to the end.
        int rotatedDirectionIndex = directionIndex - 1; // -1 for counter-clockwise.
        if (rotatedDirectionIndex == -1) {
            rotatedDirectionIndex = 3;
        }

        return Direction.NESW.get(rotatedDirectionIndex);
    }
}