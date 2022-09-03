package usta.taller_02.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import usta.taller_02.model.ProgramaEntity;

public interface ProgramaRepository extends JpaRepository<ProgramaEntity, Long> {
}
