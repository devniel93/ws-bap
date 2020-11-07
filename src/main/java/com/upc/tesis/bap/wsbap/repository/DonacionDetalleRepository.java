package com.upc.tesis.bap.wsbap.repository;

import com.upc.tesis.bap.wsbap.entity.DonacionDetalle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DonacionDetalleRepository extends JpaRepository<DonacionDetalle, Integer> {

    List<DonacionDetalle> findDonacionDetalleByDonacionId(Integer id);
    List<DonacionDetalle> findByEstadoAndDonacion_DonadorIdOrderByIdDesc(Integer estado, Integer donadorId);
    List<DonacionDetalle> findByEstadoAndDonacion_DonadorIdAndDonacion_EstadoDonacionOrderByIdDesc(Integer estado, Integer donadorId, Integer estadoDonacion);
    List<DonacionDetalle> findByEstadoAndDonacion_DonadorIdAndDonacion_EstadoDonacionIsInOrderByIdDesc(Integer estado, Integer donadorId, List<Integer> estadoDonacion);

}
