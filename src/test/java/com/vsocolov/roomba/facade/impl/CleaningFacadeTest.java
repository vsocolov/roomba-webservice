package com.vsocolov.roomba.facade.impl;

import com.vsocolov.roomba.converter.CleaningDataConverter;
import com.vsocolov.roomba.converter.CleaningResponseConverter;
import com.vsocolov.roomba.data.CleaningData;
import com.vsocolov.roomba.data.CleaningDataResult;
import com.vsocolov.roomba.data.Point;
import com.vsocolov.roomba.data.request.CleaningRequest;
import com.vsocolov.roomba.data.response.CleaningResponse;
import com.vsocolov.roomba.facade.CleaningFacade;
import com.vsocolov.roomba.service.CleaningService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CleaningFacadeTest {

    @InjectMocks
    private CleaningFacade facade = new CleaningFacadeImpl();

    @Mock
    private CleaningService cleaningService;

    @Mock
    private CleaningDataConverter cleaningDataConverter;

    @Mock
    private CleaningResponseConverter cleaningResponseConverter;

    @Test
    public void cleanRoom_should_call_services_and_converters() {
        final CleaningRequest request = new CleaningRequest();
        final CleaningData cleaningData = new CleaningData();
        when(cleaningDataConverter.convert(request)).thenReturn(cleaningData);

        final CleaningDataResult cleaningDataResult = new CleaningDataResult(new Point(1, 1), 1);
        when(cleaningService.clean(cleaningData)).thenReturn(cleaningDataResult);

        final CleaningResponse cleaningResponse = new CleaningResponse();
        when(cleaningResponseConverter.convert(cleaningDataResult)).thenReturn(cleaningResponse);
        final InOrder callsOrder = inOrder(cleaningService, cleaningDataConverter, cleaningResponseConverter);

        final CleaningResponse response = facade.cleanRoom(request);
        assertThat(response, sameInstance(cleaningResponse));
        callsOrder.verify(cleaningDataConverter).convert(request);
        callsOrder.verify(cleaningService).clean(any(CleaningData.class));
    }
}
