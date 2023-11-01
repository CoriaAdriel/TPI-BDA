package com.utn.frc.bda.tpi.repositories;

import com.utn.frc.bda.tpi.entidades.Estacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstacionRepository extends JpaRepository<Estacion, Long>
{

}
