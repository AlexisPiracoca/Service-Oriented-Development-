package usta.taller_04_crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import usta.taller_04_crud.model.MedicosEntity;

import java.util.List;


public interface
MedicosRepository extends JpaRepository<MedicosEntity, Long> {

    @Query("select m from MedicosEntity m where m.categoriasEntity.nombreCategoria = ?1")
    List<MedicosEntity> consulta4(String nombreCategoria);

}
