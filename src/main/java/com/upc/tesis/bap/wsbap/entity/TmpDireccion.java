package com.upc.tesis.bap.wsbap.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_tmp_direccion")
public class TmpDireccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "razon_social")
    private String razonSocial;

    private String direccion;

    @Column(name = "dir_lat_gps")
    private String dirLatGps;

    @Column(name = "dir_lon_gps")
    private String dirLonGps;

    private int estado;

}
