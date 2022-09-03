package usta.crudservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import usta.crudservices.model.PersonaEntity;

public interface PersonaRepository extends JpaRepository<PersonaEntity, Long> {
}
