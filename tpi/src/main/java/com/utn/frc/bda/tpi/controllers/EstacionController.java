package com.utn.frc.bda.tpi.controllers;


import com.utn.frc.bda.tpi.entidades.dto.EstacionDto;
import com.utn.frc.bda.tpi.services.EstacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estacion") // http://localhost:8080/api/estacion - Swagger: localhost:8080/swagger-ui/index.html
public class EstacionController
{
    @Autowired
    private EstacionService estacionService;

    @GetMapping
    public ResponseEntity<List<EstacionDto>> getAll()
    {
        List<EstacionDto> estacionDtos = this.estacionService.getAll();
        return ResponseEntity.ok(estacionDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstacionDto> update(@PathVariable("id") long id)
    {
        EstacionDto estacionDto = this.estacionService.getById(id);
        return ResponseEntity.ok(estacionDto);
    }

    @PostMapping
    public ResponseEntity<EstacionDto> add(@RequestBody EstacionDto estacionDto)
    {
        EstacionDto dtoEstacion = this.estacionService.add(estacionDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(dtoEstacion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstacionDto> update(@PathVariable("id") long id, @RequestBody EstacionDto estacionDto)
    {
        EstacionDto dtoEstacion = this.estacionService.getById(id);
        if(dtoEstacion != null)
        {
            dtoEstacion.setNombre(estacionDto.getNombre());
            dtoEstacion.setFechaHoraCreacion(estacionDto.getFechaHoraCreacion());
            dtoEstacion.setLatitud(estacionDto.getLatitud());
            dtoEstacion.setLongitud(estacionDto.getLongitud());

            this.estacionService.update(dtoEstacion);
            return new ResponseEntity<>(dtoEstacion, HttpStatus.OK);
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
            this.estacionService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
