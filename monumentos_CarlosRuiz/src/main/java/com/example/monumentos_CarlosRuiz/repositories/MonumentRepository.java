package com.example.monumentos_CarlosRuiz.repositories;

import com.example.monumentos_CarlosRuiz.models.Monument;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class MonumentRepository {

    private HashMap<Long, Monument> monuments = new HashMap<>();

    @PostConstruct
    public void init() {
        add(Monument.builder()
                .id(1L)
                .codCountry("ES")
                .country("Spain")
                .city("Barcelona")
                .latitude(41.4036)
                .length(2.1744)
                .description("A famous basilica designed by Antoni Gaudí.")
                .monumentName("Sagrada Familia")
                .urlImage("https://estaticos-cdn.prensaiberica.es/clip/c2e2b1f1-0e15-4eef-a322-d3c5baed9a9a_source-aspect-ratio_default_0.jpg")
                .build());

        add(Monument.builder()
                .id(2L)
                .codCountry("FR")
                .country("France")
                .city("Paris")
                .latitude(48.8584)
                .length(2.2945)
                .description("An iconic symbol of Paris and a global cultural icon.")
                .monumentName("Eiffel Tower")
                .urlImage("https://estaticos-cdn.prensaiberica.es/clip/c2e2b1f1-0e15-4eef-a322-d3c5baed9a9a_source-aspect-ratio_default_0.jpg")
                .build());

        add(Monument.builder()
                .id(3L)
                .codCountry("IT")
                .country("Italy")
                .city("Rome")
                .latitude(41.8902)
                .length(12.4922)
                .description("An ancient amphitheatre and one of Rome's most famous landmarks.")
                .monumentName("Colosseum")
                .urlImage("https://estaticos-cdn.prensaiberica.es/clip/c2e2b1f1-0e15-4eef-a322-d3c5baed9a9a_source-aspect-ratio_default_0.jpg")
                .build());

        add(Monument.builder()
                .id(4L)
                .codCountry("US")
                .country("USA")
                .city("New York")
                .latitude(40.6892)
                .length(-74.0445)
                .description("A symbol of freedom and democracy in the United States.")
                .monumentName("Statue of Liberty")
                .urlImage("https://estaticos-cdn.prensaiberica.es/clip/c2e2b1f1-0e15-4eef-a322-d3c5baed9a9a_source-aspect-ratio_default_0.jpg")
                .build());

        add(Monument.builder()
                .id(5L)
                .codCountry("EG")
                .country("Egypt")
                .city("Giza")
                .latitude(29.9792)
                .length(31.1342)
                .description("An ancient pyramid and one of the Seven Wonders of the Ancient World.")
                .monumentName("Great Pyramid of Giza")
                .urlImage("https://estaticos-cdn.prensaiberica.es/clip/c2e2b1f1-0e15-4eef-a322-d3c5baed9a9a_source-aspect-ratio_default_0.jpg")
                .build());

        add(Monument.builder()
                .id(6L)
                .codCountry("ES")
                .country("Spain")
                .city("Úbeda")
                .latitude(38.0133)
                .length(-3.3705)
                .description("A remarkable Renaissance chapel and a UNESCO World Heritage Site.")
                .monumentName("Sacra Capilla del Salvador")
                .urlImage("https://estaticos-cdn.prensaiberica.es/clip/c2e2b1f1-0e15-4eef-a322-d3c5baed9a9a_source-aspect-ratio_default_0.jpg")
                .build());
    }


    public Monument add(Monument monument){
        monuments.put(monument.getId(), monument);
        return monument;
    }

    public Optional<Monument> get(Long id) {
        return Optional.ofNullable(monuments.get(id));
    }

    public List<Monument> getAll() {
        return List.copyOf(monuments.values());
    }

    public Optional<Monument> edit(Long id, Monument newValue) {
        return Optional.ofNullable(monuments.computeIfPresent(id, (k, v) -> {
            v.setCity(newValue.getCity());
            v.setCountry(newValue.getCountry());
            return v;
        }));
    }

    public void delete(Long id){
        monuments.remove(id);
    }

    public List<Monument> query(double maxLatitude, String sortDirection) {
        List<Monument> data = new ArrayList<>(monuments.values());
        List<Monument> result;


        if (maxLatitude < 0) {
            result = data;
        } else {
            result = data.stream().filter(m -> m.getLatitude() <= maxLatitude)
                    .collect(Collectors.toCollection(ArrayList::new));
        }


        if (sortDirection.equalsIgnoreCase("asc")) {
            result.sort(Comparator.comparing(Monument::getMonumentName));
        } else if (sortDirection.equalsIgnoreCase("desc")) {
            result.sort(Comparator.comparing(Monument::getMonumentName).reversed());
        }
        return Collections.unmodifiableList(result);


    }


}
