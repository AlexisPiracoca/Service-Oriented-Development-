package usta.taller_02.otd;

import java.util.List;

public class NombreSemestreNombreMateria {

    private String nombreSemestre;
    private String nombreMateria;

    public NombreSemestreNombreMateria(String nombreSemestre, String nombreMateria) {
        this.nombreSemestre = nombreSemestre;
        this.nombreMateria = nombreMateria;
    }


    public String getNombreSemestre() {
        return nombreSemestre;
    }

    public void setNombreSemestre(String nombreSemestre) {
        this.nombreSemestre = nombreSemestre;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }
}
