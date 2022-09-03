package usta.taller_02.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import usta.taller_02.model.MateriaPensumEntity;
import usta.taller_02.otd.NombreSemestreNombreMateria;
import usta.taller_02.otd.RefMaterNomMaterNomSeme;
import usta.taller_02.otd.RefMateriaYNombrePensum;
import usta.taller_02.service.MateriaPensumService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/materiaspensums/")
public class MateriaPensumRest {

    @Autowired
    private MateriaPensumService materiaPensumService;

    @GetMapping("listaruno")
    private ResponseEntity<List<RefMateriaYNombrePensum>> getRefMateriaYNombrePensum(){
        return ResponseEntity.ok(materiaPensumService.getRefMateriaYNombrePensum());
    }

    @GetMapping("listardos")
    private ResponseEntity<List<RefMaterNomMaterNomSeme>> getRefMaterNomMaterNomSeme(){
        return ResponseEntity.ok(materiaPensumService.getRefMaterNomMaterNomSeme());
    }

    @GetMapping("")
    private ResponseEntity<List<MateriaPensumEntity>> getAllMateriaPensum(){
        return ResponseEntity.ok(materiaPensumService.getAllMateriaPensum());
    }

    @GetMapping("listartres/{id}")
    @ResponseBody
    public ResponseEntity<Optional<NombreSemestreNombreMateria>> obtenerNombreSemestreNombreMateriabyid(@PathVariable Long id) {
        return ResponseEntity.ok(materiaPensumService.getNombreSemestreNombreMateria(id));
    }
}
