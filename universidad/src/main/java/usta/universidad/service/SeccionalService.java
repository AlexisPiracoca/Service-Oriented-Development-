package usta.universidad.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usta.universidad.model.SeccionalEntity;
import usta.universidad.repository.SeccionalRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SeccionalService {

    @Autowired
    private SeccionalRepository seccionalRepository;

    public List<SeccionalEntity> getAllSeccional(){
        return seccionalRepository.findAll();
    }

    public Optional<SeccionalEntity> findSeccionalId(Long id){
        return seccionalRepository.findById(id);
    }

    public int getTotalSeccional(){
        return seccionalRepository.countTotalSeccional();
    }
}
