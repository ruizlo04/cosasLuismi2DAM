package com.example.monumentos_CarlosRuiz;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Repository
public class MonumentRepository {

    private HashMap<Long, Monument> monuments = new HashMap<>();

    @PostConstruct
    public void init(){

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
}
