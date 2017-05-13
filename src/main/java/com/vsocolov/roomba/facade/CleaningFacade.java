package com.vsocolov.roomba.facade;

import com.vsocolov.roomba.data.request.CleaningRequest;
import com.vsocolov.roomba.data.response.CleaningResponse;

public interface CleaningFacade {

    CleaningResponse cleanRoom(final CleaningRequest request);
}
