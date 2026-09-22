package com.dev.senior.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.senior.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {


}
