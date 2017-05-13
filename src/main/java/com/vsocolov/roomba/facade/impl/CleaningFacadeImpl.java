package com.vsocolov.roomba.facade.impl;

import com.vsocolov.roomba.converter.CleaningDataConverter;
import com.vsocolov.roomba.converter.CleaningResponseConverter;
import com.vsocolov.roomba.data.CleaningData;
import com.vsocolov.roomba.data.CleaningDataResult;
import com.vsocolov.roomba.data.request.CleaningRequest;
import com.vsocolov.roomba.data.response.CleaningResponse;
import com.vsocolov.roomba.facade.CleaningFacade;
import com.vsocolov.roomba.service.CleaningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CleaningFacadeImpl implements CleaningFacade {

    @Autowired
    private CleaningService cleaningService;

    @Autowired
    private CleaningDataConverter cleaningDataConverter;

    @Autowired
    private CleaningResponseConverter cleaningResponseConverter;

    @Override
    public CleaningResponse cleanRoom(final CleaningRequest request) {
        final CleaningData cleaningData = cleaningDataConverter.convert(request);
        final CleaningDataResult cleaningResult = cleaningService.clean(cleaningData);

        return cleaningResponseConverter.convert(cleaningResult);
    }
}
