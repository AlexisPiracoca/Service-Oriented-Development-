package usta.taller_02.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import usta.taller_02.model.ProgramaEntity;
import usta.taller_02.service.ProgramaService;

import java.util.List;

@RestController
@RequestMapping("/api/programas/")
public class ProgramaRest {

    @Autowired
    private ProgramaService programaService;

    @GetMapping("")
    private ResponseEntity<List<ProgramaEntity>> getAllPrograma(){
        return ResponseEntity.ok(programaService.getAllPrograma());
    }
}
