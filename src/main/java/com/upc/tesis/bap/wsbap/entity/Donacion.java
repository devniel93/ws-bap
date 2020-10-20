package com.upc.tesis.bap.wsbap.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_donacion")
public class Donacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_donador")
    private Donador donador;

    private String direccion;

    @Column(name = "latitud_gps")
    private String latitudGps;

    @Column(name = "longitud_gps")
    private String longitudGps;

    private String observacion;

    @Column(name = "cantidad_total")
    private Integer cantidadTotal;

    @Column(name = "peso_total")
    private BigDecimal pesoTotal;

    @Column(name = "precio_total")
    private BigDecimal precioTotal;

    private int estado;
    @Column(name = "fecha_creacion", columnDefinition = "DATE")
    private LocalDate fechaCreacion;

    @Column(name = "usuario_creacion")
    private String usuarioCreacion;

    @Column(name = "fecha_modificacion", columnDefinition = "DATE")
    private LocalDate fechaModificacion;

    @Column(name = "usuario_modificacion")
    private String usuarioModificacion;

    /*@OneToMany(mappedBy = "donacion")
    private Set<DonacionDetalle> donacionDetalles;*/

}
