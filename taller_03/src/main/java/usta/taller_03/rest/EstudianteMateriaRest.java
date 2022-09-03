package usta.taller_03.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import usta.taller_03.model.EstudianteMateriaEntity;
import usta.taller_03.model.MateriaEntity;
import usta.taller_03.service.EstudianteMateriaService;
import usta.taller_03.service.MateriaService;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/estudiantesMaterias/")
public class EstudianteMateriaRest {

    @Autowired
    private EstudianteMateriaService estudianteMateriaService;

    @PostMapping("crear")
    private ResponseEntity<EstudianteMateriaEntity> guardar(@RequestBody EstudianteMateriaEntity estudianteMateria) throws URISyntaxException {
        EstudianteMateriaEntity temporal = estudianteMateriaService.create(estudianteMateria);
        try {
            return ResponseEntity.created(new URI("/api/facultades/" + temporal.getIdEstudianteMateria())).body(temporal);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("listar")
    private ResponseEntity<List<EstudianteMateriaEntity>> listar(){
        return ResponseEntity.ok(estudianteMateriaService.getAllEstudianteMateria());
    }

    @GetMapping("listar/{id}")
    private ResponseEntity<Optional<EstudianteMateriaEntity>> listarEstudianteMateriaById(@PathVariable Long id){
        return ResponseEntity.ok(estudianteMateriaService.findById(id));
    }

    @DeleteMapping("borrar")
    private ResponseEntity<Void> eListarEstudianteMateria(@RequestBody EstudianteMateriaEntity estudianteMateria){
        estudianteMateriaService.delete(estudianteMateria);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("borrar/{id}")
    private ResponseEntity<Void> eListarEstudianteMateriaById(@PathVariable ("id") Long id){
        estudianteMateriaService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("editar")
    private ResponseEntity<EstudianteMateriaEntity> editar(@RequestBody EstudianteMateriaEntity estudianteMateria){
        EstudianteMateriaEntity temporal = estudianteMateriaService.create(estudianteMateria);
        try{
            return ResponseEntity.created(new URI("/api/materias/listar" + temporal.getIdEstudianteMateria())).body(temporal);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
