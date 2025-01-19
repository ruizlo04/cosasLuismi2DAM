package com.example.proy_Profesor_Curso.service;

import com.example.proy_Profesor_Curso.models.Profesor;
import com.example.proy_Profesor_Curso.repositories.ProfesorRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfesorService {

    private final ProfesorRepository profesorRepository;

    public List<Profesor> findAll(){
        List<Profesor> listaProfesor = profesorRepository.findAll();
        if (listaProfesor.isEmpty()){
            throw new EntityNotFoundException("No se han encontrado");
        }
        return listaProfesor;
    }

    public Optional<Profesor> findById(Long id){
        Optional<Profesor> optionalProfesor = profesorRepository.findById(id);
        if (optionalProfesor.isEmpty()){
            throw new EntityNotFoundException("No se ha encontrado el id");
        }
        return optionalProfesor;
    }

    public Profesor create(Profesor p){
        return profesorRepository.save(Profesor.builder()
                        .nombre(p.getNombre())
                        .puntuacion(p.getPuntuacion())
                        .email(p.getEmail())
                .build());
    }

    public Optional<Profesor> update(Profesor p, Long id){
        return profesorRepository.findById(id)
                .map(old -> {
                    old.setNombre(p.getNombre());
                    old.setEmail(p.getEmail());
                    old.setPuntuacion(p.getPuntuacion());
                    return profesorRepository.save(old);
                });
    }

    public void delete(Long id){
        profesorRepository.deleteById(id);
    }
}
