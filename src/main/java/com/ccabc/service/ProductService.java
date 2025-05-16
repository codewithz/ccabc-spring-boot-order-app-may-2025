package com.ccabc.service;

import com.ccabc.model.Product;
import com.ccabc.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(int productId) {
        Optional<Product> productOptional = productRepository.findById(productId);
        return productOptional.orElse(null);
    }

    public String addProduct(Product product) {
        Product addedProduct = productRepository.save(product);
        if (addedProduct == null) {
            return "Product Not Added";
        }
        return "Product Added Successfully";
    }

    public String deleteProduct(int productId) {
        productRepository.deleteById(productId);
        return "Product Deleted Successfully";
    }
}