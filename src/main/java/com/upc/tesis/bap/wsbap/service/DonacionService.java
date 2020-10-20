package com.upc.tesis.bap.wsbap.service;

import com.upc.tesis.bap.wsbap.entity.Donacion;
import com.upc.tesis.bap.wsbap.entity.DonacionDetalle;
import com.upc.tesis.bap.wsbap.repository.DonacionDetalleRepository;
import com.upc.tesis.bap.wsbap.repository.DonacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonacionService {

    @Autowired
    private DonacionRepository donacionRepository;

    @Autowired
    private DonacionDetalleRepository donacionDetalleRepository;

    /** DONACION CABECERA*/
    public Donacion registrarDonacion(Donacion donacion) {
        return donacionRepository.save(donacion);
    }

    public List<Donacion> obtenerDonaciones() {
        return donacionRepository.findAll();
    }

    public Donacion obtenerById(Integer id) {
        return donacionRepository.findById(id).orElse(null);
    }

    public Donacion actualizarDonacion(Donacion donacion, Integer id) {
        return donacionRepository.findById(id).map(donacionExistente -> {
            donacionExistente.setDireccion(donacion.getDireccion());
            donacionExistente.setLatitudGps(donacion.getLatitudGps());
            donacionExistente.setLongitudGps(donacion.getLongitudGps());
            return donacionRepository.save(donacionExistente);
        }).orElseGet(() -> {
            donacion.setId(id);
            return donacionRepository.save(donacion);
        });
    }

    public String eliminarDonacion(Integer id) {
        donacionRepository.deleteById(id);
        return "Donacion eliminada " + id;
    }

    /** DONACION DETALLE*/

    public DonacionDetalle registrarDonacionDetalle(DonacionDetalle donacionDetalle){
        return donacionDetalleRepository.save(donacionDetalle);
    }

    public List<DonacionDetalle> obtenerDetalleById(Integer id) {
        return donacionDetalleRepository.findDonacionDetalleByDonacionId(id);
    }

    public DonacionDetalle obtenerDonacionDetalleById(Integer id) {
        return donacionDetalleRepository.findById(id).orElse(null);
    }

    public DonacionDetalle actualizarDonacionDetalle(DonacionDetalle donacionDetalle, Integer id) {
        return donacionDetalleRepository.findById(id).map(donacionDetalleExistente -> {
            donacionDetalleExistente.setProducto(donacionDetalle.getProducto());
            donacionDetalleExistente.setCantidad(donacionDetalle.getCantidad());
            donacionDetalleExistente.setPeso(donacionDetalle.getPeso());
            donacionDetalleExistente.setUnidadMedida(donacionDetalle.getUnidadMedida());
            donacionDetalleExistente.setFechaVencimiento(donacionDetalle.getFechaVencimiento());
            return donacionDetalleRepository.save(donacionDetalleExistente);
        }).orElseGet(() -> {
            donacionDetalle.setId(id);
            return donacionDetalleRepository.save(donacionDetalle);
        });
    }

    public String eliminarDonacionDetalle(Integer id) {
        donacionDetalleRepository.deleteById(id);
        return "Donacion detalle eliminada " + id;
    }

}
