package com.example.monumentos_CarlosRuiz.services;

import com.example.monumentos_CarlosRuiz.controllers.MonumentController;
import com.example.monumentos_CarlosRuiz.error.MonumentNotFoundException;
import com.example.monumentos_CarlosRuiz.models.Monument;
import com.example.monumentos_CarlosRuiz.repositories.MonumentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MonumentService {

    @Autowired
    private MonumentRepository monumentRepository;

    public List<Monument> getAll() {
        List<Monument> result = monumentRepository.getAll();
        if (result.isEmpty())
            throw new MonumentNotFoundException();
        return result;
    }

    public List<Monument> query(double maxLatitude, String sortDirection){
        List<Monument> result = monumentRepository.query(maxLatitude, sortDirection);
        if (result.isEmpty())
            throw new MonumentNotFoundException();
        return result;
    }

    public Monument get(Long id) {
        return monumentRepository.get(id)
                .orElseThrow(() -> new MonumentNotFoundException(id));
    }

    public Monument add(Monument monument) {
        return monumentRepository.add(monument);
    }

    public Monument edit(Long id, Monument newValue) {
        return monumentRepository.edit(id, newValue)
                .orElseThrow(() -> new MonumentNotFoundException(id));
    }

    public void delete(Long id) {
        monumentRepository.delete(id);
    }
}
