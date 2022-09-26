package usta.taller_04_crud.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import usta.taller_04_crud.model.CitasEntity;
import usta.taller_04_crud.otd.Consulta1;
import usta.taller_04_crud.service.CitasService;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/citas/")
public class CitasRest {

    @Autowired
    private CitasService citasService;

    @PostMapping("crear")
    private ResponseEntity<CitasEntity> guardar(@RequestBody CitasEntity citas) throws URISyntaxException {
        CitasEntity temporal = citasService.create(citas);
        try {
            return ResponseEntity.created(new URI("/api/citas/" + temporal.getIdCita())).body(temporal);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("listar")
    private ResponseEntity<List<CitasEntity>> listar(){
        return ResponseEntity.ok(citasService.getAllCita());
    }

    @GetMapping("listar/{id}")
    private ResponseEntity<Optional<CitasEntity>> listarId(@PathVariable Long id){
        return ResponseEntity.ok(citasService.findById(id));
    }

    @DeleteMapping("borrar")
    private ResponseEntity<Void> eListarCita(@RequestBody CitasEntity citas){
        citasService.delete(citas);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("borrar/{id}")
    private ResponseEntity<Void> eListarCitaById(@PathVariable ("id") Long id){
        citasService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("editar")
    private ResponseEntity<CitasEntity> editar(@RequestBody CitasEntity citas){
        CitasEntity temporal = citasService.create(citas);
        try {
            return ResponseEntity.created(new URI("/api/citas/listar" + temporal.getIdCita())).body(temporal);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("{nombres}/{telefono}")
    private ResponseEntity<List<Consulta1>> obtenerConsulta1(@PathVariable("nombres") String nombres, @PathVariable ("telefono") String  telefono){
        return ResponseEntity.ok(citasService.getConsulta1(nombres, telefono));
    }
}

