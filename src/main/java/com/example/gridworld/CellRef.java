package com.example.gridworld;

class CellRef {
    int x;
    int y;

    public CellRef(int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }

    public boolean equals(Object o) {
        Cell c = (Cell) o;
        return c.x == x && c.y == y;
    }

    public int hashCode() {
        return new Integer(x + "0" + y);
    }
}