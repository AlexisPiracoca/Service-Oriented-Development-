package usta.universidad.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Setter
@Getter
@Table(name = "seccional")
public class SeccionalEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idSeccional")
    private long idSeccional;

    @NotNull
    @Column(name = "direccionSeccional",length = 200)
    private String direccionSeccional;

    @NotNull
    @Column(name = "nombreSeccional",length = 200)
    private String nombreSeccional;

    @JoinColumn(name = "idUniversidad", referencedColumnName = "idUniversidad")
    @ManyToOne(fetch = FetchType.EAGER)

    private UniversidadEntity universidadEntity;
}
