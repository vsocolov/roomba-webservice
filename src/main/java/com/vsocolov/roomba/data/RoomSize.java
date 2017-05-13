package com.vsocolov.roomba.data;

public class RoomSize {
    private final int width;
    private final int height;

    public RoomSize(final int width, final int height) {
        this.width = width;
        this.height = height;
    }

    public RoomSize(final Integer[] arr) {
        this.width = arr[0];
        this.height = arr[1];
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
