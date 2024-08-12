package com.semicolon.repositories;

import com.semicolon.data.model.BillingInformation;
import com.semicolon.data.model.User;
import com.semicolon.data.model.UserRole;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BillingInformationRepository extends MongoRepository<BillingInformation, String> {
    BillingInformation findBillingInformationByUser(User user);
    List<BillingInformation> findAllByUserRole(User user, UserRole userRole);


}
