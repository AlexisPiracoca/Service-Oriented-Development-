package usta.universidad.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import usta.universidad.model.UniversidadEntity;
import usta.universidad.service.UniversidadService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/universidades/")
public class UniversidadRest {

    @Autowired
    private UniversidadService universidadService;

    @GetMapping("")
    private ResponseEntity<List<UniversidadEntity>> getAllUniversidad(){
        return ResponseEntity.ok(universidadService.getAllUniversidad());
    }

    @GetMapping("{id}")
    private ResponseEntity<Optional<UniversidadEntity>> obtenerUniversidad(@PathVariable("id")Long id){
        return ResponseEntity.ok(universidadService.findUniversidadId(id));
    }

    @GetMapping("total")
    private ResponseEntity<String> getTotalUniversidad(){
        return ResponseEntity.ok("El total de universidades es: "+String.valueOf(universidadService.getTotalUniversidad())+" universidade(s)");
    }
}
