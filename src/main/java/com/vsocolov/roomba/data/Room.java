package com.vsocolov.roomba.data;

import java.io.Serializable;

public class Room implements Serializable {

    private final RoomSize roomSize;

    private final int[][] grid;

    public Room(final RoomSize roomSize, final int[][] grid) {
        this.roomSize = roomSize;
        this.grid = grid;
    }

    public RoomSize getRoomSize() {
        return roomSize;
    }

    public int[][] getGrid() {
        return grid;
    }

}
