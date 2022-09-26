package usta.taller_04_crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import usta.taller_04_crud.model.PacientesEntity;
import usta.taller_04_crud.otd.Consulta3;

import java.util.List;
import java.util.Optional;

public interface PacientesRepository extends JpaRepository<PacientesEntity, Long> {

    @Query("select p from PacientesEntity p where p.usuarios.username = ?1 and p.usuarios.password = ?2")
    Optional<PacientesEntity> consulta3(String username, String password);
}
