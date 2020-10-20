package com.upc.tesis.bap.wsbap.repository;

import com.upc.tesis.bap.wsbap.entity.DonacionDetalle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DonacionDetalleRepository extends JpaRepository<DonacionDetalle, Integer> {

    List<DonacionDetalle> findDonacionDetalleByDonacionId(Integer id);
}
