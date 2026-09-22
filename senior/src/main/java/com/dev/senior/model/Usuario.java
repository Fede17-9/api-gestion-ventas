package com.dev.senior.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import jakarta.persistence.OneToMany;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;
    
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "rol", nullable = false)
    private Rol rol;


    // esto es para la relacion con la tabla ventas
    @OneToMany(mappedBy = "usuario")
    private List<Venta> ventas = new ArrayList<>();

public Usuario() {

}
public Usuario(String nombre, String email, String password, Rol rol) {
    this.nombre = nombre;
    this.email = email;
    this.password = password;
    this.rol = rol;
}
public void setId(Long id) {
    this.id = id;
}
public Long getId() {
    return id;
}
public void setNombre(String nombre) {
    this.nombre = nombre;
}
public String getNombre() {
    return nombre;
}
public void setEmail(String email) {
    this.email = email;
}
public String getEmail() {
    return email;
}
public void setPassword(String password) {
    this.password = password;
}
public String getPassword() {
    return password;
}
public void setRol(Rol rol) {
    this.rol = rol;
}
public Rol getRol() {
    return rol;
}
public void setVentas(List<Venta> ventas) {
    this.ventas = ventas;
}
public List<Venta> getVentas() {
    return ventas;
}
}