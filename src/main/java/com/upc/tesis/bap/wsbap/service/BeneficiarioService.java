package com.upc.tesis.bap.wsbap.service;

import com.upc.tesis.bap.wsbap.entity.Beneficiario;
import com.upc.tesis.bap.wsbap.repository.BeneficiarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BeneficiarioService {

    @Autowired
    private BeneficiarioRepository beneficiarioRepository;

    public List<Beneficiario> obtenerBeneficiarios(){
        return beneficiarioRepository.findByEstado(1);
    }

}
