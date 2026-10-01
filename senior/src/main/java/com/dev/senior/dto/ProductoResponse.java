package com.dev.senior.dto;

import java.math.BigDecimal;

public class ProductoResponse {
    private Long id;
    private String noombre;
    private String descripcion;
    private BigDecimal precio;
    private Integer stock;
    private Boolean estado;

    public ProductoResponse(){}

    public ProductoResponse(Long id, String noombre, String descripcion, BigDecimal precio, Integer stock,
            Boolean estado) {
        this.id = id;
        this.noombre = noombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNoombre() {
        return noombre;
    }

    public void setNoombre(String noombre) {
        this.noombre = noombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    
    

}
