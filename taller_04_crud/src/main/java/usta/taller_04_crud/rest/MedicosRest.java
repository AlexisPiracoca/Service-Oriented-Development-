package usta.taller_04_crud.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import usta.taller_04_crud.model.MedicosEntity;
import usta.taller_04_crud.model.PacientesEntity;
import usta.taller_04_crud.otd.Consulta3;
import usta.taller_04_crud.service.MedicosService;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/medicos/")
public class MedicosRest {

    @Autowired
    private MedicosService medicosService;

    @PostMapping("crear")
    private ResponseEntity<MedicosEntity> guardar(@RequestBody MedicosEntity medicos) throws URISyntaxException {
        MedicosEntity temporal = medicosService.create(medicos);
        try {
            return ResponseEntity.created(new URI("/api/medicos/" + temporal.getIdMedico())).body(temporal);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("listar")
    private ResponseEntity<List<MedicosEntity>> listar(){
        return ResponseEntity.ok(medicosService.getAllMedico());
    }

    @GetMapping("listar/{id}")
    private ResponseEntity<Optional<MedicosEntity>> listarId(@PathVariable Long id){
        return ResponseEntity.ok(medicosService.findById(id));
    }

    @DeleteMapping("borrar")
    private ResponseEntity<Void> eListarMedicos(@RequestBody MedicosEntity medicos){
        medicosService.delete(medicos);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("borrar/{id}")
    private ResponseEntity<Void> eListarMedicoById(@PathVariable ("id") Long id){
        medicosService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("editar")
    private ResponseEntity<MedicosEntity> editar(@RequestBody MedicosEntity medicos){
        MedicosEntity temporal = medicosService.create(medicos);
        try {
            return ResponseEntity.created(new URI("/api/medicos/listar" + temporal.getIdMedico())).body(temporal);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("{nombreCategoria}")
    private ResponseEntity<List<MedicosEntity>> obtenerConsulta4(@PathVariable String nombreCategoria){
        return ResponseEntity.ok(medicosService.getConsulta4(nombreCategoria));
    }
}
