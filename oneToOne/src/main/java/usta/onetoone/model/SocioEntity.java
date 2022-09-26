package usta.onetoone.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "socio")
@Getter
@Setter
public class SocioEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idSocio")
    private long idSocio;

    @NotNull
    @Column(name = "nombre")
    private String nombre;

    @NotNull
    @Column(name = "apellido")
    private String apellido;

    @NotNull
    @Column(name = "fechaNacimiento")
    @DateTimeFormat(pattern = "yyyy-mmm-dd")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;

    @OneToOne(mappedBy = "socio")
    @JsonIgnore
    private DocumentoEntity documentoEntity;

}
