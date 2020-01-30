package com.example.gridworld;

class CellRef {
    private int x;
    private int y;

    public CellRef() {
        super();
        this.x = 0;
        this.y = 0;
    }

    public CellRef(int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean equals(Object o) {
        CellRef c = (CellRef) o;
        return c.x == x && c.y == y;
    }

    public int hashCode() {
        return (x + "," + y).hashCode();
    }
}