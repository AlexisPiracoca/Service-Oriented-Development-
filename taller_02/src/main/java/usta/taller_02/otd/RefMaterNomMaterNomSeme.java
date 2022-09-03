package usta.taller_02.otd;

public class RefMaterNomMaterNomSeme {
    private String referenciaMateria;
    private String nombreMateria;
    private String nombreSemestre;

    public RefMaterNomMaterNomSeme(String referenciaMateria, String nombreMateria, String nombreSemestre) {
        this.referenciaMateria = referenciaMateria;
        this.nombreMateria = nombreMateria;
        this.nombreSemestre = nombreSemestre;
    }

    public String getReferenciaMateria() {
        return referenciaMateria;
    }

    public void setReferenciaMateria(String referenciaMateria) {
        this.referenciaMateria = referenciaMateria;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public String getNombreSemestre() {
        return nombreSemestre;
    }

    public void setNombreSemestre(String nombreSemestre) {
        this.nombreSemestre = nombreSemestre;
    }
}
