package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    ProductRepository repo;

    public Product save(Product p) {
        return repo.save(p);
    }

    public List<Product> getAll() {
        return repo.findAll();
    }

    public Product getById(int id) {
        return repo.findById(id).orElse(null);
    }

    public Product update(int id, Product p) {
        Product old = repo.findById(id).orElse(null);
        if (old != null) {
            old.setName(p.getName());
            old.setPrice(p.getPrice());
            return repo.save(old);
        }
        return null;
    }

    public void delete(int id) {
        repo.deleteById(id);
    }
}