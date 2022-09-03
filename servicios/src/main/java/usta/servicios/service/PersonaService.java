package usta.servicios.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usta.servicios.model.PersonaEntity;
import usta.servicios.repository.PersonaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    public List<PersonaEntity>getAllPersonas(){
        return personaRepository.findAll();
    }

    public Optional<PersonaEntity> findPersonaId(Long id){
        return personaRepository.findById(id);
    }

    public int getTotalPersona(){
        return personaRepository.countTotalPersona();
    }
}
