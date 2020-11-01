package com.upc.tesis.bap.wsbap.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_donador")
public class Donador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    private String ruc;

    @Column(name = "razon_social")
    private String razonSocial;

    @Column(name = "nombre_representante")
    private String nombreRepresentante;

    @Column(name = "direccion_legal")
    private String direccionLegal;

    @Column(name = "direccion_almacen_defecto")
    private String direccioAlmacenDefecto;

    @Column(name = "dir_alm_lat_gps")
    private String dirAlmLatGps;

    @Column(name = "dir_alm_lon_gps")
    private String dirAlmLonGps;

    @Column(name = "fecha_asociacion", columnDefinition = "DATE")
    private LocalDate fechaAsociacion;

    @Column(name = "fecha_creacion", columnDefinition = "DATE")
    private LocalDate fechaCreacion;

    @Column(name = "usuario_creacion")
    private String usuarioCreacion;

    @Column(name = "fecha_modificacion", columnDefinition = "DATE")
    private LocalDate fechaModificacion;

    @Column(name = "usuario_modificacion")
    private String usuarioModificacion;

}
