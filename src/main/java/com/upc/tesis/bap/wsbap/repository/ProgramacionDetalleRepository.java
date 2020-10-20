package com.upc.tesis.bap.wsbap.repository;

import com.upc.tesis.bap.wsbap.entity.ProgramacionDetalle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProgramacionDetalleRepository extends JpaRepository<ProgramacionDetalle, Integer> {

    List<ProgramacionDetalle> findProgramacionDetalleByProgramacionDonacionId(Integer id);

}
