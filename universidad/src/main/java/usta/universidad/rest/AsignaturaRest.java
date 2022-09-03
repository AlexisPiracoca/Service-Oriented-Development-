package usta.universidad.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import usta.universidad.model.AsignaturaEntity;
import usta.universidad.service.AsignaturaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/asignaturas/")
public class AsignaturaRest {

    @Autowired
    private AsignaturaService asignaturaService;

    @GetMapping("")
    private ResponseEntity<List<AsignaturaEntity>> getAllAsignatura(){
        return ResponseEntity.ok(asignaturaService.getAllAsignatura());
    }

    @GetMapping("{id}")
    private ResponseEntity<Optional<AsignaturaEntity>> obtenerAsignatura(@PathVariable("id")Long id){
        return ResponseEntity.ok(asignaturaService.findAsignaturaId(id));
    }

    @GetMapping("total")
    private ResponseEntity<String> getTotalAsignatura(){
        return ResponseEntity.ok("El total de asignaturas es: "+String.valueOf(asignaturaService.getTotalAsignatura())+" asignatura(s)");
    }
}
