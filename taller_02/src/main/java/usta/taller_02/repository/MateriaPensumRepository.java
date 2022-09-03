package usta.taller_02.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import usta.taller_02.model.MateriaPensumEntity;
import usta.taller_02.otd.NombrePensumYNombrePrograma;
import usta.taller_02.otd.NombreSemestreNombreMateria;
import usta.taller_02.otd.RefMaterNomMaterNomSeme;
import usta.taller_02.otd.RefMateriaYNombrePensum;

import java.util.List;
import java.util.Optional;

public interface MateriaPensumRepository extends JpaRepository<MateriaPensumEntity, Long> {

    @Query("select new usta.taller_02.otd.RefMateriaYNombrePensum(r.materiaEntity.referenciaMateria, r.pensumEntity.nombrePensum) " +
            "from MateriaPensumEntity r")
    List<RefMateriaYNombrePensum> getRefMateriaYNombrePensum();

    @Query("select new usta.taller_02.otd.RefMaterNomMaterNomSeme(rm.materiaEntity.referenciaMateria, rm.materiaEntity.nombreMateria, rm.semestreEntity.nombreSemestre) " +
            "from MateriaPensumEntity rm")
    List<RefMaterNomMaterNomSeme> getRefMaterNomMaterNomSeme();

    @Query("select new usta.taller_02.otd.NombreSemestreNombreMateria(n.semestreEntity.nombreSemestre, n.materiaEntity.nombreMateria) " +
            "from MateriaPensumEntity n where n.materiaEntity.idMateria=?1")
    Optional<NombreSemestreNombreMateria> getNombreSemestreNombreMateria(Long id);
}
