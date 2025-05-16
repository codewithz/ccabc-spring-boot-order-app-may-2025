package com.ccabc.repository;

import com.ccabc.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepositoryWithoutJPA {

    private List<Product> products=new ArrayList<>();

    public ProductRepositoryWithoutJPA() {
        // Coca-Cola product seeds
        products.add(new Product(2301, "Coca-Cola Classic", "Original taste, 500ml bottle", 35.00, 100));
        products.add(new Product(2302, "Diet Coke", "No sugar, 500ml can", 40.00, 80));
        products.add(new Product(2303, "Sprite", "Lemon-lime flavored soft drink, 600ml", 38.00, 90));
        products.add(new Product(2304, "Fanta Orange", "Orange flavored soda, 500ml", 37.00, 85));
        products.add(new Product(2305, "Kinley Water", "Packaged drinking water, 1L", 20.00, 150));
        products.add(new Product(2306, "Maaza", "Mango drink, 600ml bottle", 42.00, 95));
        products.add(new Product(2307, "Coke Zero", "No sugar, 500ml bottle", 40.00, 70));
        products.add(new Product(2308, "Minute Maid Pulpy Orange", "Orange juice drink, 400ml", 45.00, 60));
        products.add(new Product(2309, "Thums Up", "Strong cola taste, 600ml", 39.00, 88));
        products.add(new Product(2310, "Schweppes Soda", "Premium soda water, 300ml can", 30.00, 50));
    }

    public List<Product> getAllProducts(){
        return products;
    }

    public Product getProductById(int id){
        Product product=null;

        for(Product p:products){
            if(p.getProductId()==id){
                product=p;
                break;
            }
        }
        return product;
    }

    public String addProduct(Product product){
        products.add(product);
        return "Product Added Successfully";
    }

    public String deleteProduct(int id){
        Product productToBeDeleted=getProductById(id);
        products.remove(productToBeDeleted);
        return "Product Deleted Successfully";
    }
}
