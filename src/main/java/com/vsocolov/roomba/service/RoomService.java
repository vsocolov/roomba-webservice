package com.vsocolov.roomba.service;

import com.vsocolov.roomba.data.Point;
import com.vsocolov.roomba.data.Room;
import com.vsocolov.roomba.data.RoomSize;

import java.util.List;

public interface RoomService {
    Room buildRoom(RoomSize roomSize, List<Point> patches);

    boolean isRoomMessyAtPoint(Room room, Point point);

    void cleanRoomAtPoint(Room room, Point point);

    boolean isPointOutOfRoomBound(Room room, Point point);
}
