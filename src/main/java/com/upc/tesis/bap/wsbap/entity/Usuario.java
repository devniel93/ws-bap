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
@Table(name = "tb_usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre_usuario")
    private String nombreUsuario;
    private String contrasena;
    private String nombres;

    @Column(name = "apellido_paterno")
    private String apellidoPaterno;

    @Column(name = "apellido_materno")
    private String apellidoMaterno;

    private String correo;
    private String cargo;
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
