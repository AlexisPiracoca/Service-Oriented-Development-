package usta.taller_04_crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usta.taller_04_crud.model.CitasEntity;
import usta.taller_04_crud.otd.Consulta1;
import usta.taller_04_crud.repository.CitasRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CitasService {

    @Autowired
    private CitasRepository citasRepository;

    public CitasEntity create(CitasEntity citasEntity){
        return citasRepository.save(citasEntity);
    }

    public List<CitasEntity> getAllCita(){
        return citasRepository.findAll();
    }

    public Optional<CitasEntity> findById(Long id){
        return citasRepository.findById(id);
    }

    public void delete(CitasEntity citas){
        citasRepository.delete(citas);
    }

    public void deleteById(Long id){
        citasRepository.deleteById(id);
    }

    public List<Consulta1> getConsulta1(String nombres, String telefono){
        return citasRepository.getConsulta1(nombres, telefono);
    }
}
