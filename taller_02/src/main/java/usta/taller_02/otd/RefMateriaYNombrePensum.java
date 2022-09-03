package usta.taller_02.otd;

public class RefMateriaYNombrePensum {

    private String referenciaMateria;
    private String nombrePensum;

    public RefMateriaYNombrePensum(String referenciaMateria, String nombrePensum) {
        this.referenciaMateria = referenciaMateria;
        this.nombrePensum = nombrePensum;
    }

    public String getReferenciaMateria() {
        return referenciaMateria;
    }

    public void setReferenciaMateria(String referenciaMateria) {
        this.referenciaMateria = referenciaMateria;
    }

    public String getNombrePensum() {
        return nombrePensum;
    }

    public void setNombrePensum(String nombrePensum) {
        this.nombrePensum = nombrePensum;
    }
}
