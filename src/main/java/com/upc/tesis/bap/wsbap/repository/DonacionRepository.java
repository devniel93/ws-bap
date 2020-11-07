package com.upc.tesis.bap.wsbap.repository;

import com.upc.tesis.bap.wsbap.entity.Donacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DonacionRepository extends JpaRepository<Donacion, Integer> {

    List<Donacion> findByEstadoDonacionAndEstadoAndDonadorId(Integer estadoDonacion, Integer estado, Integer donadorId);
    List<Donacion> findByEstadoAndDonadorId(Integer estado, Integer donadorId);
}
