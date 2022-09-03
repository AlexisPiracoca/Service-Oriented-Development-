package usta.taller_02.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usta.taller_02.model.MateriaPensumEntity;
import usta.taller_02.otd.NombrePensumYNombrePrograma;
import usta.taller_02.otd.NombreSemestreNombreMateria;
import usta.taller_02.otd.RefMaterNomMaterNomSeme;
import usta.taller_02.otd.RefMateriaYNombrePensum;
import usta.taller_02.repository.MateriaPensumRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MateriaPensumService {

    @Autowired
    private MateriaPensumRepository materiaPensumRepository;

    public List<RefMateriaYNombrePensum> getRefMateriaYNombrePensum(){
        return materiaPensumRepository.getRefMateriaYNombrePensum();
    }

    public List<RefMaterNomMaterNomSeme> getRefMaterNomMaterNomSeme(){
        return materiaPensumRepository.getRefMaterNomMaterNomSeme();
    }

    public List<MateriaPensumEntity>getAllMateriaPensum(){
        return materiaPensumRepository.findAll();
    }

    public Optional<NombreSemestreNombreMateria> getNombreSemestreNombreMateria(Long id){
        return materiaPensumRepository.getNombreSemestreNombreMateria(id);
    }
}
