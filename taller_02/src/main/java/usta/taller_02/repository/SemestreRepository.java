package usta.taller_02.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import usta.taller_02.model.SemestreEntity;

import java.util.Optional;

public interface SemestreRepository extends JpaRepository<SemestreEntity, Long> {

    Optional<SemestreEntity> getSemestreEntityByNombreSemestre(String nombreSemestre);

}
