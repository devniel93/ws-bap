package com.upc.tesis.bap.wsbap.service;

import com.upc.tesis.bap.wsbap.entity.Beneficiario;
import com.upc.tesis.bap.wsbap.entity.TmpDireccion;
import com.upc.tesis.bap.wsbap.repository.BeneficiarioRepository;
import com.upc.tesis.bap.wsbap.repository.TmpDireccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BeneficiarioService {

    @Autowired
    private BeneficiarioRepository beneficiarioRepository;

    @Autowired
    private TmpDireccionRepository tmpDireccionRepository;

    public List<Beneficiario> obtenerBeneficiarios(){
        return beneficiarioRepository.findByEstado(1);
    }

    public List<TmpDireccion> obtenerBeneficiariosDirecciones(){
        List<Beneficiario> listBenef = beneficiarioRepository.findByEstado(1);
        List<TmpDireccion> listDirecciones = tmpDireccionRepository.findByEstado(1);
        int cont = 9999;
        if(listDirecciones != null && listDirecciones.size() > 0){
            for(TmpDireccion dir : listDirecciones) {
                dir.setId(cont);
                cont = cont + 1;
            }
        }

        TmpDireccion dir;
        for (Beneficiario b : listBenef) {
            dir = new TmpDireccion();
            dir.setId(b.getId());
            dir.setRazonSocial(b.getRazonSocial());
            dir.setDireccion(b.getDireccion());
            dir.setDirLatGps(b.getDirLatGps());
            dir.setDirLonGps(b.getDirLonGps());
            listDirecciones.add(dir);
        }
        return listDirecciones;
    }

    public TmpDireccion registrarDireccion(TmpDireccion tmpDireccion){
        return tmpDireccionRepository.findById(tmpDireccion.getId()).map(tmpExistente -> {
            tmpExistente.setDirLonGps(tmpDireccion.getDirLonGps());
            tmpExistente.setDirLatGps(tmpDireccion.getDirLatGps());
            tmpExistente.setRazonSocial(tmpDireccion.getRazonSocial());
            tmpExistente.setDireccion(tmpDireccion.getDireccion());
            return tmpDireccionRepository.save(tmpExistente);
        }).orElseGet(() -> tmpDireccionRepository.save(tmpDireccion));
    }

}
