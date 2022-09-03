package usta.universidad.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usta.universidad.model.FacultadEntity;
import usta.universidad.repository.FacultadRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FacultadService {

    @Autowired
    private FacultadRepository facultadRepository;

    public List<FacultadEntity> getAllFacultad(){
        return facultadRepository.findAll();
    }

    public Optional<FacultadEntity> findFacultadId(Long id){
        return facultadRepository.findById(id);
    }

    public int getTotalFacultad(){
        return facultadRepository.countTotalFacultad();
    }
}
