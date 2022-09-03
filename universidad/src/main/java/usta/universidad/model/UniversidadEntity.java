package usta.universidad.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Setter
@Getter
@Table(name = "universidad")
public class UniversidadEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUniversidad")
    private long idUniversidad;

    @NotNull
    @Column(name = "nombreUniversidad",length = 200)
    private String nombreUniversidad;

    @NotNull
    @Column(name = "nitUniversidad",length = 200)
    private String nitUniversidad;

    @NotNull
    @Column(name = "nombrePais",length = 50)
    private String nombrePais;
}
