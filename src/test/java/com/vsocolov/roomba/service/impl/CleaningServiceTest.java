package com.vsocolov.roomba.service.impl;

import com.vsocolov.roomba.data.*;
import com.vsocolov.roomba.service.CleaningService;
import com.vsocolov.roomba.service.RoomService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CleaningServiceTest {

    @InjectMocks
    private CleaningService service = new CleaningServiceImpl();

    @Mock
    private RoomService roomService;

    @Test
    public void clean_should_return_coords_2_2() {
        final CleaningData cleaningData = dummyCleaningData();
        final Room room = dummyRoom(cleaningData.getRoomSize());

        when(roomService.buildRoom(cleaningData.getRoomSize(), cleaningData.getPatches())).thenReturn(room);

        final CleaningDataResult result = service.clean(cleaningData);

        assertThat(result.getCoords().getX(), equalTo(2));
        assertThat(result.getCoords().getX(), equalTo(2));
        verify(roomService, times(5)).isRoomMessyAtPoint(any(Room.class), any(Point.class));
        verify(roomService, times(5)).isPointOutOfRoomBound(any(Room.class), any(Point.class));
    }

    private Room dummyRoom(final RoomSize roomSize) {
        int[][] grid = new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};

        return new Room(roomSize, grid);
    }

    private CleaningData dummyCleaningData() {
        final CleaningData data = new CleaningData();
        data.setRoomSize(new RoomSize(3, 3));
        data.setCoords(new Point(0, 0));
        data.setPatches(Arrays.asList(new Point(0, 2), new Point(1, 1), new Point(2, 0)));
        data.setInstructions("NNNEE");

        return data;
    }
}
