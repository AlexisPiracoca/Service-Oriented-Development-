package com.usta.jwtdemo.rest;

import com.usta.jwtdemo.entity.Docente;
import com.usta.jwtdemo.service.DocenteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping ("/api/docente/")

public class DocenteRest {

    @Autowired // le dice al programa que existe una entidad, un repositorio y un servicio
    private DocenteServicio docenteServicio;

    @PostMapping("/crear")
    private ResponseEntity<Docente> guardar (@RequestBody Docente docente){
        Docente temporal = docenteServicio.create(docente);

        try {
            return ResponseEntity.created(new URI("/api/docente"+temporal.getCodDocente())).body(temporal);

        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    // @GetMapping ---> Ruta general
    @GetMapping("/listar")//ruta personalizada
    private ResponseEntity<List<Docente>> listarTodosLosDocentes (){
        return ResponseEntity.ok(docenteServicio.getAllDocentes());
    }

    @DeleteMapping
    private ResponseEntity<Void> eliminarDocentes (@RequestBody Docente docente){
        docenteServicio.delete(docente);
        return ResponseEntity.ok().build();
    }

    @GetMapping (value = "listar/{id}")
    private ResponseEntity<Optional<Docente>> listarDocentesPorID (@PathVariable ("id") Long id){
        return ResponseEntity.ok(docenteServicio.findById(id));
    }

    @DeleteMapping(value = "deleteby/{id}")
    private ResponseEntity<String> eliminarDocenteById (@PathVariable ("id") Long id){
        docenteServicio.deleteById(id);
        return ResponseEntity.ok("Docente Eliminado con exito");
    }

    @PutMapping("/edit")
    private ResponseEntity<Docente> editar (@RequestBody Docente docente){
        Docente temporal = docenteServicio.create(docente);

        try {
            return ResponseEntity.created(new URI("/api/docente"+temporal.getCodDocente())).body(temporal);

        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping (value = "/totalDocentes")
    private ResponseEntity<String> listarTotalDocentesPorID (){
        return ResponseEntity.ok("El total de docentes es: "
                + String.valueOf(docenteServicio.countTotalDocentes()));
    }
}
