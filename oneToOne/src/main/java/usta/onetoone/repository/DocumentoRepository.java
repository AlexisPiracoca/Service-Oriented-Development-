package usta.onetoone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import usta.onetoone.model.DocumentoEntity;

public interface DocumentoRepository extends JpaRepository<DocumentoEntity, Long> {
}
