package com.vsocolov.roomba.service.impl;

import com.vsocolov.roomba.data.*;
import com.vsocolov.roomba.data.enums.Direction;
import com.vsocolov.roomba.service.CleaningService;
import com.vsocolov.roomba.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import static com.vsocolov.roomba.data.enums.Direction.North;

@Service
public class CleaningServiceImpl implements CleaningService {

    @Autowired
    private RoomService roomService;

    @Override
    public CleaningDataResult clean(final CleaningData cleaningData) {
        final Room room = roomService.buildRoom(cleaningData.getRoomSize(), cleaningData.getPatches());
        final String[] instructionsArray = cleaningData.getInstructions().split("");
        final Queue<String> instructions = new LinkedList<>(Arrays.asList(instructionsArray));

        return exploreAndCleanRoom(room, cleaningData.getCoords(), instructions, 0);
    }

    private CleaningDataResult exploreAndCleanRoom(final Room room, Point point,
                                                   final Queue<String> instructions, int counter) {
        if (instructions.isEmpty())
            return new CleaningDataResult(point, counter);

        if (roomService.isRoomMessyAtPoint(room, point)) {
            roomService.cleanRoomAtPoint(room, point);
            counter++;
        }

        do {
            final Optional<Direction> direction = Direction.from(instructions.poll());

            switch (direction.orElse(North)) {
                case North:
                    point = new Point(point.getX(), point.getY() + 1);
                    break;
                case South:
                    point = new Point(point.getX(), point.getY() - 1);
                    break;
                case West:
                    point = new Point(point.getX() - 1, point.getY());
                    break;
                default:
                    point = new Point(point.getX() + 1, point.getY());
            }
        } while (roomService.isPointOutOfRoomBound(room, point) && !instructions.isEmpty());

        return exploreAndCleanRoom(room, point, instructions, counter);
    }
}
