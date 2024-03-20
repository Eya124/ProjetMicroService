package com.example.product;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    public Product getProductById(Long pid) {
        return productRepository.findById(pid).orElse(null);
    }
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }
    public void deleteProduct(Long pid) {
        productRepository.deleteById(pid);
    }
}
