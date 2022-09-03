package usta.taller_02.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import usta.taller_02.model.MateriaEntity;

import java.util.Optional;

public interface MateriaRepository extends JpaRepository<MateriaEntity, Long> {

    Optional<MateriaEntity> getMateriaEntityByNombreMateria(String nombreMateria);

}
