package com.upc.tesis.bap.wsbap.controller;

import com.upc.tesis.bap.wsbap.entity.Beneficiario;
import com.upc.tesis.bap.wsbap.entity.DonacionDetalle;
import com.upc.tesis.bap.wsbap.entity.TmpDireccion;
import com.upc.tesis.bap.wsbap.service.BeneficiarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @GetMapping("beneficiarios/direcciones")
    public List<TmpDireccion> obtenerBeneficiariosDirecciones(){
        return beneficiarioService.obtenerBeneficiariosDirecciones();
    }

    @PostMapping("beneficiarios/direcciones")
    public TmpDireccion registrarBeneficiarioDireccion(@RequestBody TmpDireccion tmpDireccion){
        return beneficiarioService.registrarDireccion(tmpDireccion);
    }

}
