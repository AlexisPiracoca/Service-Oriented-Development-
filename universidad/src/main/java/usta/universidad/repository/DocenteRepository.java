package usta.universidad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import usta.universidad.model.DocenteEntity;

public interface DocenteRepository extends JpaRepository<DocenteEntity, Long> {

    @Query("SELECT COUNT(doce) FROM DocenteEntity doce")
    public Integer countTotalDocente();
}
