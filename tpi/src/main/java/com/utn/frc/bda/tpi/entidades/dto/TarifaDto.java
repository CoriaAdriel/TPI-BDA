package com.utn.frc.bda.tpi.entidades.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TarifaDto
{
    private Long id;
    private Integer tipoTarifa;
    private String definicion;
    private Integer diaSemana;
    private Integer diaMes;
    private Integer mes;
    private Integer anio;
    private Float montoFijoAlquiler;
    private Float montoMinutoFraccion;
    private Float montoKm;
    private Float montoHora;

}
