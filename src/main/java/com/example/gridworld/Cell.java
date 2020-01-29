package com.example.gridworld;

class Cell {
    int x;
    int y;
    CellStatus status;

    public Cell() {
        super();
        this.x = 0;
        this.y = 0;
        this.status = CellStatus.White;
    }

    public Cell(int x, int y, CellStatus status) {
        super();
        this.x = x;
        this.y = y;
        this.status = status;
    }

    public CellStatus getStatus() {
        return this.status;
    }

    public void setStatus(CellStatus status) {
        this.status = status;
    }

    public boolean equals(Object o) {
        Cell c = (Cell) o;
        return c.x == x && c.y == y;
    }

    public int hashCode() {
        return new Integer(x + "0" + y);
    }
}