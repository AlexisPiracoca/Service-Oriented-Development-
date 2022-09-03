package usta.servicios.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usta.servicios.model.EmpresaEntity;
import usta.servicios.repository.EmpresaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    public List<EmpresaEntity>getAllEmpresa(){
        return empresaRepository.findAll();
    }

    public Optional<EmpresaEntity> findEmpresaId(Long id){
        return empresaRepository.findById(id);
    }

    public int getTotalEmpresa(){
        return empresaRepository.countTotalEmpresa();
    }
}
