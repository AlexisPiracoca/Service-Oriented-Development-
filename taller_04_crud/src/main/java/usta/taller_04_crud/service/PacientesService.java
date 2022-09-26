package usta.taller_04_crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import usta.taller_04_crud.model.PacientesEntity;
import usta.taller_04_crud.otd.Consulta1;
import usta.taller_04_crud.otd.Consulta3;
import usta.taller_04_crud.repository.PacientesRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PacientesService {
    @Autowired
    private PacientesRepository pacientesRepository;

    public PacientesEntity create(PacientesEntity pacientesEntity){
        return pacientesRepository.save(pacientesEntity);
    }

    public List<PacientesEntity> getAllPaciente(){
        return pacientesRepository.findAll();
    }

    public Optional<PacientesEntity> findById(Long id){
        return pacientesRepository.findById(id);
    }

    public void delete(PacientesEntity pacientes){
        pacientesRepository.delete(pacientes);
    }

    public void deleteById(Long id){
        pacientesRepository.deleteById(id);
    }

    public Optional<PacientesEntity> getConsulta3(String username, String password){
        return pacientesRepository.consulta3(username, password);
    }
}
