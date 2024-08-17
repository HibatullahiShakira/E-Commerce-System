package com.semicolon.data.repositories;

import com.semicolon.data.model.CreditCardInformation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CreditCardInformationRepository extends MongoRepository<CreditCardInformation, String> {
    CreditCardInformation findCreditCardInformationById(String userId);
}
