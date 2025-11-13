package com.example.labclients.lab_clients.application.mapper;

import com.example.labclients.lab_clients.domain.model.Product;
import com.example.labclients.lab_clients.infrastructure.persistence.entity.ProductEntity;
import com.example.labclients.lab_clients.application.dto.ProductDTO;

public class ProductMapper {

    public static Product toDomain(ProductEntity entity) {
        return new Product(entity.getId(), entity.getName(), entity.getPrice());
    }

    public static ProductEntity toEntity(Product domain) {
        ProductEntity entity = new ProductEntity();
        entity.setId(domain.getId());
        entity.setName(domain.getName());
        entity.setPrice(domain.getPrice());
        return entity;
    }

    public static ProductDTO toDTO(Product product) {
        return new ProductDTO(product.getId(), product.getName(), product.getPrice());
    }

    public static Product toDomain(ProductDTO dto) {
        return new Product(dto.getId(), dto.getName(), dto.getPrice());
    }
}
