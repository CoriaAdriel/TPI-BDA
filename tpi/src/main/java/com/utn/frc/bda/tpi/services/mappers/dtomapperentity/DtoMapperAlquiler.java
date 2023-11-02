package com.utn.frc.bda.tpi.services.mappers.dtomapperentity;

import com.utn.frc.bda.tpi.entidades.Alquiler;
import com.utn.frc.bda.tpi.entidades.dto.AlquilerDto;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class DtoMapperAlquiler implements Function<AlquilerDto, Alquiler>
{

    @Override
    public Alquiler apply(AlquilerDto alquilerDto)
    {
//        return new Alquiler(
//                alquilerDto.getId(),
//                alquilerDto.getIdCliente(),
//                alquilerDto.getEstado(),
//                null,
//                null,
//                alquilerDto.getFechaHoraRetiro(),
//                alquilerDto.getFechaHoraDevolucion(),
//                alquilerDto.getMonto(),
//                null
//        );
        Alquiler alquiler = new Alquiler();
        alquiler.setId(alquiler.getId());
        alquiler.setIdCliente(alquilerDto.getIdCliente());
        alquiler.setEstado(alquilerDto.getEstado());
        alquiler.setFechaHoraRetiro(alquiler.getFechaHoraRetiro());
        alquiler.setFechaHoraDevolucion(alquilerDto.getFechaHoraDevolucion());
        alquiler.setMonto(alquilerDto.getMonto());
        return alquiler;
    }
}
