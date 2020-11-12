package com.upc.tesis.bap.wsbap.repository;

import com.upc.tesis.bap.wsbap.entity.Beneficiario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BeneficiarioRepository extends JpaRepository<Beneficiario, Integer> {

    List<Beneficiario> findByEstado(Integer estado);

}
