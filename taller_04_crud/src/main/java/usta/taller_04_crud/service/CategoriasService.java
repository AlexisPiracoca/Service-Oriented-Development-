package usta.taller_04_crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usta.taller_04_crud.model.CategoriasEntity;
import usta.taller_04_crud.repository.CategoriasRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriasService {

    @Autowired
    private CategoriasRepository categoriasRepository;

    public CategoriasEntity create(CategoriasEntity categoriasEntity){
        return categoriasRepository.save(categoriasEntity);
    }

    public List<CategoriasEntity> getAllCategoria(){
        return categoriasRepository.findAll();
    }

    public Optional<CategoriasEntity> findById(Long id){
        return categoriasRepository.findById(id);
    }

    public void delete(CategoriasEntity categorias){
        categoriasRepository.delete(categorias);
    }

    public void deleteById(Long id){
        categoriasRepository.deleteById(id);
    }


}
