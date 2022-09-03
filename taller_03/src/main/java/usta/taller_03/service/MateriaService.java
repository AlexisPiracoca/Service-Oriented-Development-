package usta.taller_03.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usta.taller_03.model.MateriaEntity;
import usta.taller_03.repository.MateriaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MateriaService {

    @Autowired
    private MateriaRepository materiaRepository;

    public MateriaEntity create(MateriaEntity materiaEntity){
        return materiaRepository.save(materiaEntity);
    }


    public List<MateriaEntity> getAllMateria(){
        return materiaRepository.findAll();
    }

    public Optional<MateriaEntity> findById(Long id){
        return materiaRepository.findById(id);
    }

    public void delete(MateriaEntity materia){
        materiaRepository.delete(materia);
    }

    public void deleteById(Long id){
        materiaRepository.deleteById(id);
    }
}
