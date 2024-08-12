package com.semicolon.repositories;

import com.semicolon.data.model.ShoppingCartItem;
import com.semicolon.data.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ShoppingCartRepository extends MongoRepository<ShoppingCartItem, String> {
    ShoppingCartItem findByUser(User user);
}
