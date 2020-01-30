package com.example.gridworld;

/**
 * Represents the state of the GridWorld machine i.e. its position and direction.
 *
 * REMARKS
 * Since the GridWorld is infinite, the default (and arbitrary) choice
 * of (0,0) is taken to be the starting position of the Machine.
 */
class MachineState {

    private Position position;
    private Vector direction;

    /**
     * Creates an instance of this class with position of (0,0)
     * and direction facing east (right).
     */
    public MachineState() {
        this.position = Position.getDefault(); // (0,0)
        this.direction = Direction.getDefault(); // Facing east.
    }

    /**
     * Creates an instance of this class with the given values for
     * position and direction.
     */
    public MachineState(Position position, Vector direction) {

        Direction.validateAsDirection(direction);
        this.position = position;
        this.direction = direction;
    }

    /**
     * Returns the position of the machine.
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Returns the direction of the machine.
     */
    public Vector getDirection() {
        return direction;
    }

    /**
     * Rotates the machine 90 degrees clockwise (right) and moves forward one step.
     */
    public void clockwiseMove() {

        this.direction = this.direction.rotateClockwiseBy90();

        stepInDirection();
    }

    /**
     * Rotates the machine 90 degrees counter-clockwise (left) and moves forward one step.
     */
    public void counterClockwiseMove() {

        this.direction = this.direction.rotateCounterClockwiseBy90();

        stepInDirection();
    }

    private void stepInDirection() {
        position = new Position(
            position.getX() + direction.getX(),
            position.getY() + direction.getY());
    }
 }