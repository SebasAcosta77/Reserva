package com.jdc.reservas.rest;

import com.jdc.reservas.DTO.ReservaDTO;
import com.jdc.reservas.models.ReservaEntity;
import com.jdc.reservas.service.IReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reserva")
public class ReservaRest {
    @Autowired
    private IReservaService reservaService;

    @PostMapping("/crear")
    public ResponseEntity<ReservaEntity> create(
            @Validated @RequestBody ReservaDTO reservaDTO
    ){
        try{
            ReservaEntity miReserva = reservaService.save(reservaDTO);
            ResponseEntity.status(200);
            return ResponseEntity.ok(miReserva);
        } catch (Exception e) {
            System.out.println("Error al crear el medico: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
    @GetMapping("list")
    public ResponseEntity<List<ReservaEntity>> list() {
        return ResponseEntity.ok(reservaService.findAll());
    }

    @PutMapping("actualizar/{id}")
    public ResponseEntity<ReservaEntity> edit(
            @Validated @RequestBody ReservaDTO reservaRequest, @PathVariable("id") Long id
    ) {
        ReservaEntity updatedReserva = reservaService.update(id, reservaRequest);
        if (updatedReserva == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedReserva);
    }

    @DeleteMapping("/deleteBy/{id}")
    public ResponseEntity<String> deleteByi(@PathVariable("id") Long id) {
        reservaService.deleteByid(id);
        return ResponseEntity.ok("Se ha eliminado la reserva: ");
    }




}

