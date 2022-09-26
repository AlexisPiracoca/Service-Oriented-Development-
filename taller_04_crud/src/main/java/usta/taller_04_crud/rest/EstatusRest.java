package usta.taller_04_crud.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import usta.taller_04_crud.model.EstatusEntity;
import usta.taller_04_crud.service.EstatusService;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/estatus/")
public class EstatusRest {

    @Autowired
    private EstatusService estatusService;

    @PostMapping("crear")
    private ResponseEntity<EstatusEntity> guardar(@RequestBody EstatusEntity estatus) throws URISyntaxException {
        EstatusEntity temporal = estatusService.create(estatus);
        try {
            return ResponseEntity.created(new URI("/api/estatus/" + temporal.getIdEstatus())).body(temporal);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("listar")
    private ResponseEntity<List<EstatusEntity>> listar(){
        return ResponseEntity.ok(estatusService.getAllEstatus());
    }

    @GetMapping("listar/{id}")
    private ResponseEntity<Optional<EstatusEntity>> listarId(@PathVariable Long id){
        return ResponseEntity.ok(estatusService.findById(id));
    }

    @DeleteMapping("borrar")
    private ResponseEntity<Void> eListarEstatus(@RequestBody EstatusEntity estatus){
        estatusService.delete(estatus);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("borrar/{id}")
    private ResponseEntity<Void> eListarEstatusById(@PathVariable ("id") Long id){
        estatusService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("editar")
    private ResponseEntity<EstatusEntity> editar(@RequestBody EstatusEntity estatus){
        EstatusEntity temporal = estatusService.create(estatus);
        try {
            return ResponseEntity.created(new URI("/api/estatus/listar" + temporal.getIdEstatus())).body(temporal);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
