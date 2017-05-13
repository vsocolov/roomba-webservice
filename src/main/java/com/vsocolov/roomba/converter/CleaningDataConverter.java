package com.vsocolov.roomba.converter;

import com.vsocolov.roomba.data.CleaningData;
import com.vsocolov.roomba.data.Point;
import com.vsocolov.roomba.data.RoomSize;
import com.vsocolov.roomba.data.request.CleaningRequest;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class CleaningDataConverter implements BaseConverter<CleaningRequest, CleaningData> {

    @Override
    public CleaningData convert(CleaningRequest source) {
        final CleaningData destination = new CleaningData();
        destination.setCoords(new Point(source.getCoords()));
        destination.setInstructions(source.getInstructions());
        destination.setPatches(extractPatches(source.getPatches()));
        destination.setRoomSize(new RoomSize(source.getRoomSize()));

        return destination;
    }

    private List<Point> extractPatches(final Integer[][] patches) {
        return Arrays.stream(patches).map(Point::new).collect(toList());
    }

}
