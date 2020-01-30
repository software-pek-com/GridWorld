package com.example.gridworld;

import java.util.Arrays;
import java.util.List;

/**
 * Represents valid GridWorld directions wrt (0,0) and helper
 * methods to correctly apply rotations (clockwise and counter-clockwise)
 * around the (0,0) position.
 * 
 * REMARKS
 * The order of vectors in NESW (North East South West) has been chosen to correspond to rotations
 * by 90 degrees clockwise with increasing index value. This setup is utilized in the two rotation
 * methods below.
 */
final class Direction {

    /**
     * List of valid directions in the N,E,S,W order.
     */
    public static List<Vector> NESW = 
        //            0 (N)             1 (E)             2 (W)              3 (S)
        Arrays.asList(new Vector(0, 1), new Vector(1, 0), new Vector(0, -1), new Vector(-1, 0));

    /**
     * Returns the default direction (i.e. facing right/east).
     */
    public static Vector getDefault() {
        return NESW.get(1);
    }

    /**
     * Validates the given vector as a valid direction. If not a valid
     * direction throws IndexOutOfBoundsException otherwise does nothing.
     */
    public static void validateAsDirection(Vector v) {
        getDirectionIndex(v);
    }

    /**
     * Returns the index (into NESW) of the given direction. If not a valid
     * direction throws IndexOutOfBoundsException.
     */
    public static int getDirectionIndex(Vector v) {
        int directionIndex = NESW.indexOf(v);
        if (directionIndex == -1) {
            throw new IndexOutOfBoundsException(
                String.format("%s is not a valid direction.", v.toString()));
        }

        return directionIndex;
    }
}