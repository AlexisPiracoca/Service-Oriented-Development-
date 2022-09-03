package usta.taller_03.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usta.taller_03.model.FacultadEntity;
import usta.taller_03.repository.FacultadRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FacultadService {

    @Autowired
    private FacultadRepository facultadRepository;

    public FacultadEntity create(FacultadEntity facultadEntity){
        return facultadRepository.save(facultadEntity);
    }


    public List<FacultadEntity> getAllFacultad(){
        return facultadRepository.findAll();
    }

    public Optional<FacultadEntity> findById(Long id){
        return facultadRepository.findById(id);
    }

    public void delete(FacultadEntity facultad){
        facultadRepository.delete(facultad);
    }

    public void deleteById(Long id){
        facultadRepository.deleteById(id);
    }
}
