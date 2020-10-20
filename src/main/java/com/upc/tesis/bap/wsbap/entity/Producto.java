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
@Table(name = "tb_producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String codigo;
    private String descripcion;

    @Column(name = "tipo_producto")
    private String tipoProducto;

    @Column(name = "precio_unitario")
    private BigDecimal precioUnitario;

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
