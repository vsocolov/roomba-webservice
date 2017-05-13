package com.vsocolov.roomba.data;

import java.io.Serializable;

public class Point implements Serializable {
    private final int x;
    private final int y;

    public Point(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    public Point(final Integer[] coords) {
        this.x = coords[0];
        this.y = coords[1];
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
