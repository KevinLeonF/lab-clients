package com.example.labclients.lab_clients.infrastructure.persistence.adapter;

import com.example.labclients.lab_clients.domain.model.Product;
import com.example.labclients.lab_clients.domain.repository.ProductRepository;
import com.example.labclients.lab_clients.infrastructure.persistence.entity.ProductEntity;
import com.example.labclients.lab_clients.infrastructure.persistence.jpa.SpringDataProductRepository;
import com.example.labclients.lab_clients.application.mapper.ProductMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ProductRepositoryAdapter implements ProductRepository {

    private final SpringDataProductRepository repository;

    public ProductRepositoryAdapter(SpringDataProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public Product save(Product product) {
        ProductEntity entity = ProductMapper.toEntity(product);
        ProductEntity saved = repository.save(entity);
        return ProductMapper.toDomain(saved);
    }

    @Override
    public List<Product> findAll() {
        return repository.findAll().stream()
                .map(ProductMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Product> findById(Long id) {
        return repository.findById(id).map(ProductMapper::toDomain);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
