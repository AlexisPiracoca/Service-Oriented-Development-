package usta.crudservices.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "persona")
@Getter
@Setter
public class PersonaEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPersona")
    private long idPersona;

    @NotNull
    @Column(name = "nombre",length = 200)
    private String nombre;

    @NotNull
    @Column(name = "apellido",length = 200)
    private String apellido;

    @NotNull
    @Column(name = "correo",length = 50)
    private String correo;

    @NotNull
    @Column(name = "estado")
    private Boolean estado;

}
