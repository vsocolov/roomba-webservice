package com.vsocolov.roomba.service.impl;

import com.vsocolov.roomba.data.Point;
import com.vsocolov.roomba.data.Room;
import com.vsocolov.roomba.data.RoomSize;
import com.vsocolov.roomba.service.RoomService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    @Override
    public Room buildRoom(final RoomSize roomSize, final List<Point> patches) {
        final int[][] grid = new int[roomSize.getHeight()][roomSize.getWidth()];

        patches.forEach(point -> {
            final Point gridPoint = fromCartesianToGridPoint(roomSize, point);
            grid[gridPoint.getX()][gridPoint.getY()] = 1;
        });

        return new Room(roomSize, grid);
    }

    @Override
    public boolean isRoomMessyAtPoint(final Room room, final Point point) {
        final Point gridPoint = fromCartesianToGridPoint(room.getRoomSize(), point);

        return room.getGrid()[gridPoint.getX()][gridPoint.getY()] == 1;
    }

    @Override
    public void cleanRoomAtPoint(final Room room, final Point point) {
        final Point gridPoint = fromCartesianToGridPoint(room.getRoomSize(), point);

        room.getGrid()[gridPoint.getX()][gridPoint.getY()] = 0;
    }

    @Override
    public boolean isPointOutOfRoomBound(final Room room, final Point point) {
        final Point gridPoint = fromCartesianToGridPoint(room.getRoomSize(), point);

        return gridPoint.getX() < 0 || gridPoint.getX() > room.getRoomSize().getHeight()
                || gridPoint.getY() < 0 || gridPoint.getY() > room.getRoomSize().getWidth();
    }

    private Point fromCartesianToGridPoint(final RoomSize roomSize, final Point point) {
        int i = (roomSize.getHeight() - 1) - point.getY();
        int j = point.getX();

        return new Point(i, j);
    }
}
