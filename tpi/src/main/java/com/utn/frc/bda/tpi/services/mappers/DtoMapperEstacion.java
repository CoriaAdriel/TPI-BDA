package com.utn.frc.bda.tpi.services.mappers;

import com.utn.frc.bda.tpi.entidades.Estacion;
import com.utn.frc.bda.tpi.entidades.dto.EstacionDto;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class DtoMapperEstacion implements Function<EstacionDto, Estacion>
{

    @Override
    public Estacion apply(EstacionDto estacionDto)
    {
        Estacion estacion = new Estacion();
        estacion.setId(estacionDto.getId());
        estacion.setNombre(estacionDto.getNombre());
        estacion.setFechaHoraCreacion(estacionDto.getFechaHoraCreacion());
        estacion.setLatitud(estacionDto.getLatitud());
        estacion.setLongitud(estacionDto.getLongitud());

        return estacion;

    }
}

