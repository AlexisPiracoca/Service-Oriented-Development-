package usta.taller_04_crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import usta.taller_04_crud.model.CitasEntity;
import usta.taller_04_crud.otd.Consulta1;

import java.util.List;

public interface CitasRepository extends JpaRepository<CitasEntity, Long> {

    @Query("select new usta.taller_04_crud.otd.Consulta1(ct.titulo, ct.antecedentes, ct.medicosEntity.email) " +
            "from CitasEntity ct where ct.medicosEntity.nombres = ?1 and ct.medicosEntity.telefono = ?2")
    List<Consulta1> getConsulta1(String nombres, String telefono);


}
