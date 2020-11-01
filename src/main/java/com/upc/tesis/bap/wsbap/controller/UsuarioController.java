package com.upc.tesis.bap.wsbap.controller;

import com.upc.tesis.bap.wsbap.dto.UsuarioDTO;
import com.upc.tesis.bap.wsbap.entity.Usuario;
import com.upc.tesis.bap.wsbap.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/login")
    public UsuarioDTO login(@RequestBody Usuario usuario) {
        return usuarioService.login(usuario.getNombreUsuario(), usuario.getContrasena());
    }

    @GetMapping("login/{username}/{password}")
    public UsuarioDTO login(@PathVariable String username, @PathVariable String password) {
        return usuarioService.login(username, password);
    }

    @GetMapping("usuario/{id}")
    public Usuario findUsuarioById(@PathVariable Integer id) {
        return usuarioService.getUsuarioById(id);
    }

}
