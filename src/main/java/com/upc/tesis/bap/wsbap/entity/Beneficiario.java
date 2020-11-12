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
@Table(name = "tb_beneficiario")
public class Beneficiario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @Column(name = "numero_documento")
    private String numeroDocumento;

    @Column(name = "tipo_documento")
    private String tipoDocumento;

    @Column(name = "razon_social")
    private String razonSocial;

    @Column(name = "nombre_representante")
    private String nombreRepresentante;

    @Column(name = "fecha_asociacion", columnDefinition = "DATE")
    private LocalDate fechaAsociacion;

    @Column(name = "cantidad_beneficiarios")
    private Integer cantidadBeneficiarios;

    private String direccion;

    @Column(name = "dir_lat_gps")
    private String dirLatGps;

    @Column(name = "dir_lon_gps")
    private String dirLonGps;

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
