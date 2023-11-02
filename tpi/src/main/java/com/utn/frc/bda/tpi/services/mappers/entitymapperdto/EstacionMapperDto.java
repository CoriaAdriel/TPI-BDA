package com.utn.frc.bda.tpi.services.mappers.entitymapperdto;

import com.utn.frc.bda.tpi.entidades.Estacion;
import com.utn.frc.bda.tpi.entidades.dto.EstacionDto;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class EstacionMapperDto implements Function<Estacion, EstacionDto>
{

    @Override
    public EstacionDto apply(Estacion estacion)
    {
        EstacionDto estacionDto = new EstacionDto();
        estacionDto.setId(estacion.getId());
        estacionDto.setNombre(estacion.getNombre());
        estacionDto.setFechaHoraCreacion(estacion.getFechaHoraCreacion());
        estacionDto.setLatitud(estacion.getLatitud());
        estacionDto.setLongitud(estacion.getLongitud());

        return estacionDto;

    }
}
