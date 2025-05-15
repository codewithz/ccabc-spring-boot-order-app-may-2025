package com.ccabc.controller;

import com.ccabc.model.Product;
import com.ccabc.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    // Get all products
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // Get product by ID
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable(name = "id") int productId) {
        return productService.getProductById(productId);
    }

    // Add new product
    @PostMapping
    public String addProduct(@Valid @RequestBody Product product) {
        return productService.addProduct(product);
    }

    // Delete product by ID
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable(name = "id") int productId) {
        return productService.deleteProduct(productId);
    }
}
