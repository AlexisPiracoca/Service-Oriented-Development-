package usta.universidad.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usta.universidad.model.AsignaturaEntity;
import usta.universidad.repository.AsignturaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AsignaturaService {

    @Autowired
    private AsignturaRepository asignturaRepository;

    public List<AsignaturaEntity> getAllAsignatura(){
        return asignturaRepository.findAll();
    }

    public Optional<AsignaturaEntity> findAsignaturaId(Long id){
        return asignturaRepository.findById(id);
    }

    public int getTotalAsignatura(){
        return asignturaRepository.countTotalAsignatura();
    }
}
