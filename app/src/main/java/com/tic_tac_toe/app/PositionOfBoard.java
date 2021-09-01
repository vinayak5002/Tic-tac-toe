package com.tic_tac_toe.app;

public class PositionOfBoard {
    // i position
    private int i;
    // j position
    private int j;

    public PositionOfBoard() {
    }

    public PositionOfBoard(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }
}
