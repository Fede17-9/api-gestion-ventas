package com.dev.senior.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dev.senior.model.Venta;
import com.dev.senior.repository.VentaRepository;

@Service 
public class VentaService {
    private final VentaRepository ventaRepository;

    public VentaService(VentaRepository ventaRepository){
        this.ventaRepository = ventaRepository;
    }

    public Venta guardar(Venta venta){
        return ventaRepository.save(venta);
    }

    public List<Venta> listartodas(){
        return ventaRepository.findAll();
    }

    public Optional<Venta> buscarPorId(Long id){
        return  ventaRepository.findById(id);
    }

    public void eliminar(Long id){
     ventaRepository.deleteById(id);
    }



}
