package com.productos.producto;

import org.springframework.stereotype.Component;

@Component
public class ProductoMapper {

    public ProductoDto toDto(Producto producto) {
        ProductoDto dto = new ProductoDto();
        dto.setId(producto.getId());
        dto.setNombre(producto.getNombre());
        dto.setDescripcion(producto.getDescripcion());
        dto.setCantidad(producto.getCantidad());
        dto.setPrecio(producto.getPrecio());
        return dto;
    }

    public Producto toEntity(ProductoDto dto) {
        Producto producto = new Producto();
        producto.setId(dto.getId());
        producto.setNombre(dto.getNombre());
        producto.setDescripcion(dto.getDescripcion());
        producto.setCantidad(dto.getCantidad());
        producto.setPrecio(dto.getPrecio());
        return producto;
    }



}
