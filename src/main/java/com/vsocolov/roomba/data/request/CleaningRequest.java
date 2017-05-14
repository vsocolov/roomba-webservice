package com.vsocolov.roomba.data.request;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;
import java.io.Serializable;

public class CleaningRequest implements Serializable {

    @NotEmpty
    @Size(min = 2, max = 2)
    private Integer[] roomSize;

    @NotEmpty
    @Size(min = 2, max = 2)
    private Integer[] coords;

    @NotEmpty
    private Integer[][] patches;

    @NotEmpty
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
