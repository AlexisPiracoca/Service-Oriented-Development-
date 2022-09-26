package com.usta.jwtdemo.service;

import com.usta.jwtdemo.entity.Facultad;
import com.usta.jwtdemo.repository.FacultadRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacultadServicio {

    @Autowired
    private FacultadRepositorio facultadRepositorio;

    public Facultad create(Facultad facultad){
        return facultadRepositorio.save(facultad);
    }

    public List<Facultad> getAllFacultades() {
        return facultadRepositorio.findAll();
    }

    public void delete (Facultad facultad){
        facultadRepositorio.delete(facultad);
    }

    public Optional<Facultad> findById(Long id){
        return facultadRepositorio.findById(id);
    }

    public void deleteById (Long id) {
        facultadRepositorio.deleteById(id);
    }

    //Querys específicas
    public Integer countTotalFacultades () {
        return facultadRepositorio.countTotalFacultades();
    }

}
