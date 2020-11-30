package com.upc.tesis.bap.wsbap.repository;

import com.upc.tesis.bap.wsbap.entity.TmpDireccion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TmpDireccionRepository extends JpaRepository<TmpDireccion, Integer> {

    List<TmpDireccion> findByEstado(Integer estado);

}
