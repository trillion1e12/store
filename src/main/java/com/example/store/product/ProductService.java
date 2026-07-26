package com.example.store.product;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.store.exception.NotFoundException;
import com.example.store.product.dto.CreateProductRequest;
import com.example.store.product.dto.ProductResponse;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final Logger logger = LoggerFactory.getLogger(ProductService.class);

    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public ProductResponse createProduct(CreateProductRequest request) {
        logger.info("Creating product");

        Product product = productMapper.toEntity(request);
        Product createdProduct = productRepository.save(product);

        logger.info("Created a product with id %s".formatted(createdProduct.getId()));
        ProductResponse response = productMapper.toResponse(createdProduct);
        return response;
    }

    public ProductResponse getProduct(UUID id) {
        logger.info("Getting product with id %s".formatted(id));

        Product product = productRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("User %s not found".formatted(id)));

        ProductResponse productResponse = productMapper.toResponse(product);

        logger.info("Found product");
        return productResponse;
    }

    public List<ProductResponse> getProducts() {
        logger.info("Getting all products");

        List<Product> products = productRepository.findAll();
        List<ProductResponse> productResponses = products.stream().map(productMapper::toResponse).toList();

        logger.info("Found %d products".formatted(products.size()));
        return productResponses;
    }
}
