package com.semicolon.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface BillingInformation extends MongoRepository<BillingInformation, String> {
}
