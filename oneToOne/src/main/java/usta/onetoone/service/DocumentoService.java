package usta.onetoone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usta.onetoone.model.DocumentoEntity;
import usta.onetoone.repository.DocumentoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentoService {

    @Autowired
    private DocumentoRepository documentoRepository;

    public DocumentoEntity create(DocumentoEntity documentoEntity){
        return documentoRepository.save(documentoEntity);
    }

    public List<DocumentoEntity> getAllDocumento(){
        return documentoRepository.findAll();
    }

    public Optional<DocumentoEntity> findById(Long id){
        return documentoRepository.findById(id);
    }

    public void delete(DocumentoEntity documento){
        documentoRepository.delete(documento);
    }

    public void deleteById(Long id){
        documentoRepository.deleteById(id);
    }
}
