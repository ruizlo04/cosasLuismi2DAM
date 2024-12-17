package com.salesianostriana.dam.resteval;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class PlaceRepository {

    private Map<Long, Place> places = new HashMap<>();
    private AtomicLong counter = new AtomicLong(0);

    @PostConstruct
    public void init() {
        add(Place.builder()
                .name("Bar Sevilla")
                .address("Calle Feria, Sevilla")
                .coords("37.3886,-5.9823")
                .desc("Un bar con ambiente local")
                .tags(Arrays.asList("Cerveza", "Tapas", "Barato"))
                .image("https://example.com/image1.jpg")
                .build());
    }

    public Place add(Place place) {
        long id = counter.incrementAndGet();
        place.setId(id);
        places.put(id, place);
        return place;
    }

    public Optional<Place> get(Long id) {
        return Optional.ofNullable(places.get(id));
    }

    public List<Place> getAll() {
        return new ArrayList<>(places.values());
    }

    public Optional<Place> edit(Long id, Place updated) {
        return Optional.ofNullable(places.computeIfPresent(id, (k, v) -> {
            v.setName(updated.getName());
            v.setDesc(updated.getDesc());
            v.setCoords(updated.getCoords());
            v.setAddress(updated.getAddress());
            v.setImage(updated.getImage());
            return v;
        }));
    }

    public void delete(Long id) {
        places.remove(id);
    }
}
