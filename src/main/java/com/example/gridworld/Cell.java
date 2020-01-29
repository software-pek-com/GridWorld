package com.example.gridworld;

class Cell {
    int x;
    int y;

    public boolean equals(Object o) {
        Cell c = (Cell) o;
        return c.x == x && c.y == y;
    }

    public Cell() {
        super();
        this.x = 0;
        this.y = 0;
    }

    public Cell(int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }

    public int hashCode() {
        return new Integer(x + "0" + y);
    }
}