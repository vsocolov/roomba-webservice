package com.vsocolov.roomba.converter;

import com.vsocolov.roomba.data.CleaningData;
import com.vsocolov.roomba.data.request.CleaningRequest;
import org.hamcrest.beans.HasPropertyWithValue;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.MatcherAssert.assertThat;

public class CleaningDataConverterTest {

    private CleaningDataConverter converter = new CleaningDataConverter();

    @Test
    public void should_convert_from_request_to_data() {
        final CleaningRequest source = new CleaningRequest();
        source.setCoords(new Integer[]{0, 2});
        source.setRoomSize(new Integer[]{3, 3});
        source.setInstructions("NNWESNNE");
        source.setPatches(new Integer[][]{{1, 0}});

        final CleaningData destination = converter.convert(source);

        assertThat(destination.getRoomSize().getHeight(), equalTo(3));
        assertThat(destination.getRoomSize().getWidth(), equalTo(3));
        assertThat(destination.getCoords().getX(), equalTo(0));
        assertThat(destination.getCoords().getY(), equalTo(2));
        assertThat(destination.getInstructions(), equalTo("NNWESNNE"));
        assertThat(destination.getPatches(), hasItem(HasPropertyWithValue.hasProperty("x", equalTo(1))));
        assertThat(destination.getPatches(), hasItem(HasPropertyWithValue.hasProperty("y", equalTo(0))));
    }
}
