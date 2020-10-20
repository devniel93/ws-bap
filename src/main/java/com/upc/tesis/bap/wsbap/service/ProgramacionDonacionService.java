package com.upc.tesis.bap.wsbap.service;

import com.upc.tesis.bap.wsbap.entity.ProgramacionDetalle;
import com.upc.tesis.bap.wsbap.entity.ProgramacionDonacion;
import com.upc.tesis.bap.wsbap.repository.ProgramacionDetalleRepository;
import com.upc.tesis.bap.wsbap.repository.ProgramacionDonacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgramacionDonacionService {

    @Autowired
    ProgramacionDonacionRepository programacionDonacionRepository;

    @Autowired
    ProgramacionDetalleRepository programacionDetalleRepository;

    /** PROGRAMACION DONACION CABECERA*/

    public ProgramacionDonacion registrarProgramacionDonacion(ProgramacionDonacion programacionDonacion) {
        return programacionDonacionRepository.save(programacionDonacion);
    }

    public List<ProgramacionDonacion> obtenerProgramaciones(){
        return programacionDonacionRepository.findAll();
    }

    public ProgramacionDonacion obtenerById(Integer id) {
        return programacionDonacionRepository.findById(id).orElse(null);
    }

    public ProgramacionDonacion actualizarProgramacionDonacion(ProgramacionDonacion programacionDonacion, Integer id) {
        return programacionDonacionRepository.findById(id).map(programacionExistente -> {
            programacionExistente.setTransporte(programacionDonacion.getTransporte());
            programacionExistente.setAlmacen(programacionDonacion.getAlmacen());
            programacionExistente.setTipoProgramacion(programacionDonacion.getTipoProgramacion());
            programacionExistente.setFechaProgramacion(programacionDonacion.getFechaProgramacion());
            programacionExistente.setEstado(programacionDonacion.getEstado());
            return programacionDonacionRepository.save(programacionExistente);
        }).orElseGet(() -> {
            programacionDonacion.setId(id);
            return programacionDonacionRepository.save(programacionDonacion);
        });
    }

    public String eliminarProgramacionDonacion(Integer id) {
        programacionDonacionRepository.deleteById(id);
        return "Programacion de donacion eliminada " + id;
    }

    /** PROGRAMACION DONACION DETALLE */

    public ProgramacionDetalle registrarProgramacionDetalle(ProgramacionDetalle programacionDetalle) {
        return programacionDetalleRepository.save(programacionDetalle);
    }

    public List<ProgramacionDetalle> obtenerDetalleById(Integer id) {
        return programacionDetalleRepository.findProgramacionDetalleByProgramacionDonacionId(id);
    }

    public ProgramacionDetalle obtenerProgramacionDetalleById(Integer id) {
        return programacionDetalleRepository.findById(id).orElse(null);
    }

    public ProgramacionDetalle actualizarProgramacionDetalle(ProgramacionDetalle programacionDetalle, Integer id) {
        return programacionDetalleRepository.findById(id).map(programacionDetalleExistente -> {
            programacionDetalleExistente.setProducto(programacionDetalle.getProducto());
            programacionDetalleExistente.setBeneficiario(programacionDetalle.getBeneficiario());
            programacionDetalleExistente.setCantidad(programacionDetalle.getCantidad());
            programacionDetalleExistente.setUnidadMedida(programacionDetalle.getUnidadMedida());
            programacionDetalleExistente.setPeso(programacionDetalle.getPeso());
            programacionDetalleExistente.setEstado(programacionDetalle.getEstado());
            return programacionDetalleRepository.save(programacionDetalleExistente);
        }).orElseGet(() -> {
            programacionDetalle.setId(id);
            return programacionDetalleRepository.save(programacionDetalle);
        });
    }

    public String eliminarProgramacionDetalle(Integer id) {
        programacionDetalleRepository.deleteById(id);
        return "Programacion Donacion Detalle eliminada " + id;
    }

}
