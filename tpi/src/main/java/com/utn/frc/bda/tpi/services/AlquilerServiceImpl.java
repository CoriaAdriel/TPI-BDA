package com.utn.frc.bda.tpi.services;

import com.utn.frc.bda.tpi.entidades.Alquiler;
import com.utn.frc.bda.tpi.entidades.dto.AlquilerDto;
import com.utn.frc.bda.tpi.repositories.AlquilerRepository;
import com.utn.frc.bda.tpi.services.mappers.dtomapperentity.DtoMapperAlquiler;
import com.utn.frc.bda.tpi.services.mappers.entitymapperdto.AlquilerMapperDto;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class AlquilerServiceImpl implements AlquilerService
{
    private final AlquilerRepository alquilerRepository;
    private final DtoMapperAlquiler dtoMapperAlquiler;
    private final AlquilerMapperDto alquilerMapperDto;
    public AlquilerServiceImpl(AlquilerRepository alquilerRepository, DtoMapperAlquiler dtoMapperAlquiler, AlquilerMapperDto alquilerMapperDto)
    {
        this.alquilerRepository = alquilerRepository;
        this.dtoMapperAlquiler = dtoMapperAlquiler;
        this.alquilerMapperDto = alquilerMapperDto;
    }


    @Override
    public List<AlquilerDto> getAll()
    {
        List<Alquiler> alquileres = this.alquilerRepository.findAll();
        return alquileres
                .stream()
                .map(alquilerMapperDto)
                .toList();
    }

    @Override
    public AlquilerDto getById(Long id)
    {
        Optional<Alquiler> alquiler = this.alquilerRepository.findById(id);
        return alquiler.map(alquilerMapperDto).orElseThrow();
    }

    @Override
    public AlquilerDto add(AlquilerDto alquilerDto)
    {
        Optional<Alquiler> alquiler = Stream.of(alquilerDto).map(dtoMapperAlquiler).findFirst();
        alquiler.ifPresent(alquilerRepository::save);
        return alquiler.map(alquilerMapperDto).orElseThrow();
    }

    @Override
    public AlquilerDto update(AlquilerDto alquilerDto)
    {
        Optional<Alquiler> alquiler = Stream.of(alquilerDto).map(dtoMapperAlquiler).findFirst();
        alquiler.ifPresent(alquilerRepository::save);
        return alquiler.map(alquilerMapperDto).orElseThrow();
    }

    @Override
    public AlquilerDto delete(Long id)
    {
        AlquilerDto alquilerDto = this.getById(id);
        if(alquilerDto != null)
        {
            Optional<Alquiler> alquiler = Stream.of(alquilerDto).map(dtoMapperAlquiler).findFirst();
            alquiler.ifPresent(alquilerRepository::delete);
        }
        return alquilerDto;
    }
}
