package com.usta.jwtdemo.rest;

import com.usta.jwtdemo.controller.HomeController;
import com.usta.jwtdemo.entity.Facultad;
import com.usta.jwtdemo.model.JwtRequest;
import com.usta.jwtdemo.model.JwtResponse;
import com.usta.jwtdemo.service.FacultadServicio;
import com.usta.jwtdemo.service.UserService;
import com.usta.jwtdemo.utility.JWTUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping ("/api/facultad/")

public class FacultadRest {

    @Autowired
    private JWTUtility jwtUtility;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired // le dice al programa que existe una entidad, un repositorio y un servicio
    private FacultadServicio facultadServicio;

    @PostMapping("/authenticate")
    public JwtResponse authenticate(@RequestBody JwtRequest jwtRequest) throws Exception{

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            jwtRequest.getUsername(),
                            jwtRequest.getPassword()
                    )
            );
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }

        final UserDetails userDetails
                = userService.loadUserByUsername(jwtRequest.getUsername());

        final String token =
                jwtUtility.generateToken(userDetails);

        return  new JwtResponse(token);
    }

    @PostMapping("/crear")
    private ResponseEntity<Facultad> guardar (@RequestBody Facultad facultad){
        Facultad temporal = facultadServicio.create(facultad);

        try {
            return ResponseEntity.created(new URI("/api/facultad"+temporal.getCodFacultad())).body(temporal);

        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    // @GetMapping ---> Ruta general
    @GetMapping("/listar")//ruta personalizada
    private ResponseEntity<List<Facultad>> listarTodasLasFacultades (){
        return ResponseEntity.ok(facultadServicio.getAllFacultades());
    }

    @DeleteMapping
    private ResponseEntity<Void> eliminarFacultad (@RequestBody Facultad facultad){
        facultadServicio.delete(facultad);
        return ResponseEntity.ok().build();
    }

    @GetMapping (value = "listar/{id}")
    private ResponseEntity<Optional<Facultad>> listarFacultadesPorID (@PathVariable ("id") Long id){
        return ResponseEntity.ok(facultadServicio.findById(id));
    }

    @DeleteMapping(value = "deleteby/{id}")
    private ResponseEntity<String> eliminarFacultadById (@PathVariable ("id") Long id){

            facultadServicio.deleteById(id);
            return ResponseEntity.ok("Facultad Eliminada con exito");

    }

    @PutMapping("/edit")
    private ResponseEntity<Facultad> editar (@RequestBody Facultad facultad){
        Facultad temporal = facultadServicio.create(facultad);

        try {
            return ResponseEntity.created(new URI("/api/facultad"+temporal.getCodFacultad())).body(temporal);

        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping (value = "/totalfacultades")
    private ResponseEntity<Integer> listarTotalFacultadesPorID (){
        return ResponseEntity.ok(facultadServicio.countTotalFacultades());
    }
}
