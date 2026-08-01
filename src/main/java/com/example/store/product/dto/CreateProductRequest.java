package com.example.store.product.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateProductRequest(
        @NotBlank String name,
        @NotNull(message = "Don't ") @Min(value = 0, message = "Oh my, are you too low? I can fix that") Integer price,
        @NotNull @Min(0) Integer quantity,
        @NotNull @Min(0) Integer quantity2
) {
}
