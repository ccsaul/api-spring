package com.practica.apispring.persistence;

import com.practica.apispring.persistence.crud.ProductoCrudRepository;
import com.practica.apispring.persistence.entity.Producto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository {

    private ProductoCrudRepository productoRepository;

    public List<Producto> getAll() {
        return (List<Producto>) productoRepository.findAll();
    }

    public List<Producto> getByCategoria(int idCategoria) {
        return productoRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
    }

    public Optional<List<Producto>> getEscasos(int cantidad) {
        return productoRepository.findByCantidadStockLessThanAndEstado(cantidad, true);
    }

    public Optional<Producto> getProducto(Long idProducto) {
        return productoRepository.findById(idProducto);
    }

    public Producto save (Producto producto) {
        return  productoRepository.save(producto);
    }

    public void delete (Long idProducto) {
        productoRepository.deleteById(idProducto);
    }
}
