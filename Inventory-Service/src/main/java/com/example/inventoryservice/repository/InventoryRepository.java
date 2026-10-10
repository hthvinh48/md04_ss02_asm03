package com.example.inventoryservice.repository;

import com.example.inventoryservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InventoryRepository extends JpaRepository<Product, Long> {
    Optional<Product> findBySku(String sku);
}
