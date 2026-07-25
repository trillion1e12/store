package com.example.store.product.dto;

import java.util.UUID;

public record ProductResponse(
    UUID id,
    String name,
    int price,
    int quantity,
    int quantity1,
    int quantity2,
    int quantity3,
    int quantity4) {}
