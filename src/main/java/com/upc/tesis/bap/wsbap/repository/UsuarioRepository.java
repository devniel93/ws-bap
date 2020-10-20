package com.upc.tesis.bap.wsbap.repository;

import com.upc.tesis.bap.wsbap.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Usuario findByNombreUsuario(String nombreUsuario);
}
