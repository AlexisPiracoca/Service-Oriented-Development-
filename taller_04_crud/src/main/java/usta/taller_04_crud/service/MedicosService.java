package usta.taller_04_crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usta.taller_04_crud.model.MedicosEntity;
import usta.taller_04_crud.model.PacientesEntity;
import usta.taller_04_crud.repository.MedicosRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MedicosService {

    @Autowired
    private MedicosRepository medicosRepository;

    public MedicosEntity create(MedicosEntity medicosEntity){
        return medicosRepository.save(medicosEntity);
    }

    public List<MedicosEntity> getAllMedico(){
        return medicosRepository.findAll();
    }

    public Optional<MedicosEntity> findById(Long id){
        return medicosRepository.findById(id);
    }

    public void delete(MedicosEntity medicos){
        medicosRepository.delete(medicos);
    }

    public void deleteById(Long id){
        medicosRepository.deleteById(id);
    }

    public List<MedicosEntity> getConsulta4(String nombreCategoria){
        return medicosRepository.consulta4(nombreCategoria);
    }
}
