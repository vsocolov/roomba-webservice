package com.vsocolov.roomba.data.enums;

import java.util.Arrays;
import java.util.Optional;

public enum Direction {
    North("N"),
    South("S"),
    West("W"),
    Est("E");

    private String direction;

    Direction(String direction) {
        this.direction = direction;
    }

    public static Optional<Direction> from(String value) {
        return Arrays.stream(Direction.values()).filter(n -> n.direction.equals(value)).findFirst();
    }
}
