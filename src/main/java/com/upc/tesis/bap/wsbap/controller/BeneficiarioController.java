package com.upc.tesis.bap.wsbap.controller;

import com.upc.tesis.bap.wsbap.entity.Beneficiario;
import com.upc.tesis.bap.wsbap.service.BeneficiarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BeneficiarioController {

    @Autowired
    private BeneficiarioService beneficiarioService;

    @GetMapping("beneficiarios")
    public List<Beneficiario> obtenerBeneficiarios(){
        return beneficiarioService.obtenerBeneficiarios();
    }

}
