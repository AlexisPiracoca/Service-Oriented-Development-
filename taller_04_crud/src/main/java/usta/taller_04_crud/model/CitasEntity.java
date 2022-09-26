package usta.taller_04_crud.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "citas")
@Getter
@Setter
public class CitasEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCita")
    private long idCita;

    @NotNull
    @Column(name = "titulo",length = 50)
    private String titulo;

    @NotNull
    @Column(name = "nota",length = 50)
    private String nota;

    @NotNull
    @Column(name = "fechaCita")
    @DateTimeFormat(pattern = "yyyy-mmm-dd")
    @Temporal(TemporalType.DATE)
    private Date fechaCita;

    @NotNull
    @Column(name = "sintomas",length = 100)
    private String sintomas;

    @NotNull
    @Column(name = "medicamentos",length = 100)
    private String medicamentos;

    @NotNull
    @Column(name = "tipoCita")
    private int tipoCita;

    @NotNull
    @Column(name = "antecedentes")
    private boolean antecedentes;

    @JoinColumn(name = "idMedico", referencedColumnName = "idMedico")
    @ManyToOne(fetch = FetchType.EAGER)

    private MedicosEntity medicosEntity;

    @JoinColumn(name = "idPago", referencedColumnName = "idPago")
    @ManyToOne(fetch = FetchType.EAGER)

    private PagosEntity pagosEntity;

    @JoinColumn(name = "idEstatus", referencedColumnName = "idEstatus")
    @ManyToOne(fetch = FetchType.EAGER)

    private EstatusEntity estatusEntity;
}
