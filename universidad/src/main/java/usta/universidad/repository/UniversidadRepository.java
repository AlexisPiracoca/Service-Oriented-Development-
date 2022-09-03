package usta.universidad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import usta.universidad.model.UniversidadEntity;

public interface UniversidadRepository extends JpaRepository<UniversidadEntity, Long> {

    @Query("SELECT COUNT(uni) FROM UniversidadEntity uni")
    public Integer countTotalUniversidad();
}
