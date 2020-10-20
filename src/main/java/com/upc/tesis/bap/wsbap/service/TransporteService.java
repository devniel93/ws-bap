package com.upc.tesis.bap.wsbap.service;

import com.upc.tesis.bap.wsbap.entity.Transporte;
import com.upc.tesis.bap.wsbap.repository.TransporteRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransporteService {

    @Autowired
    private TransporteRespository transporteRespository;

    public List<Transporte> obtenerTransportes() {
        return transporteRespository.findAll();
    }

}
