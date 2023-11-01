package com.utn.frc.bda.tpi.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "ESTACIONES")
public class Estacion
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "FECHA_HORA_CREACION")
    private String fechaHoraCreacion; // LocalDateTime
    @Column(name = "LATITUD")
    private float latitud;
    @Column(name = "LONGITUD")
    private float longitud;

}
