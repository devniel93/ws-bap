package com.upc.tesis.bap.wsbap.service;

import com.upc.tesis.bap.wsbap.entity.Almacen;
import com.upc.tesis.bap.wsbap.repository.AlmacenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlmacenService {

    @Autowired
    AlmacenRepository almacenRepository;

    public List<Almacen> obtenerAlmacenes() {
        return almacenRepository.findAll();
    }

}
