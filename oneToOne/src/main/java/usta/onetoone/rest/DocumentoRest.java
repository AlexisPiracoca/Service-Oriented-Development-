package usta.onetoone.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import usta.onetoone.model.DocumentoEntity;
import usta.onetoone.service.DocumentoService;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/documentos/")
public class DocumentoRest {

    @Autowired
    private DocumentoService documentoService;

    @PostMapping("crear")
    private ResponseEntity<DocumentoEntity> guardar(@RequestBody DocumentoEntity documento) throws URISyntaxException {
        DocumentoEntity temporal = documentoService.create(documento);
        try {
            return ResponseEntity.created(new URI("/api/documentos/" + temporal.getIdDocumento())).body(temporal);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("listar")
    private ResponseEntity<List<DocumentoEntity>> listar(){
        return ResponseEntity.ok(documentoService.getAllDocumento());
    }

    @GetMapping("listar/{id}")
    private ResponseEntity<Optional<DocumentoEntity>> listarDocumentoId(@PathVariable Long id){
        return ResponseEntity.ok(documentoService.findById(id));
    }

    @DeleteMapping("borrar")
    private ResponseEntity<Void> eListarDocumento(@RequestBody DocumentoEntity documento){
        documentoService.delete(documento);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("borrar/{id}")
    private ResponseEntity<Void> eListarDocumentoById(@PathVariable ("id") Long id){
        documentoService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("editar")
    private ResponseEntity<DocumentoEntity> editar(@RequestBody DocumentoEntity documento){
        DocumentoEntity temporal = documentoService.create(documento);
        try{
            return ResponseEntity.created(new URI("/api/documentos/listar" + temporal.getIdDocumento())).body(temporal);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
