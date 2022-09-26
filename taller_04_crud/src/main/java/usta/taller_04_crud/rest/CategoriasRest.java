package usta.taller_04_crud.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import usta.taller_04_crud.model.CategoriasEntity;
import usta.taller_04_crud.service.CategoriasService;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/categorias/")
public class CategoriasRest {

    @Autowired
    private CategoriasService categoriasService;

    @PostMapping("crear")
    private ResponseEntity<CategoriasEntity> guardar(@RequestBody CategoriasEntity categorias) throws URISyntaxException {
        CategoriasEntity temporal = categoriasService.create(categorias);
        try {
            return ResponseEntity.created(new URI("/api/categorias/" + temporal.getIdCategoria())).body(temporal);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("listar")
    private ResponseEntity<List<CategoriasEntity>> listar(){
        return ResponseEntity.ok(categoriasService.getAllCategoria());
    }

    @GetMapping("listar/{id}")
    private ResponseEntity<Optional<CategoriasEntity>> listarId(@PathVariable Long id){
        return ResponseEntity.ok(categoriasService.findById(id));
    }

    @DeleteMapping("borrar")
    private ResponseEntity<Void> eListarCategoria(@RequestBody CategoriasEntity categorias){
        categoriasService.delete(categorias);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("borrar/{id}")
    private ResponseEntity<Void> eListarCategoriaById(@PathVariable ("id") Long id){
        categoriasService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("editar")
    private ResponseEntity<CategoriasEntity> editar(@RequestBody CategoriasEntity categorias){
        CategoriasEntity temporal = categoriasService.create(categorias);
        try {
            return ResponseEntity.created(new URI("/api/categorias/listar" + temporal.getIdCategoria())).body(temporal);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
