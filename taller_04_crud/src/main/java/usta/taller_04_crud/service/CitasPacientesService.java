package usta.taller_04_crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usta.taller_04_crud.model.CitasPacientesEntity;
import usta.taller_04_crud.otd.Consulta1;
import usta.taller_04_crud.otd.Consulta2;
import usta.taller_04_crud.repository.CitasPacientesRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CitasPacientesService {

        @Autowired
        private CitasPacientesRepository citasPacientesRepository;

        public CitasPacientesEntity create(CitasPacientesEntity citasPacientesEntity){
                return citasPacientesRepository.save(citasPacientesEntity);
        }

        public List<CitasPacientesEntity> getAllCitaPaciente(){
                return citasPacientesRepository.findAll();
        }

        public Optional<CitasPacientesEntity> findById(Long id){
                return citasPacientesRepository.findById(id);
        }

        public void delete(CitasPacientesEntity citasPacientes){
                citasPacientesRepository.delete(citasPacientes);
        }

        public void deleteById(Long id){citasPacientesRepository.deleteById(id);
        }

        public List<Consulta2> getConsulta2(String nombres, String documento){
                return citasPacientesRepository.getConsulta2(nombres, documento);
        }
}
