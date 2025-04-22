package com.jdc.reservas.service.Implements;

import com.jdc.reservas.DTO.ReservaDTO;
import com.jdc.reservas.models.ReservaEntity;
import com.jdc.reservas.repository.ReservaRepository;
import com.jdc.reservas.service.IReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReservaServiceImplements implements IReservaService {
    @Autowired
    private ReservaRepository reservaRepository;
    @Override
    @Transactional(readOnly = true)
    public ReservaEntity findById(Long id) {
        return reservaRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public ReservaEntity save(ReservaDTO reservaDto) {
        ReservaEntity miReserva = new ReservaEntity();

        miReserva.setFechareserva(reservaDto.getFechareserva());
        miReserva.setEstado(reservaDto.getEstado());

         return reservaRepository.save(miReserva);

    }


    @Override
    @Transactional
    public List<ReservaEntity> findAll() {
        return reservaRepository.findAll();
    }

    @Override
    @Transactional
    public ReservaEntity update(ReservaEntity reservaEntity) {
        return null;
    }

    @Override
    @Transactional
    public ReservaEntity update(Long id, ReservaDTO reservaDTO) {
        ReservaEntity reservaExistente = reservaRepository.findById(id).orElse(null);

        if (reservaExistente == null) {
            return null; // O lanzar una excepción personalizada
        }

        // Actualizar solo los campos modificables
        reservaExistente.setFechareserva(reservaDTO.getFechareserva());
        reservaExistente.setEstado(reservaDTO.getEstado());
        //guardamos los datos actualizados del medico
        return reservaRepository.save(reservaExistente);
    }

    @Override
    @Transactional
    public void deleteByid(Long id) {
        reservaRepository.deleteById(id);

    }
}
