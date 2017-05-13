package com.vsocolov.roomba.data;

import java.io.Serializable;
import java.util.List;

public class CleaningData implements Serializable {
    private RoomSize roomSize;

    private Point coords;

    private List<Point> patches;

    private String instructions;

    public RoomSize getRoomSize() {
        return roomSize;
    }

    public void setRoomSize(final RoomSize roomSize) {
        this.roomSize = roomSize;
    }

    public Point getCoords() {
        return coords;
    }

    public List<Point> getPatches() {
        return patches;
    }

    public void setPatches(final List<Point> patches) {
        this.patches = patches;
    }

    public void setCoords(final Point coords) {
        this.coords = coords;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
}
