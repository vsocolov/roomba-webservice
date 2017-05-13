package com.vsocolov.roomba.data;

import java.io.Serializable;

public class CleaningDataResult implements Serializable {

    private final Point coords;
    private final int patches;

    public CleaningDataResult(final Point coords, final int patches) {
        this.coords = coords;
        this.patches = patches;
    }

    public Point getCoords() {
        return coords;
    }

    public int getPatches() {
        return patches;
    }
}
