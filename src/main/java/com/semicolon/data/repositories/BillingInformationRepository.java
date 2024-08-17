package com.semicolon.data.repositories;

import com.semicolon.data.model.BillingInformation;
import com.semicolon.data.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BillingInformationRepository extends MongoRepository<BillingInformation, String> {
    BillingInformation findBillingInformationByUser(User user);
    List<BillingInformation> findAllByUser(User user);


}
