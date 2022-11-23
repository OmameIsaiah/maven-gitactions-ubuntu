package com.recommendation.service.service;

import com.recommendation.service.model.Product;

import java.util.List;

public interface ProductService {

    Product addProduct(Product product);

    Product updateProduct(Product product);

    Product getProduct(Long id);

    Product getProductByName(String name);

    List<Product> getAllProducts();

    void deleteProduct(Long id);
}
