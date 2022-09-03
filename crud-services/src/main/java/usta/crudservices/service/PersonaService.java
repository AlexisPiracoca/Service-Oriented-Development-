package usta.crudservices.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usta.crudservices.model.PersonaEntity;
import usta.crudservices.repository.PersonaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    public PersonaEntity create(PersonaEntity personaEntity){
        return personaRepository.save(personaEntity);
    }

    public List<PersonaEntity> getAllPersona(){
        return personaRepository.findAll();
    }

    public void delete(PersonaEntity persona){
        personaRepository.delete(persona);
    }

    public Optional<PersonaEntity> findById(Long id){
        return personaRepository.findById(id);
    }

    public void deleteById(Long id){
        personaRepository.deleteById(id);
    }
}
