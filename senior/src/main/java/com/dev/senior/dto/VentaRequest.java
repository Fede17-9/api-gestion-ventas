package com.dev.senior.dto;


import java.util.List;

public class VentaRequest {
    private List<VentaRequest> detalles;

    public VentaRequest(){}

    public VentaRequest(List<VentaRequest> detalles) {
        this.detalles = detalles;
    }

    public List<VentaRequest> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<VentaRequest> detalles) {
        this.detalles = detalles;
    }

    

}
