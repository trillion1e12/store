package com.example.store.product.dto;

public record CreateProductRequest(
        String name,
        Integer price,
        Integer quantity
) {
}
