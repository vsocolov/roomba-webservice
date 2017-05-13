package com.vsocolov.roomba.data.response;

import java.io.Serializable;

public class CleaningResponse implements Serializable {

    private Integer[] coords;

    private Integer patches;

    public Integer[] getCoords() {
        return coords;
    }

    public void setCoords(final Integer[] coords) {
        this.coords = coords;
    }

    public Integer getPatches() {
        return patches;
    }

    public void setPatches(final Integer patches) {
        this.patches = patches;
    }
}
