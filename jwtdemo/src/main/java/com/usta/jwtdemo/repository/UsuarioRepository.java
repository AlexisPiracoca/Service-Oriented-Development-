package com.usta.jwtdemo.repository;

import com.usta.jwtdemo.entity.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    @Query("SELECT u FROM Usuario u WHERE u.username=?1")
    public Usuario findByUsername(String term);
}
