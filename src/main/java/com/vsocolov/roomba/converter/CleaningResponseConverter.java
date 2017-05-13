package com.vsocolov.roomba.converter;

import com.vsocolov.roomba.data.CleaningDataResult;
import com.vsocolov.roomba.data.response.CleaningResponse;
import org.springframework.stereotype.Component;

@Component
public class CleaningResponseConverter implements BaseConverter<CleaningDataResult, CleaningResponse> {

    @Override
    public CleaningResponse convert(final CleaningDataResult source) {
        final CleaningResponse destination = new CleaningResponse();
        destination.setCoords(new Integer[]{source.getCoords().getX(), source.getCoords().getY()});
        destination.setPatches(source.getPatches());

        return destination;
    }
}
