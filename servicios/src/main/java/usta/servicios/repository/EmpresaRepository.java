package usta.servicios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import usta.servicios.model.EmpresaEntity;

public interface EmpresaRepository extends JpaRepository <EmpresaEntity, Long> {

    @Query("SELECT COUNT(emp) FROM EmpresaEntity emp")
    public Integer countTotalEmpresa();
}
