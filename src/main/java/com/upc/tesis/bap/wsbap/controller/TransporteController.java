package com.upc.tesis.bap.wsbap.controller;

import com.upc.tesis.bap.wsbap.entity.Transporte;
import com.upc.tesis.bap.wsbap.service.TransporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TransporteController {

    @Autowired
    TransporteService transporteService;

    @GetMapping("transportes")
    public List<Transporte> obtenerTransportes(){
        return transporteService.obtenerTransportes();
    }

}
