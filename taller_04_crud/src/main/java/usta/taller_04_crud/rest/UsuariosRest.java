package usta.taller_04_crud.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import usta.taller_04_crud.model.UsuariosEntity;
import usta.taller_04_crud.service.UsuariosService;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/usuarios/")
public class UsuariosRest {

    @Autowired
    private UsuariosService usuariosService;

    @PostMapping("crear")
    private ResponseEntity<UsuariosEntity> guardar(@RequestBody UsuariosEntity usuarios) throws URISyntaxException {
        UsuariosEntity temporal = usuariosService.create(usuarios);
        try {
            return ResponseEntity.created(new URI("/api/usuarios/" + temporal.getIdUsuario())).body(temporal);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("listar")
    private ResponseEntity<List<UsuariosEntity>> listar(){
        return ResponseEntity.ok(usuariosService.getAllUsuario());
    }

    @GetMapping("listar/{id}")
    private ResponseEntity<Optional<UsuariosEntity>> listarId(@PathVariable Long id){
        return ResponseEntity.ok(usuariosService.findById(id));
    }

    @DeleteMapping("borrar")
    private ResponseEntity<Void> eListarUsuario(@RequestBody UsuariosEntity usuarios){
        usuariosService.delete(usuarios);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("borrar/{id}")
    private ResponseEntity<Void> eListarUsuarioById(@PathVariable ("id") Long id){
        usuariosService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("editar")
    private ResponseEntity<UsuariosEntity> editar(@RequestBody UsuariosEntity usuarios){
        UsuariosEntity temporal = usuariosService.create(usuarios);
        try{
            return ResponseEntity.created(new URI("/api/usuarios/listar" + temporal.getIdUsuario())).body(temporal);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
