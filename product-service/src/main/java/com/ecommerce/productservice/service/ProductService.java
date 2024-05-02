package com.ecommerce.productservice.service;

import com.ecommerce.productservice.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Product createProduct(Product product);
    List<Product> getAllProducts();
    Optional<Product> getProductById(Long id);
    Product updateProduct(Long id, Product product);
    void deleteProduct(Long id);

}
