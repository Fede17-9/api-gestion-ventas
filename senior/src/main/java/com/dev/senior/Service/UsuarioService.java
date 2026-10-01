package com.dev.senior.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.dev.senior.model.Rol;
import com.dev.senior.model.Usuario;
import com.dev.senior.repository.UsuarioRepository;


@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder){
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
        

    }

    public Usuario registrar(Usuario usuario){
        if(usuarioRepository.existsByCorreo(usuario.getEmail())){
            throw new IllegalArgumentException("Ya existe un usuario con ese correo");
        }
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        usuario.setRol(Rol.USER);

        return usuarioRepository.save(usuario);

    }

    public Usuario guardar(Usuario usuario){
        return usuarioRepository.save(usuario);
    }
    
    public List<Usuario> listarTodos(){
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> buscaPorId(Long id){
        return usuarioRepository.findById(id);
    }

    public void eliminar(Long id){
        usuarioRepository.deleteById(id);
    }




}
