package usta.taller_02.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usta.taller_02.model.ProgramaEntity;
import usta.taller_02.repository.ProgramaRepository;

import java.util.List;

@Service
public class ProgramaService {

    @Autowired
    private ProgramaRepository programaRepository;

    public List<ProgramaEntity> getAllPrograma(){
        return programaRepository.findAll();
    }
}
