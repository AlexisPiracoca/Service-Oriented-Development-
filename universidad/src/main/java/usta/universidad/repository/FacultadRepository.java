package usta.universidad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import usta.universidad.model.FacultadEntity;

public interface FacultadRepository extends JpaRepository<FacultadEntity, Long> {

    @Query("SELECT COUNT(facu) FROM FacultadEntity facu")
    public Integer countTotalFacultad();
}
