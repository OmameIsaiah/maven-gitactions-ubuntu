package com.recommendation.service.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.recommendation.service.model.Product;
import com.recommendation.service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ProductController {
    @Autowired
    private ProductService service;

    @HystrixCommand(fallbackMethod = "listProductFallback", groupKey = "All Products", commandKey = "All Products")
    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return service.getAllProducts();
    }

    @HystrixCommand(fallbackMethod = "productFallback", groupKey = "Single Product by ID", commandKey = "Single Product by ID")
    @GetMapping("/product/{id}")
    public Product getProduct(@PathVariable Long id) {
        return service.getProduct(id);
    }

    @HystrixCommand(fallbackMethod = "productNameFallback", groupKey = "Single Product by Name", commandKey = "Single Product by Name")
    @GetMapping("/product/name/{name}")
    public Product getProductByName(@PathVariable String name) {
        return service.getProductByName(name);
    }

    @HystrixCommand(fallbackMethod = "addProductFallback", groupKey = "Add Product", commandKey = "Add Product")
    @PostMapping("/product/add")
    public Product addProduct(@RequestBody Product product) {
        return service.addProduct(product);
    }

    @HystrixCommand(fallbackMethod = "addProductFallback", groupKey = "Update Products", commandKey = "Update Product")
    @PutMapping("/product/update")
    public Product updateProduct(@RequestBody Product product) {
        return service.addProduct(product);
    }

    @HystrixCommand(fallbackMethod = "deleteProductFallback", groupKey = "Delete Product", commandKey = "Delete Product")
    @DeleteMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        service.deleteProduct(id);
        return "Product Deleted Successfully!";
    }

    /////////////////////////////////////FALLBACK METHODS////////////////////////////////
    /////////////////////////////////////FALLBACK METHODS////////////////////////////////
    /////////////////////////////////////FALLBACK METHODS////////////////////////////////
    /////////////////////////////////////FALLBACK METHODS////////////////////////////////
    /////////////////////////////////////FALLBACK METHODS////////////////////////////////
    /////////////////////////////////////FALLBACK METHODS////////////////////////////////
    /////////////////////////////////////FALLBACK METHODS////////////////////////////////
    /////////////////////////////////////FALLBACK METHODS////////////////////////////////
    /////////////////////////////////////FALLBACK METHODS////////////////////////////////
    /////////////////////////////////////FALLBACK METHODS////////////////////////////////
    /////////////////////////////////////FALLBACK METHODS////////////////////////////////

    public List<Product> listProductFallback() {
        System.out.println("=======listProductFallback=========");
        Product product = new Product();
        product.setId(1L);
        product.setName("Error");
        product.setDescription("An error had occurred. The circuit has been broken!");
        product.setAmount(0D);
        product.setImage("");
        product.setRemark("");
        List<Product> p = new ArrayList<Product>();
        p.add(product);
        return p;
    }

    public Product productFallback(Long id) {
        System.out.println("=======generalFallback=========" + id);
        Product product = new Product();
        product.setId(1L);
        product.setName("Error");
        product.setDescription("An error had occurred. The circuit has been broken!");
        product.setAmount(0D);
        product.setImage("");
        product.setRemark("");
        return product;
    }

    public Product addProductFallback(Product pro) {
        System.out.println("=======generalFallback=========" + pro.toString());
        Product product = new Product();
        product.setId(1L);
        product.setName("Error");
        product.setDescription("An error had occurred. The circuit has been broken!");
        product.setAmount(0D);
        product.setImage("");
        product.setRemark("");
        return product;
    }

    public Product productNameFallback(String name) {
        System.out.println("=======generalFallback=========" + name);
        Product product = new Product();
        product.setId(1L);
        product.setName("Error");
        product.setDescription("An error had occurred. The circuit has been broken!");
        product.setAmount(0D);
        product.setImage("");
        product.setRemark("");
        return product;
    }

    public String deleteProductFallback(Long id) {
        System.out.println("=======generalFallback=========" + id);
        return "Service unavailable at the moment. Please try again later!";
    }

}
