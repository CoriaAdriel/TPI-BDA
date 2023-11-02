package com.utn.frc.bda.tpi.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "TARIFAS")
public class Tarifa
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "TIPO_TARIFA")
    private Integer tipoTarifa;
    @Column(name = "DEFINICION")
    private String definicion;
    @Column(name = "DIA_SEMANA")
    private Integer diaSemana;
    @Column(name = "DIA_MES")
    private Integer diaMes;
    @Column(name = "MES")
    private Integer mes;
    @Column(name = "ANIO")
    private Integer anio;
    @Column(name = "MONTO_FIJO_ALQUILER")
    private Float montoFijoAlquiler;
    @Column(name = "MONTO_MINUTO_FRACCION")
    private Float montoMinutoFraccion;
    @Column(name = "MONTO_KM")
    private Float montoKm;
    @Column(name = "MONTO_HORA")
    private Float montoHora;

}
