package usta.universidad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import usta.universidad.model.AsignaturaEntity;

public interface AsignturaRepository extends JpaRepository<AsignaturaEntity, Long> {

    @Query("SELECT COUNT(asig) FROM SeccionalEntity asig")
    public Integer countTotalAsignatura();
}
