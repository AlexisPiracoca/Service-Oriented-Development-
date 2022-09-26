package usta.taller_04_crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import usta.taller_04_crud.model.CategoriasEntity;

public interface CategoriasRepository extends JpaRepository<CategoriasEntity, Long> {
}
