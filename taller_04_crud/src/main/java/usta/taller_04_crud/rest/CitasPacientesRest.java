package usta.taller_04_crud.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import usta.taller_04_crud.model.CitasPacientesEntity;
import usta.taller_04_crud.otd.Consulta2;
import usta.taller_04_crud.service.CitasPacientesService;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/citasPacientes/")
public class CitasPacientesRest {

    @Autowired
    private CitasPacientesService citasPacientesService;

    @PostMapping("crear")
    private ResponseEntity<CitasPacientesEntity> guardar(@RequestBody CitasPacientesEntity citasPacientes) throws URISyntaxException {
        CitasPacientesEntity temporal = citasPacientesService.create(citasPacientes);
        try {
            return ResponseEntity.created(new URI("/api/citasPacientes/" + temporal.getIdCitaPaciente())).body(temporal);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("listar")
    private ResponseEntity<List<CitasPacientesEntity>> listar(){
        return ResponseEntity.ok(citasPacientesService.getAllCitaPaciente());
    }

    @GetMapping("listar/{id}")
    private ResponseEntity<Optional<CitasPacientesEntity>> listarId(@PathVariable Long id){
        return ResponseEntity.ok(citasPacientesService.findById(id));
    }

    @DeleteMapping("borrar")
    private ResponseEntity<Void> eListarCitaPaciente(@RequestBody CitasPacientesEntity citasPacientes){
        citasPacientesService.delete(citasPacientes);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("borrar/{id}")
    private ResponseEntity<Void> eListarCitaPacienteById(@PathVariable ("id") Long id){
        citasPacientesService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("editar")
    private ResponseEntity<CitasPacientesEntity> editar(@RequestBody CitasPacientesEntity citasPacientes){
        CitasPacientesEntity temporal = citasPacientesService.create(citasPacientes);
        try {
            return ResponseEntity.created(new URI("/api/citasPacientes/listar" + temporal.getIdCitaPaciente())).body(temporal);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("{nombres}/{documento}")
    private ResponseEntity<List<Consulta2>> obtenerConsulta2(@PathVariable("nombres") String nombres, @PathVariable ("documento") String  documento){
        return ResponseEntity.ok(citasPacientesService.getConsulta2(nombres, documento));
    }
}
