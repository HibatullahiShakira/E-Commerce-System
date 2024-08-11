package com.semicolon.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;


public interface Item extends MongoRepository<Item, String> {
}
