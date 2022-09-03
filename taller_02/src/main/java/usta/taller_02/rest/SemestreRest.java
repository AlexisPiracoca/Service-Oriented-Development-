package usta.taller_02.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import usta.taller_02.model.SemestreEntity;
import usta.taller_02.service.SemestreService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/semestres/")
public class SemestreRest {

    @Autowired
    private SemestreService semestreService;

    @GetMapping("")
    private ResponseEntity<List<SemestreEntity>> getAllSemestre(){
        return ResponseEntity.ok(semestreService.getAllSemestre());
    }

    @GetMapping("{nombreSemestre}")
    private ResponseEntity<Optional<SemestreEntity>> obtenerSemestre(@PathVariable("nombreSemestre")String nombreSemestre){
        return ResponseEntity.ok(semestreService.findSemestreNombre(nombreSemestre));
    }
}
