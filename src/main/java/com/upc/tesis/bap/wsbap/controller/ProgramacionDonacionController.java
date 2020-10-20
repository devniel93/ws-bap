package com.upc.tesis.bap.wsbap.controller;

import com.upc.tesis.bap.wsbap.entity.ProgramacionDetalle;
import com.upc.tesis.bap.wsbap.entity.ProgramacionDonacion;
import com.upc.tesis.bap.wsbap.service.ProgramacionDonacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProgramacionDonacionController {

    @Autowired
    private ProgramacionDonacionService programacionDonacionService;

    /** PROGRAMACION DONACION CABECERA */

    @PostMapping("programaciones")
    public ProgramacionDonacion registrarProgramacionDonacion(@RequestBody ProgramacionDonacion programacionDonacion){
        return programacionDonacionService.registrarProgramacionDonacion(programacionDonacion);
    }

    @GetMapping("programaciones")
    public List<ProgramacionDonacion> obtenerProgramaciones(){
        return programacionDonacionService.obtenerProgramaciones();
    }

    @GetMapping("programaciones/{id}")
    public ProgramacionDonacion obtenerProgramacionDonacionById(@PathVariable Integer id){
        return programacionDonacionService.obtenerById(id);
    }

    @PutMapping("programaciones/{id}")
    public ProgramacionDonacion actualizarProgramacionDonacion(@RequestBody ProgramacionDonacion programacionDonacion, @PathVariable Integer id) {
        return programacionDonacionService.actualizarProgramacionDonacion(programacionDonacion, id);
    }

    @DeleteMapping("programaciones/{id}")
    public String eliminarProgramacionDonacion(@PathVariable Integer id) {
        return programacionDonacionService.eliminarProgramacionDonacion(id);
    }

    /** PROGRAMACION DONACION DETALLE */

    @PostMapping("programaciones/detalles")
    public ProgramacionDetalle registrarProgramacionDetalle(@RequestBody ProgramacionDetalle donacionDetalle){
        return programacionDonacionService.registrarProgramacionDetalle(donacionDetalle);
    }

    @GetMapping("programaciones/{id}/detalles")
    public List<ProgramacionDetalle> obtenerDetalleById(@PathVariable Integer id){
        return programacionDonacionService.obtenerDetalleById(id);
    }

    @GetMapping("programaciones/detalles/{id}")
    public ProgramacionDetalle obtenerProgramacionDetalleById(@PathVariable Integer id){
        return programacionDonacionService.obtenerProgramacionDetalleById(id);
    }

    @PutMapping("programaciones/detalles/{id}")
    public ProgramacionDetalle actualizarProgramacionDetalle(@RequestBody ProgramacionDetalle donacionDetalle, @PathVariable Integer id) {
        return programacionDonacionService.actualizarProgramacionDetalle(donacionDetalle, id);
    }

    @DeleteMapping("programaciones/detalles/{id}")
    public String eliminarProgramacionDetalle(@PathVariable Integer id) {
        return programacionDonacionService.eliminarProgramacionDetalle(id);
    }








}
