package com.upc.tesis.bap.wsbap.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_programacion_donacion")
public class ProgramacionDonacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_donacion")
    private Donacion donacion;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_transporte")
    private Transporte transporte;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_almacen")
    private Almacen almacen;

    private String tipoProgramacion;

    @Column(name = "fecha_programacion", columnDefinition = "DATE")
    private LocalDate fechaProgramacion;

    private int estado;

    @Column(name = "fecha_creacion", columnDefinition = "DATE")
    private LocalDate fechaCreacion;

    @Column(name = "usuario_creacion")
    private String usuarioCreacion;

    @Column(name = "fecha_modificacion", columnDefinition = "DATE")
    private LocalDate fechaModificacion;

    @Column(name = "usuario_modificacion")
    private String usuarioModificacion;

    /*@OneToMany(mappedBy = "programacionDonacion")
    private Set<ProgramacionDetalle> programacionDetalles;*/

}
