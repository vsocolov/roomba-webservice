package com.vsocolov.roomba.converter;

import com.vsocolov.roomba.data.CleaningDataResult;
import com.vsocolov.roomba.data.Point;
import com.vsocolov.roomba.data.response.CleaningResponse;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CleaningResponseConverterTest {

    private CleaningResponseConverter converter = new CleaningResponseConverter();

    @Test
    public void should_convert_from_data_to_response() {
        final CleaningDataResult source = new CleaningDataResult(new Point(1, 2), 4);

        final CleaningResponse destination = converter.convert(source);
        assertThat(destination.getPatches(), equalTo(4));
        assertThat(destination.getCoords()[0], equalTo(1));
        assertThat(destination.getCoords()[1], equalTo(2));
    }
}
