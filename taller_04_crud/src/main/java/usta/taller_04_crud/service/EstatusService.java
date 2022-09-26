package usta.taller_04_crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usta.taller_04_crud.model.EstatusEntity;
import usta.taller_04_crud.repository.EstatusRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EstatusService {

    @Autowired
    private EstatusRepository estatusRepository;

    public EstatusEntity create(EstatusEntity estatusEntity){
        return estatusRepository.save(estatusEntity);
    }

    public List<EstatusEntity> getAllEstatus(){
        return estatusRepository.findAll();
    }

    public Optional<EstatusEntity> findById(Long id){
        return estatusRepository.findById(id);
    }

    public void delete(EstatusEntity estatus){
        estatusRepository.delete(estatus);
    }

    public void deleteById(Long id){
        estatusRepository.deleteById(id);
    }
}
