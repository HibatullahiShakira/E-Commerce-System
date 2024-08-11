package com.semicolon.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ShoppingCart  extends MongoRepository<ShoppingCart, String> {

}
