package com.utn.frc.bda.tpi.services;

import com.utn.frc.bda.tpi.entidades.Estacion;
import com.utn.frc.bda.tpi.entidades.dto.EstacionDto;
import com.utn.frc.bda.tpi.repositories.EstacionRepository;
import com.utn.frc.bda.tpi.services.mappers.dtomapperentity.DtoMapperEstacion;
import com.utn.frc.bda.tpi.services.mappers.entitymapperdto.EstacionMapperDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class EstacionServiceImpl implements EstacionService
{

    private final EstacionRepository estacionRepository;
    private final EstacionMapperDto estacionMapperDto;
    private final DtoMapperEstacion dtoMapperEstacion;

    public EstacionServiceImpl(EstacionRepository estacionRepository, EstacionMapperDto estacionMapperDto, DtoMapperEstacion dtoMapperEstacion)
    {
        this.estacionRepository = estacionRepository;
        this.estacionMapperDto = estacionMapperDto;
        this.dtoMapperEstacion = dtoMapperEstacion;
    }


    @Override
    public List<EstacionDto> getAll()
    {
        List<Estacion> estaciones = this.estacionRepository.findAll();
        return estaciones
                .stream()
                .map(estacionMapperDto)
                .toList();
    }

    @Override
    public EstacionDto getById(Long id)
    {
        Optional<Estacion> estacion = this.estacionRepository.findById(id);
        return estacion.map(estacionMapperDto).orElseThrow();
    }

    @Override
    public EstacionDto add(EstacionDto estacionDto)
    {
        Optional<Estacion> estacion = Stream.of(estacionDto).map(dtoMapperEstacion).findFirst();
        estacion.ifPresent(estacionRepository::save);
        return estacion.map(estacionMapperDto).orElseThrow();
    }

    @Override
    public EstacionDto update(EstacionDto estacionDto)
    {
        Optional<Estacion> estacion = Stream.of(estacionDto).map(dtoMapperEstacion).findFirst();
        estacion.ifPresent(estacionRepository::save);
        return estacion.map(estacionMapperDto).orElseThrow();
    }
    @Override
    public EstacionDto delete(Long id)
    {
        EstacionDto estacionDto = this.getById(id);
        if(estacionDto != null)
        {
            Optional<Estacion> estacion = Stream.of(estacionDto).map(dtoMapperEstacion).findFirst();
            estacion.ifPresent(estacionRepository::delete);
        }
        return estacionDto;
    }


}
