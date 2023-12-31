package com.utn.frc.bda.tpi.repositories;

import com.utn.frc.bda.tpi.entidades.Alquiler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlquilerRepository extends JpaRepository<Alquiler, Long>
{

}
