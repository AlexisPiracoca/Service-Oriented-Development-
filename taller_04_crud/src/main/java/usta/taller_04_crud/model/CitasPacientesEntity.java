package usta.taller_04_crud.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "citasPacientes")
@Getter
@Setter
public class CitasPacientesEntity implements Serializable {

        private static final long serialVersionUID = 1L;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "idCitaPaciente")
        private long idCitaPaciente;


        @JoinColumn(name = "idCita", referencedColumnName = "idCita")
        @ManyToOne(fetch = FetchType.EAGER)

        private CitasEntity citasEntity;

        @JoinColumn(name = "idPaciente", referencedColumnName = "idPaciente")
        @ManyToOne(fetch = FetchType.EAGER)

        private PacientesEntity pacientesEntity;

}
