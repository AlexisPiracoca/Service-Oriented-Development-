package usta.taller_04_crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import usta.taller_04_crud.model.UsuariosEntity;

public interface UsuariosRepository extends JpaRepository<UsuariosEntity, Long> {
}
