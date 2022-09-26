package usta.onetoone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import usta.onetoone.model.SocioEntity;

public interface SocioRepository extends JpaRepository<SocioEntity, Long> {
}
