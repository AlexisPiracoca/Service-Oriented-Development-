package usta.universidad.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usta.universidad.model.DocenteEntity;
import usta.universidad.repository.DocenteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DocenteService {

    @Autowired
    private DocenteRepository docenteRepository;

    public List<DocenteEntity> getAllDocente(){
        return docenteRepository.findAll();
    }

    public Optional<DocenteEntity> findDocenteId(Long id){
        return docenteRepository.findById(id);
    }

    public int getTotalDocente(){
        return docenteRepository.countTotalDocente();
    }
}
