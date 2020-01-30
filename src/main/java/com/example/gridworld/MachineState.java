package com.example.gridworld;

/**
 * The MachineState class provides the state of the GridWorld Machine
 * which means its position and direction.
 */
class MachineState {

    private CellRef position;
    private Vector direction;

    /**
     * Creates an instance of this class with position of (0,0)
     * and direction facing east (right).
     */
    public MachineState() {
        this.position = new CellRef(); // (0,0)
        this.direction = Direction.getDefault(); // Facing east.
    }

    /**
     * Creates an instance of this class with the given values for
     * position and direction.
     */
    public MachineState(CellRef position, Vector direction) {

        Direction.validateAsDirection(direction);
        this.position = position;
        this.direction = direction;
    }

    /**
     * Returns the position of the machine.
     */
    public CellRef getPosition() {
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

        this.direction = Direction.rotateClockwise(this.direction);

        stepInDirection();
    }

    /**
     * Rotates the machine 90 degrees counter-clockwise (left) and moves forward one step.
     */
    public void counterClockwiseMove() {

        this.direction = Direction.rotateCounterClockwise(this.direction);

        stepInDirection();
    }

    private void stepInDirection() {
        position = new CellRef(
            position.getX() + direction.getX(),
            position.getY() + direction.getY());
    }
 }