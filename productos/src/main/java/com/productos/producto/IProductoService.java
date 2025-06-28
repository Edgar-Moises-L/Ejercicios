package com.productos.producto;

import java.util.List;
public interface IProductoService {
    List<ProductoDto> getAll();
    ProductoDto getById(Long id);
    ProductoDto addProducto(ProductoDto producto);
    ProductoDto updateProducto(Long id, ProductoDto producto);
    void deleteProducto(Long id);
}
