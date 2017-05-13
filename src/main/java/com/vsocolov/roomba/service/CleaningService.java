package com.vsocolov.roomba.service;

import com.vsocolov.roomba.data.CleaningData;
import com.vsocolov.roomba.data.CleaningDataResult;

public interface CleaningService {

    CleaningDataResult clean(CleaningData cleaningData);
}
