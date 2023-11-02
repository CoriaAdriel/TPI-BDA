package com.utn.frc.bda.tpi.controllers;

import com.utn.frc.bda.tpi.entidades.dto.AlquilerDto;
import com.utn.frc.bda.tpi.services.AlquilerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alquiler")
public class AlquilerController
{
    @Autowired
    private AlquilerService alquilerService;

    @GetMapping
    public ResponseEntity<List<AlquilerDto>> getAll()
    {
        List<AlquilerDto> alquilerDtos = this.alquilerService.getAll();
        return ResponseEntity.ok(alquilerDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlquilerDto> getById(@PathVariable("id") long id)
    {
        AlquilerDto alquilerDto = this.alquilerService.getById(id);
        return ResponseEntity.ok(alquilerDto);
    }
    @PostMapping
    public ResponseEntity<AlquilerDto> add(@RequestBody AlquilerDto alquilerDto)
    {
        AlquilerDto dtoAlquiler = this.alquilerService.add(alquilerDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(dtoAlquiler);
    }
    @PutMapping("/{id}")
    public ResponseEntity<AlquilerDto> update(@PathVariable("id") long id, @RequestBody AlquilerDto alquilerDto)
    {
        AlquilerDto dtoAlquiler = this.alquilerService.getById(id);
        if(dtoAlquiler != null)
        {
            dtoAlquiler.setId(alquilerDto.getId());
            dtoAlquiler.setIdCliente(alquilerDto.getIdCliente());
            dtoAlquiler.setEstado(alquilerDto.getEstado());
            dtoAlquiler.setFechaHoraRetiro(alquilerDto.getFechaHoraRetiro());
            dtoAlquiler.setFechaHoraDevolucion(alquilerDto.getFechaHoraDevolucion());
            dtoAlquiler.setMonto(alquilerDto.getMonto());

            this.alquilerService.update(dtoAlquiler);
            return new ResponseEntity<>(dtoAlquiler, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") long id)
    {
        try
        {
            this.alquilerService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}

