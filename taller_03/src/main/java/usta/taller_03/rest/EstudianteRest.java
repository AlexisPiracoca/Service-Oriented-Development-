package usta.taller_03.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import usta.taller_03.model.EstudianteEntity;
import usta.taller_03.service.EstudianteService;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/estudiantes/")
public class EstudianteRest {

    @Autowired
    private EstudianteService estudianteService;

    @PostMapping("crear")
    private ResponseEntity<EstudianteEntity> guardar(@RequestBody EstudianteEntity estudiante) throws URISyntaxException {
        EstudianteEntity temporal = estudianteService.create(estudiante);
        try {
            return ResponseEntity.created(new URI("/api/estudiantes/" + temporal.getIdEstudiante())).body(temporal);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("listar")
    private ResponseEntity<List<EstudianteEntity>> listar(){
        return ResponseEntity.ok(estudianteService.getAllEstudiante());
    }

    @GetMapping("listar/{id}")
    private ResponseEntity<Optional<EstudianteEntity>> listarEstudianteyId(@PathVariable Long id){
        return ResponseEntity.ok(estudianteService.findById(id));
    }

    @DeleteMapping("borrar")
    private ResponseEntity<Void> eListarEstudiante(@RequestBody EstudianteEntity estudiante){
        estudianteService.delete(estudiante);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("borrar/{id}")
    private ResponseEntity<Void> eListarEstudianteById(@PathVariable ("id") Long id){
        estudianteService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("editar")
    private ResponseEntity<EstudianteEntity> editar(@RequestBody EstudianteEntity estudiante){
        EstudianteEntity temporal = estudianteService.create(estudiante);
        try{
            return ResponseEntity.created(new URI("/api/estudiantes/listar" + temporal.getIdEstudiante())).body(temporal);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
