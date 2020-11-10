package com.upc.tesis.bap.wsbap.service;

import com.upc.tesis.bap.wsbap.entity.Donacion;
import com.upc.tesis.bap.wsbap.entity.DonacionDetalle;
import com.upc.tesis.bap.wsbap.repository.DonacionDetalleRepository;
import com.upc.tesis.bap.wsbap.repository.DonacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class DonacionService {

    @Autowired
    private DonacionRepository donacionRepository;

    @Autowired
    private DonacionDetalleRepository donacionDetalleRepository;

    /**
     * DONACION CABECERA
     */
    public Donacion registrarDonacion(Donacion donacion) {
        return donacionRepository.save(donacion);
    }

    public List<Donacion> obtenerDonaciones() {
        return donacionRepository.findAll();
    }

    public List<Donacion> obtenerDonacionesPorDonador(Integer donadorId, Integer estadoDonacion) {
        if (estadoDonacion == null) {
            return donacionRepository.findByEstadoAndDonadorId(1, donadorId);
        } else {
            return donacionRepository.findByEstadoDonacionAndEstadoAndDonadorId(estadoDonacion, 1, donadorId);
        }

    }

    public Donacion obtenerById(Integer id) {
        return donacionRepository.findById(id).orElse(null);
    }

    public Donacion actualizarDonacion(Donacion donacion, Integer id) {
        return donacionRepository.findById(id).map(donacionExistente -> {
            donacionExistente.setDireccion(donacion.getDireccion());
            donacionExistente.setLatitudGps(donacion.getLatitudGps());
            donacionExistente.setLongitudGps(donacion.getLongitudGps());
            donacionExistente.setEstadoDonacion(donacion.getEstadoDonacion());
            donacionExistente.setObservacion(donacion.getObservacion());
            donacionExistente.setCantidadTotal(donacion.getCantidadTotal());
            donacionExistente.setPesoTotal(donacion.getPesoTotal());
            donacionExistente.setEstado(donacion.getEstado());
            donacionExistente.setFechaModificacion(LocalDate.now());
            donacionExistente.setUsuarioModificacion(donacion.getUsuarioModificacion());
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

    /**
     * DONACION DETALLE
     */

    public DonacionDetalle registrarDonacionDetalle(DonacionDetalle donacionDetalle) {
        return donacionDetalleRepository.save(donacionDetalle);
    }

    public List<DonacionDetalle> obtenerDetallesByDonador(Integer donadorId, String estadosDonacion) {
        if(donadorId == null) {
            return donacionDetalleRepository.findByDonacionEstadoOOrderByIdDesc(1);
        }
        if (estadosDonacion == null) {
            return donacionDetalleRepository.findByEstadoAndDonacion_DonadorIdOrderByIdDesc(1, donadorId);
        } else {
            List<String> estados = Arrays.asList(estadosDonacion.split(","));
            List<Integer> listEstados = new ArrayList<>();
            for (String s : estados) {
                listEstados.add(Integer.parseInt(s));
            }
            return donacionDetalleRepository.findByEstadoAndDonacion_DonadorIdAndDonacion_EstadoDonacionIsInOrderByIdDesc(1, donadorId, listEstados);
        }

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
            donacionDetalleExistente.setUnidadMedidaCant(donacionDetalle.getUnidadMedidaCant());
            donacionDetalleExistente.setUnidadMedidaPeso(donacionDetalle.getUnidadMedidaPeso());
            donacionDetalleExistente.setFechaVencimiento(donacionDetalle.getFechaVencimiento());
            donacionDetalleExistente.setEstado(donacionDetalle.getEstado());
            donacionDetalleExistente.setFechaModificacion(LocalDate.now());
            donacionDetalleExistente.setUsuarioModificacion(donacionDetalle.getUsuarioModificacion());
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
