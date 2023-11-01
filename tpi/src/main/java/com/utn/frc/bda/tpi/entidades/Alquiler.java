//package com.utn.frc.bda.tpi.entidades;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity(name = "ALQUILERES")
//public class Alquiler
//{
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "ID")
//    private long id;
//    @Column(name = "ID_CLIENTE")
//    private String idCliente;
//    @Column(name = "ESTADO")
//    private int estado;
//    @OneToOne // ID: Estacion
//    @Column(name = "ESTACION_RETIRO")
//    private int estacionRetiro;
//    @OneToOne // ID: Estacion
//    @Column(name = "ESTACION_DEVOLUCION")
//    private int estacionDevolucion;
//    @Column(name = "FECHA_HORA_RETIRO")
//    private LocalDateTime fechaHoraRetiro;
//    @Column(name = "FECHA_HORA_DEVOLUCION")
//    private LocalDateTime fechaHoraDevolucion;
//    @Column(name = "MONTO")
//    private float monto;
//    @OneToOne
//    @Column(name = "ID_TARIFA")
//    private int id_tarifa;
//
//
//
//
//
//}
