package usta.taller_04_crud.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import usta.taller_04_crud.model.PagosEntity;
import usta.taller_04_crud.service.PagosService;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/pagos/")
public class PagosRest {

    @Autowired
    private PagosService pagosService;

    @PostMapping("crear")
    private ResponseEntity<PagosEntity> guardar(@RequestBody PagosEntity pagos) throws URISyntaxException {
        PagosEntity temporal = pagosService.create(pagos);
        try {
            return ResponseEntity.created(new URI("/api/pagos/" + temporal.getIdPago())).body(temporal);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("listar")
    private ResponseEntity<List<PagosEntity>> listar(){
        return ResponseEntity.ok(pagosService.getAllPago());
    }

    @GetMapping("listar/{id}")
    private ResponseEntity<Optional<PagosEntity>> listarId(@PathVariable Long id){
        return ResponseEntity.ok(pagosService.findById(id));
    }

    @DeleteMapping("borrar")
    private ResponseEntity<Void> eListarPago(@RequestBody PagosEntity pagos){
        pagosService.delete(pagos);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("borrar/{id}")
    private ResponseEntity<Void> eListarPagoById(@PathVariable ("id") Long id){
        pagosService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("editar")
    private ResponseEntity<PagosEntity> editar(@RequestBody PagosEntity pagos){
        PagosEntity temporal = pagosService.create(pagos);
        try{
            return ResponseEntity.created(new URI("/api/pagos/listar" + temporal.getIdPago())).body(temporal);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
