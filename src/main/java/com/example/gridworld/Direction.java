package com.example.gridworld;

import java.util.Arrays;
import java.util.List;

/**
 * The Direction class defines valid GridWorld directions and helper
 * methods to correctly rotate directions (clockwise and counter-clockwise).
 * 
 * REMARKS
 * The order of vectors in directionsNESW has been chosen to correspond to rotations
 * by 90 degrees with increasing index value. This setup is utilized in the rotation
 * methods below.
 */
class Direction {

    /**
     * List of valid directions in the N,E,S,W order.
     */
    public static List<Vector> NESW = 
        //            0                 1                 2                  3
        Arrays.asList(new Vector(0, 1), new Vector(1, 0), new Vector(0, -1), new Vector(-1, 0));

    /**
     * Returns the default direction (i.e. facing right/east).
     */
    public static Vector getDefault() {
        return NESW.get(1);
    }

    /**
     * Rotates the given vector clockwise (right).
     */
    public static Vector rotateClockwise(Vector v) {
        int directionIndex = getDirectionIndex(v);

        // If the new index points beyond our range then wrap it back to the front.
        int newDirectionIndex = directionIndex + 1;
        if (newDirectionIndex == 4) {
            newDirectionIndex = 0;
        }

        return NESW.get(newDirectionIndex);
    }

    /**
     * Rotates the given vector counter-clockwise (left).
     */
    public static Vector rotateCounterClockwise(Vector v) {
        int directionIndex = getDirectionIndex(v);

        // If the new index points before our range then wrap it back to the end.
        int rotatedDirectionIndex = directionIndex - 1;
        if (rotatedDirectionIndex == -1) {
            rotatedDirectionIndex = 3;
        }

        return NESW.get(rotatedDirectionIndex);
    }

    /**
     * Validates the given vector as a valid direction. If not a valid
     * direction throws IndexOutOfBoundsException. If valid does nothing.
     */
    public static void validateAsDirection(Vector v) {
        int directionIndex = NESW.indexOf(v);
        if (directionIndex == -1) {
            throw new IndexOutOfBoundsException(
                String.format("%s is not a valid direction.", v.toString()));
        }
    }

    private static int getDirectionIndex(Vector v) {
        int directionIndex = NESW.indexOf(v);
        if (directionIndex == -1) {
            throw new IndexOutOfBoundsException(
                String.format("%s is not a valid direction.", v.toString()));
        }

        return directionIndex;
    }
}