package com.ccabc.service;


import com.ccabc.model.Product;
import com.ccabc.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ProductService {
    ProductRepository productRepository;
    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public List<Product> getAllProducts(){
        return productRepository.getAllProducts();
    }
    public Product getProductById(int productId){
        return productRepository.getProductById(productId);
    }
    public String addProduct(Product product){
        return productRepository.addProduct(product);
    }

    public String deleteProduct(int productId){
        return productRepository.deleteProduct(productId);
    }
}
