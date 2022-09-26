package com.usta.jwtdemo.service;

import com.usta.jwtdemo.entity.Docente;
import com.usta.jwtdemo.repository.DocenteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocenteServicio {

    @Autowired
    private DocenteRepositorio docenteRepositorio;

    public Docente create(Docente docente){
        return docenteRepositorio.save(docente);
    }

    public List<Docente> getAllDocentes() {
        return docenteRepositorio.findAll();
    }

    public void delete (Docente docente){
        docenteRepositorio.delete(docente);
    }

    public Optional<Docente> findById(Long id){
        return docenteRepositorio.findById(id);
    }

    public void deleteById (Long id) {
        docenteRepositorio.deleteById(id);
    }

    //Querys específicas
    public Integer countTotalDocentes () {
        return docenteRepositorio.countTotalDocentes();
    }

}
