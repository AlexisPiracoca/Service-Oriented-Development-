package usta.onetoone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usta.onetoone.model.SocioEntity;
import usta.onetoone.repository.SocioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SocioService {
    @Autowired
    private SocioRepository socioRepository;

    public SocioEntity create(SocioEntity socioEntity){
        return socioRepository.save(socioEntity);
    }

    public List<SocioEntity> getAllSocio(){
        return socioRepository.findAll();
    }

    public Optional<SocioEntity> findById(Long id){
        return socioRepository.findById(id);
    }

    public void delete(SocioEntity socio){
        socioRepository.delete(socio);
    }

    public void deleteById(Long id){
        socioRepository.deleteById(id);
    }
}
