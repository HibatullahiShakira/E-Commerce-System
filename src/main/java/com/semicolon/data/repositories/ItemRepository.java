package com.semicolon.data.repositories;

import com.semicolon.data.model.Item;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ItemRepository extends MongoRepository<Item, String> {
}
