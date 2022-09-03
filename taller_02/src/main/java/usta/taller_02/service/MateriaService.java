package usta.taller_02.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usta.taller_02.model.MateriaEntity;
import usta.taller_02.repository.MateriaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MateriaService {

    @Autowired
    private MateriaRepository materiaRepository;

    public List<MateriaEntity> getAllMateria(){
        return materiaRepository.findAll();
    }

    public Optional<MateriaEntity> findMateriaNombre(String nombreMateria){
        return materiaRepository.getMateriaEntityByNombreMateria(nombreMateria);
    }
}
