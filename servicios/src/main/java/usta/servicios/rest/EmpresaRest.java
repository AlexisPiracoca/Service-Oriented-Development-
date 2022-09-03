package usta.servicios.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import usta.servicios.model.EmpresaEntity;
import usta.servicios.service.EmpresaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/empresas/")
public class EmpresaRest {

    @Autowired
    private EmpresaService empresaService;

    @GetMapping("")
    private ResponseEntity<List<EmpresaEntity>> getAllEmpresa(){
        return ResponseEntity.ok(empresaService.getAllEmpresa());
    }

    @GetMapping("{id}")
    private ResponseEntity<Optional<EmpresaEntity>>obtenerEmpresa(@PathVariable("id")Long id){
        return ResponseEntity.ok(empresaService.findEmpresaId(id));
    }

    @GetMapping("total")
    private ResponseEntity<String> getTotalEmpresas(){
        return ResponseEntity.ok("El total de empresas es: "+String.valueOf(empresaService.getTotalEmpresa())+" empresa(s)");
    }
}
