package com.example.inventoryservice.service;

import com.example.inventoryservice.dto.ProductResponseDTO;
import com.example.inventoryservice.entity.Product;
import com.example.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InventoryService {
    private final InventoryRepository inventoryRepository;

    private ProductResponseDTO mapToProductResponseDTO(Product product) {
        return new ProductResponseDTO(product.getSku(), product.getName(), product.getQuantity());
    }

    public ProductResponseDTO getProductBySku(String sku) {
        Product product = inventoryRepository.findBySku(sku)
                .orElseThrow(() -> new RuntimeException("Product not found for SKU: " + sku));
        return mapToProductResponseDTO(product);
    }
}
