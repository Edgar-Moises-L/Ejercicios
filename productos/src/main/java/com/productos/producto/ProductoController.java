package com.productos.producto;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {
    @Autowired
    private IProductoService productoService;

    @GetMapping
    public ResponseEntity<List<ProductoDto>> getAll() {
        List<ProductoDto> productos = productoService.getAll();
        return ResponseEntity.ok(productos);
    }

    @GetMapping
    public ResponseEntity<ProductoDto> getById(@PathVariable Long id) {
        ProductoDto producto = productoService.getById(id);
        return ResponseEntity.ok(producto);
    }

    @PostMapping
    public ResponseEntity<ProductoDto> addProducto(@RequestBody ProductoDto productoDto) {
        ProductoDto producto = productoService.addProducto(productoDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(producto);
    }
    @PutMapping
    public ResponseEntity<ProductoDto> updateProducto(@PathVariable Long id, @RequestBody ProductoDto productoDto){
        ProductoDto producto = productoService.updateProducto(id, productoDto);
        return ResponseEntity.ok(producto);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteProducto(@PathVariable Long id){
        productoService.deleteProducto(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
