package com.vsocolov.roomba.service.impl;

import com.vsocolov.roomba.data.Point;
import com.vsocolov.roomba.data.Room;
import com.vsocolov.roomba.data.RoomSize;
import com.vsocolov.roomba.service.RoomService;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class RoomServiceTest {

    private RoomService roomService = new RoomServiceImpl();

    @Test
    public void buildRoom_should_populate_room_grid_and_size() {
        int size = 3;
        final RoomSize roomSize = new RoomSize(size, size);
        final List<Point> patches = Arrays.asList(new Point(0, 2), new Point(1, 1), new Point(2, 0));

        final Room room = roomService.buildRoom(roomSize, patches);

        assertThat(room.getRoomSize().getHeight(), equalTo(size));
        assertThat(room.getRoomSize().getHeight(), equalTo(size));
        assertThat(room.getGrid(), equalTo(new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}}));
    }

    @Test
    public void isRoomMessyAtPoint_should_return_true_if_point_value_equal_to_1() {
        final Point point = new Point(0, 2);

        boolean isMessy = roomService.isRoomMessyAtPoint(dummyRoom(), point);
        assertThat(isMessy, equalTo(true));
    }

    @Test
    public void isRoomMessyAtPoint_should_return_false_if_point_value_equal_to_0() {
        final Point point = new Point(0, 0);

        boolean isMessy = roomService.isRoomMessyAtPoint(dummyRoom(), point);
        assertThat(isMessy, equalTo(false));
    }

    @Test
    public void cleanRoomAtPoint_should_insert_0_in_point_coordinates() {
        final Point point = new Point(0, 2);
        final Room room = dummyRoom();

        roomService.cleanRoomAtPoint(room, point);

        assertThat(room.getGrid()[0][0], equalTo(0));
    }

    @Test
    public void isPointOutOfRoomBound_should_return_false_if_point_is_in_room_bound() {
        final Point point = new Point(0, 2);

        boolean isOutbound = roomService.isPointOutOfRoomBound(dummyRoom(), point);

        assertThat(isOutbound, equalTo(false));
    }

    @Test
    public void isPointOutOfRoomBound_should_return_true_if_point_is_outbound() {
        final Point point = new Point(10, 10);

        boolean isOutbound = roomService.isPointOutOfRoomBound(dummyRoom(), point);

        assertThat(isOutbound, equalTo(true));
    }

    private Room dummyRoom() {
        final RoomSize roomSize = new RoomSize(3, 3);
        int[][] grid = new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};

        return new Room(roomSize, grid);
    }
}
