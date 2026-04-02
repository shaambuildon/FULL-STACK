package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.Product;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService service;

    // SESSION 26
    @PostMapping
    public Product addProduct(@RequestBody Product p) {
        return service.save(p);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return service.getAll();
    }

    // SESSION 27
    @GetMapping("/{id}")
    public Product getProduct(@PathVariable int id) {
        return service.getById(id);
    }

    // SESSION 28
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable int id, @RequestBody Product p) {
        return service.update(id, p);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable int id) {
        service.delete(id);
        return "Deleted";
    }

    // SESSION 29
    @GetMapping("/search")
    public String search(@RequestParam String name) {
        return "Searching " + name;
    }

    @GetMapping("/status")
    public ResponseEntity<String> status() {
        return ResponseEntity.ok("API Working");
    }
}