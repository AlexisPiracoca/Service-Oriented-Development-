package usta.taller_03.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import usta.taller_03.model.FacultadEntity;
import usta.taller_03.service.FacultadService;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/facultades/")
public class FacultadRest {

    @Autowired
    private FacultadService facultadService;

    @PostMapping("crear")
    private ResponseEntity<FacultadEntity> guardar(@RequestBody FacultadEntity facultad) throws URISyntaxException {
        FacultadEntity temporal = facultadService.create(facultad);
        try {
            return ResponseEntity.created(new URI("/api/facultades/" + temporal.getIdFacultad())).body(temporal);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("listar")
    private ResponseEntity<List<FacultadEntity>> listar(){
        return ResponseEntity.ok(facultadService.getAllFacultad());
    }

    @GetMapping("listar/{id}")
    private ResponseEntity<Optional<FacultadEntity>> listarFacultadById(@PathVariable Long id){
        return ResponseEntity.ok(facultadService.findById(id));
    }

    @DeleteMapping("borrar")
    private ResponseEntity<Void> eListarFacultad(@RequestBody FacultadEntity facultad){
        facultadService.delete(facultad);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("borrar/{id}")
    private ResponseEntity<Void> eListarFacultadById(@PathVariable ("id") Long id){
        facultadService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("editar")
    private ResponseEntity<FacultadEntity> editar(@RequestBody FacultadEntity facultad){
        FacultadEntity temporal = facultadService.create(facultad);
        try{
            return ResponseEntity.created(new URI("/api/facultades/listar" + temporal.getIdFacultad())).body(temporal);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
