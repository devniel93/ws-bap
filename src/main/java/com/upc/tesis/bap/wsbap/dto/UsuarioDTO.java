package com.upc.tesis.bap.wsbap.dto;

import com.upc.tesis.bap.wsbap.entity.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO implements Serializable {

    private Integer id;
    private String nombreUsuario;
    private String contrasena;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String correo;
    private String cargo;
    private int estado;
    private LocalDate fechaCreacion;
    private String usuarioCreacion;
    private LocalDate fechaModificacion;
    private String usuarioModificacion;
    //
    private Integer idDonador;
    private String ruc;
    private String razonSocial;
    private String direccionAlmacenDefecto;
    private String dirAlmLatGps;
    private String dirAlmLonGps;
    private String nombreRol;

    public UsuarioDTO modelToDTO(Usuario usuario){
        if(usuario != null) {
            UsuarioDTO dto = new UsuarioDTO();
            dto.setId(usuario.getId());
            dto.setNombreUsuario(usuario.getNombreUsuario());
            dto.setNombres(usuario.getNombres());
            dto.setApellidoPaterno(usuario.getApellidoPaterno());
            dto.setApellidoMaterno(usuario.getApellidoMaterno());
            dto.setCorreo(usuario.getCorreo());
            dto.setCargo(usuario.getCargo());
            return dto;
        }
        return null;
    }


}
