package com.productos.producto;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductoService implements IProductoService {

    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private ProductoMapper productoMapper;

    @Override
    public List<ProductoDto> getAll() {
        return productoRepository.findAll().stream()
                .map(productoMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductoDto getById(Long id) {
        Producto producto = productoRepository.findById(id).orElseThrow(() -> new RuntimeException("No se encontro el producto con el id " + id));
        return productoMapper.toDto(producto);
    }

    @Override
    public ProductoDto addProducto(ProductoDto productoDto) {
        Producto producto = productoMapper.toEntity(productoDto);
        Producto productoNuevo = productoRepository.save(producto);
        return productoMapper.toDto(productoNuevo);
    }

    @Override
    public ProductoDto updateProducto(Long id, ProductoDto productoDto) {
        Producto productoGusrdado = productoRepository.findById(id).orElseThrow(() -> new RuntimeException("No se encontro el producto con id " + id));

        productoGusrdado.setNombre(productoDto.getNombre());
        productoGusrdado.setDescripcion(productoDto.getDescripcion());
        productoGusrdado.setCantidad(productoDto.getCantidad());
        productoGusrdado.setPrecio(productoDto.getPrecio());

        Producto productoNuevo = productoRepository.save(productoGusrdado);
        return productoMapper.toDto(productoNuevo);
    }

    @Override
    @Transactional
    public void deleteProducto(Long id) {
        if (!productoRepository.existsById(id)) {
            throw new RuntimeException("No se encontro el producto con el id " + id);
        }
        productoRepository.deleteById(id);


    }
}
