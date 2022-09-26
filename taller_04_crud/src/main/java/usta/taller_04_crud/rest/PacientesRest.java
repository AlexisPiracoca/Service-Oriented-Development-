package usta.taller_04_crud.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import usta.taller_04_crud.model.PacientesEntity;
import usta.taller_04_crud.otd.Consulta1;
import usta.taller_04_crud.otd.Consulta3;
import usta.taller_04_crud.service.PacientesService;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/pacientes/")
public class PacientesRest {

    @Autowired
    private PacientesService pacientesService;

    @PostMapping("crear")
    private ResponseEntity<PacientesEntity> guardar(@RequestBody PacientesEntity pacientes) throws URISyntaxException {
        PacientesEntity temporal = pacientesService.create(pacientes);
        try {
            return ResponseEntity.created(new URI("/api/pacientes/" + temporal.getIdPaciente())).body(temporal);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("listar")
    private ResponseEntity<List<PacientesEntity>> listar(){
        return ResponseEntity.ok(pacientesService.getAllPaciente());
    }

    @GetMapping("listar/{id}")
    private ResponseEntity<Optional<PacientesEntity>> listarId(@PathVariable Long id){
        return ResponseEntity.ok(pacientesService.findById(id));
    }

    @DeleteMapping("borrar")
    private ResponseEntity<Void> eListarPaciente(@RequestBody PacientesEntity pacientes){
        pacientesService.delete(pacientes);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("borrar/{id}")
    private ResponseEntity<Void> eListarPacienteById(@PathVariable ("id") Long id){
        pacientesService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("editar")
    private ResponseEntity<PacientesEntity> editar(@RequestBody PacientesEntity pacientes){
        PacientesEntity temporal = pacientesService.create(pacientes);
        try {
            return ResponseEntity.created(new URI("/api/pacientes/listar" + temporal.getIdPaciente())).body(temporal);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PostMapping("/consulta3")
    private ResponseEntity<Optional<PacientesEntity>> obtenerConsulta3(@RequestBody Consulta3 consulta3 ){
        return ResponseEntity.ok(pacientesService.getConsulta3(consulta3.getUsername(), consulta3.getPassword()));
    }


































    
}
