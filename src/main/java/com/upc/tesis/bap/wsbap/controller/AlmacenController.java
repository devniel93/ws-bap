package com.upc.tesis.bap.wsbap.controller;

import com.upc.tesis.bap.wsbap.entity.Almacen;
import com.upc.tesis.bap.wsbap.service.AlmacenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AlmacenController {

    @Autowired
    AlmacenService almacenService;

    @GetMapping("almacenes")
    public List<Almacen> obtenerAlmacenes(){
        return almacenService.obtenerAlmacenes();
    }

}
