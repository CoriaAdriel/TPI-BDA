package com.utn.frc.bda.tpi.services.mappers.entitymapperdto;

import com.utn.frc.bda.tpi.entidades.Tarifa;
import com.utn.frc.bda.tpi.entidades.dto.TarifaDto;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class TarifaMapperDto implements Function<Tarifa, TarifaDto>
{

    @Override
    public TarifaDto apply(Tarifa tarifa)
    {
        return new TarifaDto(
                tarifa.getId(),
                tarifa.getTipoTarifa(),
                tarifa.getDefinicion(),
                tarifa.getDiaSemana(),
                tarifa.getDiaMes(),
                tarifa.getMes(),
                tarifa.getAnio(),
                tarifa.getMontoFijoAlquiler(),
                tarifa.getMontoMinutoFraccion(),
                tarifa.getMontoKm(),
                tarifa.getMontoHora());
    }
}
