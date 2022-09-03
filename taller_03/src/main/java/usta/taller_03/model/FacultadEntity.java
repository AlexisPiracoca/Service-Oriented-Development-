package usta.taller_03.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "facultad")
@Getter
@Setter
public class FacultadEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFacultad")
    private long idFacultad;

    @NotNull
    @Column(name = "nombre",length = 50)
    private String nombre;

}
