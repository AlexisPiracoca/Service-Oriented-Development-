package usta.taller_02.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usta.taller_02.model.SemestreEntity;
import usta.taller_02.repository.SemestreRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SemestreService {

    @Autowired
    private SemestreRepository semestreRepository;

    public List<SemestreEntity> getAllSemestre(){
        return semestreRepository.findAll();
    }

    public Optional<SemestreEntity> findSemestreNombre(String nombreSemestre){
        return semestreRepository.getSemestreEntityByNombreSemestre(nombreSemestre);
    }
}
