package com.dev.senior.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.senior.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
