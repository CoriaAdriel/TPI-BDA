package com.utn.frc.bda.tpi.entidades;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    private Long id;
    @Column(name = "NOMBRE")
    private String nombre;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", shape = JsonFormat.Shape.STRING)
    @Column(name = "FECHA_HORA_CREACION")
    private LocalDateTime fechaHoraCreacion;
    @Column(name = "LATITUD")
    private Float latitud;
    @Column(name = "LONGITUD")
    private Float longitud;

}
