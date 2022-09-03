package usta.universidad.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import usta.universidad.model.SeccionalEntity;
import usta.universidad.service.SeccionalService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/seccionales/")
public class SeccionalRest {

    @Autowired
    private SeccionalService seccionalService;

    @GetMapping("")
    private ResponseEntity<List<SeccionalEntity>> getAllSeccional(){
        return ResponseEntity.ok(seccionalService.getAllSeccional());
    }

    @GetMapping("{id}")
    private ResponseEntity<Optional<SeccionalEntity>> obtenerSeccional(@PathVariable("id")Long id){
        return ResponseEntity.ok(seccionalService.findSeccionalId(id));
    }

    @GetMapping("total")
    private ResponseEntity<String> getTotalSeccional(){
        return ResponseEntity.ok("El total de seccionales es: "+String.valueOf(seccionalService.getTotalSeccional())+" seccionale(s)");
    }
}
