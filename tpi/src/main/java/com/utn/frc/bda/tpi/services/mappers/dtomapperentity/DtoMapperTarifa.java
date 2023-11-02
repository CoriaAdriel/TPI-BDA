package com.utn.frc.bda.tpi.services.mappers.dtomapperentity;

import com.utn.frc.bda.tpi.entidades.Tarifa;
import com.utn.frc.bda.tpi.entidades.dto.TarifaDto;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class DtoMapperTarifa implements Function<TarifaDto, Tarifa>
{

    @Override
    public Tarifa apply(TarifaDto tarifaDto)
    {
        return new Tarifa(
                tarifaDto.getId(),
                tarifaDto.getTipoTarifa(),
                tarifaDto.getDefinicion(),
                tarifaDto.getDiaSemana(),
                tarifaDto.getDiaMes(),
                tarifaDto.getMes(),
                tarifaDto.getAnio(),
                tarifaDto.getMontoFijoAlquiler(),
                tarifaDto.getMontoMinutoFraccion(),
                tarifaDto.getMontoKm(),
                tarifaDto.getMontoHora()
        );
    }
}
