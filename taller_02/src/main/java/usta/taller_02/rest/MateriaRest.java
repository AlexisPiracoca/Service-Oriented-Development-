package usta.taller_02.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import usta.taller_02.model.MateriaEntity;
import usta.taller_02.service.MateriaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/materias/")
public class MateriaRest {

    @Autowired
    private MateriaService materiaService;

    @GetMapping("")
    private ResponseEntity<List<MateriaEntity>> getAllMateria(){
        return ResponseEntity.ok(materiaService.getAllMateria());
    }

    @GetMapping("{nombreMateria}")
    private ResponseEntity<Optional<MateriaEntity>> obtenerMateria(@PathVariable("nombreMateria")String nombreMateria){
        return ResponseEntity.ok(materiaService.findMateriaNombre(nombreMateria));
    }
}
