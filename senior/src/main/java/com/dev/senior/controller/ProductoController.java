package com.dev.senior.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.senior.Service.ProductoService;
import com.dev.senior.dto.ProductoRequest;
import com.dev.senior.dto.ProductoResponse;
import com.dev.senior.model.Producto;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController 
@RequestMapping("/productos")
public class ProductoController {
    private final ProductoService ProductoService;

    public ProductoController(ProductoService productoService){
        this.ProductoService = productoService;
    }

    @PostMapping
    public ResponseEntity<ProductoResponse> crear(@RequestBody  ProductoRequest request) {
        Producto producto = new Producto();
        producto.setNombre(request.getNombre());
        producto.setDescripcion(request.getDescripcion());
        producto.setPrecio(request.getPrecio());
        producto.setStock(request.getStock());
        producto.setEstado(request.getEstado());

        Producto productoGuardado = ProductoService.guardar(producto);

        //Crear un metodo por cada controlador que transforme Entity a  Response
        //Crear un metodo por cada controlador, que transforme Request a Entity
        ProductoResponse response = convertirAResponse(productoGuardado);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);


        
    }

    @GetMapping
    public ResponseEntity<List<ProductoResponse>> listar() {
        List<ProductoResponse> productos = ProductoService
        .listarTodos()
        .stream()
        .map(this::convertirAResponse)
        .toList();

        return ResponseEntity.ok(productos);
        
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoResponse> buscarPorId(@PathVariable Long id){
        return ProductoService.buscaPorId(id)
        .map(producto -> ResponseEntity.ok(convertirAResponse(producto)))
        .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable long id){
        ProductoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

   private ProductoResponse convertirAResponse(Producto producto){
        return new ProductoResponse(
            producto.getId(),
            producto.getNombre(),
            producto.getDescripcion(),
            producto.getPrecio(),
            producto.getStock(),
            producto.getEstado()
        );

   }
    
    
    

}
