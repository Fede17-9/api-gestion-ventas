package com.dev.senior.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class VentaResponse {
    private Long id;
    private  Long usuarioId;
    private LocalDateTime fecha;
    private BigDecimal total;
    private List<DetalleVentaResponse> detalles;

    public VentaResponse(){}

    public VentaResponse(Long id, Long usuarioId, LocalDateTime fecha, BigDecimal total,
            List<DetalleVentaResponse> detalles) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.fecha = fecha;
        this.total = total;
        this.detalles = detalles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public List<DetalleVentaResponse> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleVentaResponse> detalles) {
        this.detalles = detalles;
    }

    

}
