package usta.taller_03.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import usta.taller_03.model.MateriaEntity;

public interface MateriaRepository extends JpaRepository<MateriaEntity, Long> {
}
