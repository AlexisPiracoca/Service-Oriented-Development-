package usta.universidad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import usta.universidad.model.SeccionalEntity;

public interface SeccionalRepository extends JpaRepository<SeccionalEntity, Long> {

    @Query("SELECT COUNT(secc) FROM SeccionalEntity secc")
    public Integer countTotalSeccional();
}
