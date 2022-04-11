package com.example.demo.svcs;

import com.example.demo.crosscutting.metrics.TrackExecutionTime;
import com.example.demo.crosscutting.validations.EnforceAutoEntityDataValidation;
import com.example.demo.domain.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    @TrackExecutionTime()
    public List<Product> getAllProducts() {
        List<Product> result = new ArrayList<>();
        for (Product p : repository.findAll()) {
            result.add(p);
        }
        return result;
    }

    @Override
    @TrackExecutionTime()
    @EnforceAutoEntityDataValidation
    public Product save(Product product) {
        return repository.save(product);
    }
}
