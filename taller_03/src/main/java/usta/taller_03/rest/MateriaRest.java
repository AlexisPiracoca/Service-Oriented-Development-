package usta.taller_03.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import usta.taller_03.model.FacultadEntity;
import usta.taller_03.model.MateriaEntity;
import usta.taller_03.service.FacultadService;
import usta.taller_03.service.MateriaService;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/materias/")
public class MateriaRest {

    @Autowired
    private MateriaService materiaService;

    @PostMapping("crear")
    private ResponseEntity<MateriaEntity> guardar(@RequestBody MateriaEntity materia) throws URISyntaxException {
        MateriaEntity temporal = materiaService.create(materia);
        try {
            return ResponseEntity.created(new URI("/api/facultades/" + temporal.getIdMateria())).body(temporal);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("listar")
    private ResponseEntity<List<MateriaEntity>> listar(){
        return ResponseEntity.ok(materiaService.getAllMateria());
    }

    @GetMapping("listar/{id}")
    private ResponseEntity<Optional<MateriaEntity>> listarMateriaById(@PathVariable Long id){
        return ResponseEntity.ok(materiaService.findById(id));
    }

    @DeleteMapping("borrar")
    private ResponseEntity<Void> eListarMateria(@RequestBody MateriaEntity materia){
        materiaService.delete(materia);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("borrar/{id}")
    private ResponseEntity<Void> eListarMateriaById(@PathVariable ("id") Long id){
        materiaService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("editar")
    private ResponseEntity<MateriaEntity> editar(@RequestBody MateriaEntity materia){
        MateriaEntity temporal = materiaService.create(materia);
        try{
            return ResponseEntity.created(new URI("/api/materias/listar" + temporal.getIdMateria())).body(temporal);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
