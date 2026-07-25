package com.example.store.product;

import com.example.store.product.dto.ProductResponse;

import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public ProductResponse getProduct(UUID id) {
        Product product = productRepository.findById(id).orElseThrow();
        ProductResponse productResponse = productMapper.toResponse(product);
        return productResponse;
    }

    public List<ProductResponse> getProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductResponse> productResponses = products.stream().map(productMapper::toResponse).toList();
        return productResponses;
    }
}
