package com.example.demo.svcs;

import com.example.demo.domain.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    Product save(Product product);
}

