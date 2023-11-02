package com.utn.frc.bda.tpi.repositories;

import com.utn.frc.bda.tpi.entidades.Tarifa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarifasRepository extends JpaRepository<Tarifa, Long>
{

}
