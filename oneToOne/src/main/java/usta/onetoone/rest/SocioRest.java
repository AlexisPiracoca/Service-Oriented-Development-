package usta.onetoone.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import usta.onetoone.model.SocioEntity;
import usta.onetoone.service.SocioService;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/socios/")
public class SocioRest {

    @Autowired
    private SocioService socioService;

    @PostMapping("crear")
    private ResponseEntity<SocioEntity> guardar(@RequestBody SocioEntity socio) throws URISyntaxException {
        SocioEntity temporal = socioService.create(socio);
        try {
            return ResponseEntity.created(new URI("/api/socios/" + temporal.getIdSocio())).body(temporal);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("listar")
    private ResponseEntity<List<SocioEntity>> listar(){
        return ResponseEntity.ok(socioService.getAllSocio());
    }

    @GetMapping("listar/{id}")
    private ResponseEntity<Optional<SocioEntity>> listarSocioId(@PathVariable Long id){
        return ResponseEntity.ok(socioService.findById(id));
    }

    @DeleteMapping("borrar")
    private ResponseEntity<Void> eListarSocio(@RequestBody SocioEntity socio){
        socioService.delete(socio);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("borrar/{id}")
    private ResponseEntity<Void> eListarSocioById(@PathVariable ("id") Long id){
        socioService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("editar")
    private ResponseEntity<SocioEntity> editar(@RequestBody SocioEntity socio){
        SocioEntity temporal = socioService.create(socio);
        try{
            return ResponseEntity.created(new URI("/api/socios/listar" + temporal.getIdSocio())).body(temporal);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
