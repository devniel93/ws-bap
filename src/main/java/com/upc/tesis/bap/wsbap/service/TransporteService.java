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
        List<Transporte> transportes = transporteRespository.findAll();
        if(transportes != null && transportes.size() > 0) {
            for(int i=0; i<transportes.size(); i++) {
                transportes.get(i).setModelo(transportes.get(i).getPlaca() + " / " + transportes.get(i).getModelo());
            }
        }
        return transportes;
    }

}
