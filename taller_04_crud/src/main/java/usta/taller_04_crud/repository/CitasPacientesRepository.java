package usta.taller_04_crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import usta.taller_04_crud.model.CitasPacientesEntity;
import usta.taller_04_crud.otd.Consulta2;

import java.util.List;

public interface CitasPacientesRepository extends JpaRepository<CitasPacientesEntity, Long> {

    @Query("select new usta.taller_04_crud.otd.Consulta2(cp.citasEntity.sintomas, cp.citasEntity.antecedentes, cp.pacientesEntity.alergias) " +
            "from CitasPacientesEntity cp where cp.pacientesEntity.nombres = ?1 and cp.pacientesEntity.documento = ?2")
    List<Consulta2> getConsulta2(String nombres, String documento);
}
