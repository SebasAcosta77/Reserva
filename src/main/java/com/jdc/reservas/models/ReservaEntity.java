package com.jdc.reservas.models;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;


import java.io.Serial;
import java.util.Date;


@Entity
@Table(name = "reservas")
public class ReservaEntity {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idreserva")
    private Long idreserva;


    @Column(name = "fechareserva")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date fechareserva;


    @Column(name = "estado", length = 30)
    private String estado;

    public Long getIdreserva() {
        return idreserva;
    }

    public void setIdreserva(Long idreserva) {
        this.idreserva = idreserva;
    }

    public Date getFechareserva() {
        return fechareserva;
    }

    public void setFechareserva(Date fechareserva) {
        this.fechareserva = fechareserva;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
