package usta.servicios.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import usta.servicios.model.PersonaEntity;
import usta.servicios.service.PersonaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/personas/")
public class PersonaRest {

    @Autowired
    private PersonaService personaService;

    @GetMapping("")
    private ResponseEntity<List<PersonaEntity>> getAllPersonas(){
        return ResponseEntity.ok(personaService.getAllPersonas());
    }

    @GetMapping("{id}")
    private ResponseEntity<Optional<PersonaEntity>>obtenerPersona(@PathVariable("id")Long id){
        return ResponseEntity.ok(personaService.findPersonaId(id));
    }

    @GetMapping("total")
    private ResponseEntity<String> getTotalPersonas(){
        return ResponseEntity.ok("El total de personas es: "+String.valueOf(personaService.getTotalPersona())+" persona(s)");
    }
}
