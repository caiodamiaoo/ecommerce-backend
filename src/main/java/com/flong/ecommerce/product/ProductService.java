package com.flong.ecommerce.product;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import static com.flong.ecommerce.product.ProductSpecification.findByPriceRange;
import static org.springframework.data.jpa.domain.Specification.where;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product createProduct(Product product) {
        product.setCreatedAt(LocalDateTime.now());
        product.setUpdatedAt(LocalDateTime.now());
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product product) {
        Product existingProduct = productRepository.findById(id).orElse(null);
        if (existingProduct == null) {
            return null;
        }
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id).orElse(null);
        if (product != null) {
            productRepository.delete(product);
        }
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Page<Product> findByFilter(ProductRequestDTO dto, Pageable pageable) {
        return productRepository.findAll(where(findByPriceRange(dto)), pageable);
    }
}
