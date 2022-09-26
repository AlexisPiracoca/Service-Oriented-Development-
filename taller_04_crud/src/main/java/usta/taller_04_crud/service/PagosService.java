package usta.taller_04_crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usta.taller_04_crud.model.PagosEntity;
import usta.taller_04_crud.repository.PagosRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PagosService {

    @Autowired
    private PagosRepository pagosRepository;

    public PagosEntity create(PagosEntity pagosEntity){
        return pagosRepository.save(pagosEntity);
    }

    public List<PagosEntity> getAllPago(){
        return pagosRepository.findAll();
    }

    public Optional<PagosEntity> findById(Long id){
        return pagosRepository.findById(id);
    }

    public void delete(PagosEntity pagos){
        pagosRepository.delete(pagos);
    }

    public void deleteById(Long id){
        pagosRepository.deleteById(id);
    }
}
