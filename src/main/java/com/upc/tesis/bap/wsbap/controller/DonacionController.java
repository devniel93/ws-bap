package com.upc.tesis.bap.wsbap.controller;

import com.upc.tesis.bap.wsbap.entity.Donacion;
import com.upc.tesis.bap.wsbap.entity.DonacionDetalle;
import com.upc.tesis.bap.wsbap.entity.Transporte;
import com.upc.tesis.bap.wsbap.service.DonacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DonacionController {

    @Autowired
    private DonacionService donacionService;

    /** DONACION CABECERA */

    @PostMapping("donaciones")
    public Donacion registrarDonacion(@RequestBody Donacion donacion){
        return donacionService.registrarDonacion(donacion);
    }

    @GetMapping("donaciones/all")
    public List<Donacion> obtenerDonaciones(){
        return donacionService.obtenerDonaciones();
    }

    @GetMapping("donaciones")
    public List<Donacion> obtenerDonaciones(@RequestParam Integer donadorId, @RequestParam(required = false) Integer estadoDonacion){
        return donacionService.obtenerDonacionesPorDonador(donadorId, estadoDonacion);
    }

    @GetMapping("donaciones/{id}")
    public Donacion obtenerDonacionById(@PathVariable Integer id){
        return donacionService.obtenerById(id);
    }

    @PutMapping("donaciones/{id}")
    public Donacion actualizarDonacion(@RequestBody Donacion donacion, @PathVariable Integer id) {
        return donacionService.actualizarDonacion(donacion, id);
    }

    @DeleteMapping("donaciones/{id}")
    public String eliminarDonacion(@PathVariable Integer id) {
        return donacionService.eliminarDonacion(id);
    }

    /**
     * DONACION DETALLE
     * */

    @PostMapping("donaciones/detalles")
    public DonacionDetalle registrarDonacionDetalle(@RequestBody DonacionDetalle donacionDetalle){
        return donacionService.registrarDonacionDetalle(donacionDetalle);
    }

    @GetMapping("donaciones/detalles")
    public List<DonacionDetalle> obtenerDetalles(@RequestParam Integer donadorId, @RequestParam(required = false) String estadosDonacion){
        return donacionService.obtenerDetallesByDonador(donadorId, estadosDonacion);
    }

    @GetMapping("donaciones/{id}/detalles")
    public List<DonacionDetalle> obtenerDetalleById(@PathVariable Integer id){
        return donacionService.obtenerDetalleById(id);
    }

    @GetMapping("donaciones/detalles/{id}")
    public DonacionDetalle obtenerDonacionDetalleById(@PathVariable Integer id){
        return donacionService.obtenerDonacionDetalleById(id);
    }

    @PutMapping("donaciones/detalles/{id}")
    public DonacionDetalle actualizarDonacionDetalle(@RequestBody DonacionDetalle donacionDetalle, @PathVariable Integer id) {
        return donacionService.actualizarDonacionDetalle(donacionDetalle, id);
    }

    @DeleteMapping("donaciones/detalles/{id}")
    public String eliminarDonacionDetalle(@PathVariable Integer id) {
        return donacionService.eliminarDonacionDetalle(id);
    }

}
