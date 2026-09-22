package com.dev.senior.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import java.util.List;

import java.math.BigDecimal;

import jakarta.persistence.Column;

@Entity
@Table(name = "productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Column(name = "precio", nullable = false, precision = 12, scale = 2)
    private BigDecimal precio;

    @Column(name = "stock", nullable = false)
    private Integer stock;

    @Column (name = "estado", nullable = false)
    private boolean estado;

    public Producto() {
    }

    public Producto(String nombre, String descripcion, BigDecimal precio, Integer stock, boolean estado) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.estado = estado;
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
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }
    public BigDecimal getPrecio() {
        return precio;
    }
    public void setStock(Integer stock) {
        this.stock = stock;
    }
    public Integer getStock() {
        return stock;
    }
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    public boolean getEstado() {
        return estado;
    }


}
