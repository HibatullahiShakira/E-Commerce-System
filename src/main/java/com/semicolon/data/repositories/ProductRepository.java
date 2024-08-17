package com.semicolon.data.repositories;

import com.semicolon.data.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String> {
    List<Product> findProductByProductName(String name);
}
