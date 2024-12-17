package com.salesianostriana.dam.resteval;

import java.util.List;

public record ListGetPlaceDto(
        long count,
        List<Object> items
) {

    public static ListGetPlaceDto listGetPlaceDto(List<Place> list) {
        return new ListGetPlaceDto(
                list.size(),
                list.stream()
                        .map(PlaceDto::of)
                        .toList()
        );
    }
}
