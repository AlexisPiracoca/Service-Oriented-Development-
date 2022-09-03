package usta.taller_02.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import usta.taller_02.otd.NombrePensumYNombrePrograma;
import usta.taller_02.service.PensumService;

import java.util.List;

@RestController
@RequestMapping("/api/pensums/")
public class PensumRest {

    @Autowired
    private PensumService pensumService;

    @GetMapping("listarpensum/{id}")
    @ResponseBody
    public ResponseEntity<List<NombrePensumYNombrePrograma>> obtenerNombrePensumYPrograma(@PathVariable Long id) {
        return ResponseEntity.ok(pensumService.getNombrePensumYNombrePrograma(id));
    }
}
