package com.ccabc.controller;

import com.ccabc.model.Product;
import com.ccabc.payload.ApiSuccessPayload;
import com.ccabc.service.ProductService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ApiSuccessPayload> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        ApiSuccessPayload response = ApiSuccessPayload.build(products, HttpStatus.OK, "List of Products");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // Get product by ID
    @GetMapping("/{id}")
    public ResponseEntity<ApiSuccessPayload> getProductById(
            @Positive(message = "Negative IDs are not allowed") @PathVariable(name = "id") int productId) {
        Product product = productService.getProductById(productId);
        HttpStatus status = HttpStatus.OK;
        ApiSuccessPayload response = ApiSuccessPayload.build(product, status, "Product Found Successfully");
        return new ResponseEntity<>(response, status);
    }

    // Add new product
    @PostMapping
    public ResponseEntity<ApiSuccessPayload> addProduct(@Valid @RequestBody Product product) {
        String result = productService.addProduct(product);
        HttpStatus status = HttpStatus.CREATED;
        ApiSuccessPayload response = ApiSuccessPayload.build(result, status, "Product Added Successfully");
        return new ResponseEntity<>(response, status);
    }

    // Delete product by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiSuccessPayload> deleteProduct(@PathVariable(name = "id") int productId) {
        String result = productService.deleteProduct(productId);
        HttpStatus status = HttpStatus.NO_CONTENT;
        ApiSuccessPayload response = ApiSuccessPayload.build(result, status, "Product Deleted Successfully");
        return new ResponseEntity<>(response, status);
    }
}