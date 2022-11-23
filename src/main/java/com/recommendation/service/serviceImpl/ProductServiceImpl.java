package com.recommendation.service.serviceImpl;

import com.recommendation.service.model.Product;
import com.recommendation.service.repo.ProductRepo;
import com.recommendation.service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Override
    public Product addProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public Product getProduct(Long id) {
        Optional<Product> optional = productRepo.findById(id);
        if (optional.isPresent()) {
            return productRepo.findById(id).get();
        }
        return null;
    }

    @Override
    public Product getProductByName(String name) {
        return productRepo.getProductByName(name).get();
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public void deleteProduct(Long id) {
        productRepo.deleteById(id);
    }
}
