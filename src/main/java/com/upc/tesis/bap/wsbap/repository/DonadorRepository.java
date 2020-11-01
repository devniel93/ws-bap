package com.upc.tesis.bap.wsbap.repository;

import com.upc.tesis.bap.wsbap.entity.Donador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonadorRepository extends JpaRepository<Donador, Integer> {

    Donador findByUsuarioId(Integer usuarioId);

}
