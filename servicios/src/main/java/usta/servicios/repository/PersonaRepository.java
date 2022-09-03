package usta.servicios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import usta.servicios.model.PersonaEntity;

public interface PersonaRepository extends JpaRepository <PersonaEntity, Long> {

    @Query("SELECT COUNT(per) FROM PersonaEntity per")
    public Integer countTotalPersona();
}
