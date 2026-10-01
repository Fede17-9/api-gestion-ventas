package com.dev.senior.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.senior.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
boolean existsByCorreo(String correo);

Optional<Usuario> findByCorreo(String correo);



}
