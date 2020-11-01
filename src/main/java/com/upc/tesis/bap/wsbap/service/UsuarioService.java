package com.upc.tesis.bap.wsbap.service;

import com.upc.tesis.bap.wsbap.dto.UsuarioDTO;
import com.upc.tesis.bap.wsbap.entity.Donador;
import com.upc.tesis.bap.wsbap.entity.Rol;
import com.upc.tesis.bap.wsbap.entity.Usuario;
import com.upc.tesis.bap.wsbap.repository.DonadorRepository;
import com.upc.tesis.bap.wsbap.repository.RolRepository;
import com.upc.tesis.bap.wsbap.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private DonadorRepository donadorRepository;

    @Autowired
    private RolRepository rolRepository;

    public Usuario saveUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> getUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario getUsuarioById(Integer id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario getUsuarioByNombreUsuario(String nombreUsuario) {
        return usuarioRepository.findByNombreUsuario(nombreUsuario);
    }
    public String deleteUsuario(Integer id) {
        usuarioRepository.deleteById(id);
        return "Usuario eliminado " + id;
    }

    public Usuario updateUsuario(Usuario usuario){
        Usuario existingUsuario = usuarioRepository.findById(usuario.getId()).orElse(null);
        existingUsuario.setNombres(usuario.getNombres());
        existingUsuario.setApellidoPaterno(usuario.getApellidoPaterno());
        existingUsuario.setApellidoMaterno(usuario.getApellidoMaterno());
        existingUsuario.setCorreo(usuario.getCorreo());
        return usuarioRepository.save(existingUsuario);
    }

    public UsuarioDTO login(String nombreUsuario, String contrasena) {
        Usuario usuario = usuarioRepository.findByNombreUsuario(nombreUsuario);
        if(usuario != null && usuario.getContrasena().equals(contrasena) && usuario.getEstado() == 1) {
            UsuarioDTO dto = new UsuarioDTO().modelToDTO(usuario);
            Donador donador = donadorRepository.findByUsuarioId(usuario.getId());
            if(donador != null) {
                dto.setIdDonador(donador.getId());
                dto.setRuc(donador.getRuc());
                dto.setRazonSocial(donador.getRazonSocial());
                dto.setDireccionAlmacenDefecto(donador.getDireccioAlmacenDefecto());
                dto.setDirAlmLatGps(donador.getDirAlmLatGps());
                dto.setDirAlmLonGps(donador.getDirAlmLonGps());
            }
            Rol rol = rolRepository.findById(usuario.getRol().getId()).orElse(null);
            if(rol != null) {
                dto.setNombreRol(rol.getNombre());
            }
            return dto;
        }
        return null;
    }

}
