package com.jdc.reservas.DTO;

import java.util.Date;

public class ReservaDTO {
    private Date fechareserva;
    private String estado;

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
