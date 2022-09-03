package usta.universidad.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import usta.universidad.model.DocenteEntity;
import usta.universidad.service.DocenteService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/docentes/")
public class DocenteRest {

    @Autowired
    private DocenteService docenteService;

    @GetMapping("")
    private ResponseEntity<List<DocenteEntity>> getAllDocente(){
        return ResponseEntity.ok(docenteService.getAllDocente());
    }

    @GetMapping("{id}")
    private ResponseEntity<Optional<DocenteEntity>> obtenerDocente(@PathVariable("id")Long id){
        return ResponseEntity.ok(docenteService.findDocenteId(id));
    }

    @GetMapping("total")
    private ResponseEntity<String> getTotalDocente(){
        return ResponseEntity.ok("El total de docentes es: "+String.valueOf(docenteService.getTotalDocente())+" docente(s)");
    }
}
