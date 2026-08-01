package com.example.store.product.dto;

import java.util.UUID;

public record ProductResponse(UUID id, String name, Integer price, Integer quantity) {
}
