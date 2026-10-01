package com.dev.senior.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.senior.Service.UsuarioService;
import com.dev.senior.dto.UsuarioRequest;

import com.dev.senior.dto.UsuarioResponse;
import com.dev.senior.model.Rol;
import com.dev.senior.model.Usuario;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;



@RestController 
@RequestMapping("/usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;

    }

    @PostMapping
    public ResponseEntity<UsuarioResponse> crear(@RequestBody UsuarioRequest request){

        Usuario usuario = new Usuario();

        usuario.setNombre(request.getNombre());
        usuario.setEmail(request.getCorreo());
        usuario.setPassword(request.getContraseña());
        usuario.setRol(Rol.USER);

        Usuario usuarioGuardado = usuarioService.guardar(usuario);

        UsuarioResponse response = new UsuarioResponse(
            usuarioGuardado.getId(),
            usuarioGuardado.getNombre(),
            usuarioGuardado.getEmail(),
            usuarioGuardado.getRol().name()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    
    }
    
    @GetMapping
    public ResponseEntity<List<UsuarioResponse>> listar() {
        List<UsuarioResponse> usuarios = usuarioService
        .listarTodos()
        .stream()
        .map(usuario -> new UsuarioResponse(usuario.getId(),
        usuario.getNombre(),
        usuario.getEmail(),
        usuario.getRol().name()))
        .toList();

        return ResponseEntity.ok(usuarios);

    }
    




}
