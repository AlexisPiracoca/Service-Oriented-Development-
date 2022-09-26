package usta.taller_04_crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usta.taller_04_crud.model.UsuariosEntity;
import usta.taller_04_crud.repository.UsuariosRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UsuariosService {

    @Autowired
    private UsuariosRepository usuariosRepository;

    public UsuariosEntity create(UsuariosEntity usuariosEntity){
        return usuariosRepository.save(usuariosEntity);
    }

    public List<UsuariosEntity> getAllUsuario(){
        return usuariosRepository.findAll();
    }

    public Optional<UsuariosEntity> findById(Long id){
        return usuariosRepository.findById(id);
    }

    public void delete(UsuariosEntity usuarios){
        usuariosRepository.delete(usuarios);
    }

    public void deleteById(Long id){
        usuariosRepository.deleteById(id);
    }

}
