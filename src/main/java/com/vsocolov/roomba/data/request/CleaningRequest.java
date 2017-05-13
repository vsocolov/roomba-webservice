package com.vsocolov.roomba.data.request;

import java.io.Serializable;

public class CleaningRequest implements Serializable {
    private Integer[] roomSize;

    private Integer[] coords;

    private Integer[][] patches;

    private String instructions;

    public Integer[] getRoomSize() {
        return roomSize;
    }

    public void setRoomSize(final Integer[] roomSize) {
        this.roomSize = roomSize;
    }

    public Integer[] getCoords() {
        return coords;
    }

    public void setCoords(final Integer[] coords) {
        this.coords = coords;
    }

    public Integer[][] getPatches() {
        return patches;
    }

    public void setPatches(final Integer[][] patches) {
        this.patches = patches;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(final String instructions) {
        this.instructions = instructions;
    }
}
