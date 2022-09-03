package usta.taller_02.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usta.taller_02.otd.NombrePensumYNombrePrograma;
import usta.taller_02.repository.PensumRepository;

import java.util.List;

@Service
public class PensumService {

    @Autowired
    private PensumRepository pensumRepository;

    public List<NombrePensumYNombrePrograma> getNombrePensumYNombrePrograma(Long id){
        return pensumRepository.getNombrePensumYNombrePrograma(id);
    }
}
