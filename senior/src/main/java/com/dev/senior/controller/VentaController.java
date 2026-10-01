package com.dev.senior.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.senior.Service.VentaService;
import com.dev.senior.dto.DetalleVentaResponse;
import com.dev.senior.dto.VentaResponse;


@RestController
@RequestMapping("/ventas")
public class VentaController {

    private final VentaService ventaService;

    public VentaController(VentaService ventaService) {
        this.ventaService = ventaService;
    }

    @GetMapping
    public ResponseEntity<List<VentaResponse>> listar() {

        List<VentaResponse> ventas = ventaService
                .listartodas()
                .stream()
                .map(venta -> new VentaResponse(
                        venta.getId(),
                        venta.getUsuario().getId(),
                        venta.getFecha(),
                        venta.getTotal(),
                        venta.getDetalles()
                                .stream()
                                .map(detalle -> new DetalleVentaResponse(
                                        detalle.getProducto().getId(),
                                        detalle.getProducto().getNombre(),
                                        detalle.getCantidad(),
                                        detalle.getPreciounitario(),
                                        detalle.getPreciounitario()
                                                .multiply(BigDecimal.valueOf(
                                                        detalle.getCantidad()))
                                ))
                                .toList()
                ))
                .toList();

        return ResponseEntity.ok(ventas);
    }

@GetMapping("/{id}")
public ResponseEntity<VentaResponse> buscarPorId(
        @PathVariable Long id) {

    return ventaService.buscarPorId(id)
            .map(venta -> {
                VentaResponse response = new VentaResponse(
                        venta.getId(),
                        venta.getUsuario().getId(),
                        venta.getFecha(),
                        venta.getTotal(),
                        venta.getDetalles()
                                .stream()
                                .map(detalle -> new DetalleVentaResponse(
                                        detalle.getProducto().getId(),
                                        detalle.getProducto().getNombre(),
                                        detalle.getCantidad(),
                                        detalle.getPreciounitario(),
                                        detalle.getPreciounitario()
                                                .multiply(BigDecimal.valueOf(
                                                        detalle.getCantidad()))
                                ))
                                .toList()
                );

                return ResponseEntity.ok(response);
            })
            .orElse(ResponseEntity.notFound().build());
}

}