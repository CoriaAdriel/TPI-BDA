package com.utn.frc.bda.tpi.services;

import com.utn.frc.bda.tpi.entidades.Tarifa;
import com.utn.frc.bda.tpi.entidades.dto.TarifaDto;
import com.utn.frc.bda.tpi.repositories.TarifasRepository;
import com.utn.frc.bda.tpi.services.mappers.dtomapperentity.DtoMapperTarifa;
import com.utn.frc.bda.tpi.services.mappers.entitymapperdto.TarifaMapperDto;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class TarifaServiceImpl implements TarifaService
{
    private final TarifasRepository tarifasRepository;
    private final DtoMapperTarifa dtoMapperTarifa;
    private final TarifaMapperDto tarifaMapperDto;

    public TarifaServiceImpl(TarifasRepository tarifasRepository, DtoMapperTarifa dtoMapperTarifa, TarifaMapperDto tarifaMapperDto)
    {
        this.tarifasRepository = tarifasRepository;
        this.dtoMapperTarifa = dtoMapperTarifa;
        this.tarifaMapperDto = tarifaMapperDto;
    }

    @Override
    public List<TarifaDto> getAll()
    {
        List<Tarifa> tarifas = this.tarifasRepository.findAll();
        return tarifas
                .stream()
                .map(tarifaMapperDto)
                .toList();
    }

    @Override
    public TarifaDto getById(Long id)
    {
        Optional<Tarifa> tarifa = this.tarifasRepository.findById(id);
        return tarifa.map(tarifaMapperDto).orElseThrow();
    }

    @Override
    public TarifaDto add(TarifaDto tarifaDto)
    {
        Optional<Tarifa> tarifa = Stream.of(tarifaDto).map(dtoMapperTarifa).findFirst();
        tarifa.ifPresent(tarifasRepository::save);
        return tarifa.map(tarifaMapperDto).orElseThrow();
    }

    @Override
    public TarifaDto update(TarifaDto tarifaDto)
    {
        Optional<Tarifa> tarifa = Stream.of(tarifaDto).map(dtoMapperTarifa).findFirst();
        tarifa.ifPresent(tarifasRepository::save);
        return tarifa.map(tarifaMapperDto).orElseThrow();
    }
    @Override
    public TarifaDto delete(Long id)
    {
        TarifaDto tarifaDto = this.getById(id);
        if(tarifaDto != null)
        {
            Optional<Tarifa> tarifa = Stream.of(tarifaDto).map(dtoMapperTarifa).findFirst();
            tarifa.ifPresent(tarifasRepository::delete);
        }
        return tarifaDto;
    }

}
