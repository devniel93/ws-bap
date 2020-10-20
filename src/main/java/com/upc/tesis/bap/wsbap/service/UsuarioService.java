package com.upc.tesis.bap.wsbap.service;

import com.upc.tesis.bap.wsbap.entity.Usuario;
import com.upc.tesis.bap.wsbap.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

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

    public Usuario login(String nombreUsuario, String contrasena) {
        Usuario usuario = usuarioRepository.findByNombreUsuario(nombreUsuario);
        if(usuario != null && usuario.getContrasena().equals(contrasena)) {
            return usuario;
        }
        return null;
    }

}
