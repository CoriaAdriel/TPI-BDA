package com.utn.frc.bda.tpi.controllers;

import com.utn.frc.bda.tpi.entidades.dto.TarifaDto;
import com.utn.frc.bda.tpi.services.TarifaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tarifa")
public class TarifaController
{
    @Autowired
    private TarifaService tarifaService;

    @GetMapping
    public ResponseEntity<List<TarifaDto>> getAll()
    {
        List<TarifaDto> tarifaDtos = this.tarifaService.getAll();
        return ResponseEntity.ok(tarifaDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TarifaDto> getById(@PathVariable("id") long id)
    {
        TarifaDto tarifaDto = this.tarifaService.getById(id);
        return ResponseEntity.ok(tarifaDto);
    }

    @PostMapping
    public ResponseEntity<TarifaDto> add(@RequestBody TarifaDto tarifaDto)
    {
        TarifaDto dtoTarifa = this.tarifaService.add(tarifaDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(dtoTarifa);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TarifaDto> update(@PathVariable("id") long id, @RequestBody TarifaDto tarifaDto)
    {
        TarifaDto dtoTarifa = this.tarifaService.getById(id);
        if(dtoTarifa != null)
        {
            dtoTarifa.setId(tarifaDto.getId());
            dtoTarifa.setTipoTarifa(tarifaDto.getTipoTarifa());
            dtoTarifa.setDefinicion(tarifaDto.getDefinicion());
            dtoTarifa.setDiaSemana(tarifaDto.getDiaSemana());
            dtoTarifa.setDiaMes(tarifaDto.getDiaMes());
            dtoTarifa.setMes(tarifaDto.getMes());
            dtoTarifa.setAnio(tarifaDto.getAnio());
            dtoTarifa.setMontoFijoAlquiler(tarifaDto.getMontoFijoAlquiler());
            dtoTarifa.setMontoMinutoFraccion(tarifaDto.getMontoMinutoFraccion());
            dtoTarifa.setMontoKm(tarifaDto.getMontoKm());
            dtoTarifa.setMontoHora(tarifaDto.getMontoHora());

            this.tarifaService.update(dtoTarifa);
            return new ResponseEntity<>(dtoTarifa, HttpStatus.OK);
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
            this.tarifaService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
