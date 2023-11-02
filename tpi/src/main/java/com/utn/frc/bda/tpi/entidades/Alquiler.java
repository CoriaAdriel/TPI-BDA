package com.utn.frc.bda.tpi.entidades;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "ALQUILERES")
public class Alquiler
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;


    @Column(name = "ID_CLIENTE")
    private String idCliente;


    @Column(name = "ESTADO")
    private Integer estado;


    @OneToOne
    @JoinColumn(name = "ESTACION_RETIRO")
    private Estacion estacionRetiro;


    @OneToOne
    @JoinColumn(name = "ESTACION_DEVOLUCION")
    private Estacion estacionDevolucion;


    @Column(name = "FECHA_HORA_RETIRO")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", shape = JsonFormat.Shape.STRING)
    private LocalDateTime fechaHoraRetiro;


    @Column(name = "FECHA_HORA_DEVOLUCION")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", shape = JsonFormat.Shape.STRING)
    private LocalDateTime fechaHoraDevolucion;


    @Column(name = "MONTO")
    private Float monto;


    @OneToOne
    @JoinColumn(name = "ID_TARIFA")
    private Tarifa id_tarifa;

}
