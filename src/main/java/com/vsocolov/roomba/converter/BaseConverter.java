package com.vsocolov.roomba.converter;

import java.util.List;

import static java.util.stream.Collectors.toList;

public interface BaseConverter<A, B> {

    B convert(A a);

    default List<B> convertAll(final List<A> input) {
        return input.stream().map(this::convert).collect(toList());
    }
}