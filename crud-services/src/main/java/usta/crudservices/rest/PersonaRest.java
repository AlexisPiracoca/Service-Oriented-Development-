package usta.crudservices.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import usta.crudservices.model.PersonaEntity;
import usta.crudservices.service.PersonaService;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/personas/")
public class PersonaRest {

    @Autowired
    private PersonaService personaService;

    @PostMapping("crear")
    private ResponseEntity<PersonaEntity> guardar(@RequestBody PersonaEntity persona) throws URISyntaxException {
        PersonaEntity temporal = personaService.create(persona);
        try {
            return ResponseEntity.created(new URI("/api/personas/" + temporal.getIdPersona())).body(temporal);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("listar")
    private ResponseEntity<List<PersonaEntity>> listar(){
        return ResponseEntity.ok(personaService.getAllPersona());
    }

    @DeleteMapping("borrar")
    private ResponseEntity<Void> eListarPersona(@RequestBody PersonaEntity persona){
        personaService.delete(persona);
        return ResponseEntity.ok().build();
    }

    @GetMapping("listar/{id}")
    private ResponseEntity<Optional<PersonaEntity>> listarPersonaById(@PathVariable Long id){
        return ResponseEntity.ok(personaService.findById(id));
    }

    @DeleteMapping("borrar/{id}")
    private ResponseEntity<Void> eListarPersonaById(@PathVariable ("id") Long id){
        personaService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("editar")
    private ResponseEntity<PersonaEntity> editar(@RequestBody PersonaEntity persona){
        PersonaEntity temporal = personaService.create(persona);
        try{
            return ResponseEntity.created(new URI("/api/personas/listar" + temporal.getIdPersona())).body(temporal);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
