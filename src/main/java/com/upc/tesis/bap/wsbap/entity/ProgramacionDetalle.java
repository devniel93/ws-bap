package com.upc.tesis.bap.wsbap.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_programacion_detalle")
public class ProgramacionDetalle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_programacion")
    private ProgramacionDonacion programacionDonacion;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "id_beneficiario")
    private Beneficiario beneficiario;

    private Integer cantidad;

    @Column(name = "unidad_medida")
    private String unidadMedida;

    private BigDecimal peso;
    private int estado;

    @Column(name = "fecha_creacion", columnDefinition = "DATE")
    private LocalDate fechaCreacion;

    @Column(name = "usuario_creacion")
    private String usuarioCreacion;

    @Column(name = "fecha_modificacion", columnDefinition = "DATE")
    private LocalDate fechaModificacion;

    @Column(name = "usuario_modificacion")
    private String usuarioModificacion;
}
