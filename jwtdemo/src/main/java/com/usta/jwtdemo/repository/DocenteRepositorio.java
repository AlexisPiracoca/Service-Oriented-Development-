package com.usta.jwtdemo.repository;

import com.usta.jwtdemo.entity.Docente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface DocenteRepositorio extends JpaRepository<Docente, Long> {

    @Query("SELECT COUNT(doc) FROM Docente doc")
    public Integer countTotalDocentes();

}
