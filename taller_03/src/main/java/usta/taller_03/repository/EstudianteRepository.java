package usta.taller_03.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import usta.taller_03.model.EstudianteEntity;

public interface EstudianteRepository extends JpaRepository<EstudianteEntity, Long> {
}
