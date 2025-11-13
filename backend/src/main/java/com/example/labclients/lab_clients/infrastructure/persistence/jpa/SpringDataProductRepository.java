package com.example.labclients.lab_clients.infrastructure.persistence.jpa;

import com.example.labclients.lab_clients.infrastructure.persistence.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataProductRepository extends JpaRepository<ProductEntity, Long> {
}
