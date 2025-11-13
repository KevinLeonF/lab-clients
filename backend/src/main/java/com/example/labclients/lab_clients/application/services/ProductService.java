package com.example.labclients.lab_clients.application.services;

import com.example.labclients.lab_clients.domain.model.Product;
import com.example.labclients.lab_clients.domain.repository.ProductRepository;
import com.example.labclients.lab_clients.domain.exception.ProductNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Product save(Product product) {
        return repository.save(product);
    }

    public List<Product> getAll() {
        return repository.findAll();
    }

    public void delete(Long id) {
        if (!repository.findById(id).isPresent()) {
            throw new ProductNotFoundException("Producto con ID " + id + " no encontrado");
        }
        repository.deleteById(id);
    }
}
