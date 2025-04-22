package com.jdc.reservas.service;

import com.jdc.reservas.DTO.ReservaDTO;
import com.jdc.reservas.models.ReservaEntity;

import java.util.List;

public interface IReservaService {
    public ReservaEntity findById(Long id);
    public ReservaEntity save(ReservaDTO reservaDto);
    public List<ReservaEntity> findAll();
    public ReservaEntity update(ReservaEntity reservaEntity);
    public ReservaEntity update(Long id, ReservaDTO medicoDTO);
    public void deleteByid(Long id);

}
