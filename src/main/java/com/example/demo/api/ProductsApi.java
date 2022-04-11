package com.example.demo.api;

import com.example.demo.domain.Product;
import com.example.demo.svcs.ProductService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/products")
public class ProductsApi {

    private final ProductService svc;

    public ProductsApi(ProductService productsService) {
        this.svc = productsService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Product>> getAll() {
        return ok(svc.getAllProducts());
    }

    @PostMapping("/new")
    public ResponseEntity<Product> save(@RequestBody Product body) {
        return ok(svc.save(body));
    }

}
