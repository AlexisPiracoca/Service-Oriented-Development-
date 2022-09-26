package usta.taller_03.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usta.taller_03.model.EstudianteEntity;
import usta.taller_03.repository.EstudianteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    public EstudianteEntity create(EstudianteEntity estudianteEntity){
        return estudianteRepository.save(estudianteEntity);
    }

    public List<EstudianteEntity> getAllEstudiante(){
        return estudianteRepository.findAll();
    }

    public Optional<EstudianteEntity> findById(Long id){
        return estudianteRepository.findById(id);
    }

    public void delete(EstudianteEntity estudiante){
        estudianteRepository.delete(estudiante);
    }

    public void deleteById(Long id){
        estudianteRepository.deleteById(id);
    }
}
