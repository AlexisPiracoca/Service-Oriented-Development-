package usta.onetoone.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "documento")
@Getter
@Setter
public class DocumentoEntity implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDocumento")
    private long idDocumento;

    @NotNull
    @Column(name = "tipoDocumento")
    private Integer tipodDocumento;

    @NotNull
    @Column(name = "numeroDocumento", unique = true)
    private String numeroDocumento;

    @NotNull
    @Column(name = "fechaExpedicion")
    @DateTimeFormat(pattern = "yyyy-mmm-dd")
    @Temporal(TemporalType.DATE)
    private Date fechaExpedicion;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "idSocio")
    private SocioEntity socio;
}
