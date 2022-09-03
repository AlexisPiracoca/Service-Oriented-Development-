package usta.taller_02.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import usta.taller_02.model.PensumEntity;
import usta.taller_02.otd.NombrePensumYNombrePrograma;

import java.util.List;
import java.util.Optional;

public interface PensumRepository extends JpaRepository<PensumEntity, Long> {

    @Query("select new usta.taller_02.otd.NombrePensumYNombrePrograma(p.nombrePensum, p.programaEntity.nombrePrograma) " +
            "from PensumEntity p where p.programaEntity.idPrograma=?1")
    List<NombrePensumYNombrePrograma> getNombrePensumYNombrePrograma(Long id);
}
