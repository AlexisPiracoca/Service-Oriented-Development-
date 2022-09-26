package usta.taller_04_crud.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "pacientes")
@Getter
@Setter
public class PacientesEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPaciente")
    private long idPaciente;

    @NotNull
    @Column(name = "nombres",length = 50)
    private String nombres;

    @NotNull
    @Column(name = "primerApellido",length = 15)
    private String primerApellido;

    @NotNull
    @Column(name = "segundoApellido",length = 15)
    private String segundoApellido;

    @NotNull
    @Column(name = "documento",length = 10, unique = true)
    private String documento;

    @NotNull
    @Column(name = "fechaNacimiento")
    @DateTimeFormat(pattern = "yyyy-mmm-dd")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;

    @NotNull
    @Column(name = "medicamentos",length = 100)
    private String medicamentos;

    @NotNull
    @Column(name = "alergias",length = 100)
    private String alergias;

    @OneToOne
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")
    private UsuariosEntity usuarios;
}
