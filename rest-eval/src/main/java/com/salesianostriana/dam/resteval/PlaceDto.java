package com.salesianostriana.dam.resteval;

import java.util.List;

public record PlaceDto(
        Long id,
        String nombre,
        String coords,
        String images
) {

    public static PlaceDto placeDto(Place place){
       return new PlaceDto(
               place.getId(),
               place.getName(),
               place.getCoords(),
               place.getImage()
       );
    }

    public static Object of(Place place) {
        return place;
    }
}
