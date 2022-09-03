package usta.universidad.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usta.universidad.model.UniversidadEntity;
import usta.universidad.repository.UniversidadRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UniversidadService {
    @Autowired
    private UniversidadRepository universidadRepository;

    public List<UniversidadEntity> getAllUniversidad(){
        return universidadRepository.findAll();
    }

    public Optional<UniversidadEntity>findUniversidadId(Long id){
        return universidadRepository.findById(id);
    }

    public int getTotalUniversidad(){
        return universidadRepository.countTotalUniversidad();
    }
}
