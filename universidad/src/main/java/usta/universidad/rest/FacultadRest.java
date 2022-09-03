package usta.universidad.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import usta.universidad.model.FacultadEntity;
import usta.universidad.service.FacultadService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/facultades/")
public class FacultadRest {

    @Autowired
    private FacultadService facultadService;

    @GetMapping("")
    private ResponseEntity<List<FacultadEntity>> getAllFacultad(){
        return ResponseEntity.ok(facultadService.getAllFacultad());
    }

    @GetMapping("{id}")
    private ResponseEntity<Optional<FacultadEntity>> obtenerFacultad(@PathVariable("id")Long id){
        return ResponseEntity.ok(facultadService.findFacultadId(id));
    }

    @GetMapping("total")
    private ResponseEntity<String> getTotalFacultad(){
        return ResponseEntity.ok("El total de facultades es: "+String.valueOf(facultadService.getTotalFacultad())+" facultad(s)");
    }
}
