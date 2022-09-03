package usta.taller_03.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usta.taller_03.model.EstudianteMateriaEntity;
import usta.taller_03.repository.EstudianteMateriaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EstudianteMateriaService {
    @Autowired
    private EstudianteMateriaRepository estudianteMateriaRepository;

    public EstudianteMateriaEntity create(EstudianteMateriaEntity estudianteMateriaEntity){
        return estudianteMateriaRepository.save(estudianteMateriaEntity);
    }


    public List<EstudianteMateriaEntity> getAllEstudianteMateria(){
        return estudianteMateriaRepository.findAll();
    }

    public Optional<EstudianteMateriaEntity> findById(Long id){
        return estudianteMateriaRepository.findById(id);
    }

    public void delete(EstudianteMateriaEntity estudianteMateria){
        estudianteMateriaRepository.delete(estudianteMateria);
    }

    public void deleteById(Long id){
        estudianteMateriaRepository.deleteById(id);
    }
}
