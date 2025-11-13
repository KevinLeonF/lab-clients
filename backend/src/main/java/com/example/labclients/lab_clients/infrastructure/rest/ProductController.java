package com.example.labclients.lab_clients.infrastructure.rest;

import com.example.labclients.lab_clients.application.dto.ProductDTO;
import com.example.labclients.lab_clients.application.mapper.ProductMapper;
import com.example.labclients.lab_clients.application.services.ProductService;
import com.example.labclients.lab_clients.domain.model.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public ProductDTO create(@RequestBody ProductDTO dto) {
        Product saved = service.save(ProductMapper.toDomain(dto));
        return ProductMapper.toDTO(saved);
    }

    @GetMapping
    public List<ProductDTO> getAll() {
        return service.getAll()
                .stream()
                .map(ProductMapper::toDTO)
                .collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
