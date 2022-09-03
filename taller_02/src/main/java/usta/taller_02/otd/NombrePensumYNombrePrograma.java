package usta.taller_02.otd;

public class NombrePensumYNombrePrograma {

    private String nombrePensum;
    private String nombrePrograma;

    public String getNombrePrograma() {
        return nombrePrograma;
    }

    public void setNombrePrograma(String nombrePrograma) {
        this.nombrePrograma = nombrePrograma;
    }

    public String getNombrePensum() {
        return nombrePensum;
    }

    public void setNombrePensum(String nombrePensum) {
        this.nombrePensum = nombrePensum;
    }

    public NombrePensumYNombrePrograma(String nombrePensum, String nombrePrograma) {
        this.nombrePensum = nombrePensum;
        this.nombrePrograma=nombrePrograma;
    }
}
