package com.utn.frc.bda.tpi.services.mappers.entitymapperdto;

import com.utn.frc.bda.tpi.entidades.Alquiler;
import com.utn.frc.bda.tpi.entidades.dto.AlquilerDto;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class AlquilerMapperDto implements Function<Alquiler, AlquilerDto>
{
    @Override
    public AlquilerDto apply(Alquiler alquiler)
    {
        return new AlquilerDto(
                alquiler.getId(),
                alquiler.getIdCliente(),
                alquiler.getEstado(),
                alquiler.getFechaHoraRetiro(),
                alquiler.getFechaHoraDevolucion(),
                alquiler.getMonto()
        );
    }
}
