package com.utn.frc.bda.tpi.entidades.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstacionDto
{
    private long id;
    private String nombre;
    private String fechaHoraCreacion; // LocalDateTime
    private float latitud;
    private float longitud;

}
