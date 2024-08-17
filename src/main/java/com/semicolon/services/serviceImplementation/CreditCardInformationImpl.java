package com.semicolon.services.serviceImplementation;

import com.semicolon.data.model.CreditCardInformation;
import com.semicolon.data.model.User;
import com.semicolon.data.repositories.BillingInformationRepository;
import com.semicolon.data.repositories.CreditCardInformationRepository;
import com.semicolon.data.repositories.UserRepository;
import com.semicolon.dto.request.*;
import com.semicolon.dto.response.AddCreditCardInformationResponse;
import com.semicolon.dto.response.CreditCardInformationDtoResponse;
import com.semicolon.dto.response.CreditCardInformationUpdateResponse;
import com.semicolon.services.serviceInterface.CreditCardInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditCardInformationImpl implements CreditCardInformationService {

    @Autowired
    CreditCardInformationRepository creditCardInformationRepository;
    @Autowired
    private BillingInformationRepository billingInformationRepository;
    @Autowired
    private UserRepository userRepository;

    public CreditCardInformationImpl(CreditCardInformationRepository creditCardInformationRepository) {
        this.creditCardInformationRepository = creditCardInformationRepository;
    }

    @Override
    public AddCreditCardInformationResponse addCreditCardInformation(CreditCardInformationDtoRequest creditCardInformationDtoRequest) {
        User user = userRepository.findUserByUserId(creditCardInformationDtoRequest.getUser().getUserId());
        CreditCardInformation creditCardInformation = new CreditCardInformation();
        creditCardInformation.setCardType(creditCardInformationDtoRequest.getCardType());
        creditCardInformation.setCardNumber(creditCardInformationDtoRequest.getCardNumber());
        creditCardInformationDtoRequest.setCvv(creditCardInformationDtoRequest.getCvv());
        creditCardInformationDtoRequest.setExpiryMonth(creditCardInformationDtoRequest.getExpiryMonth());
        creditCardInformationDtoRequest.setExpiryYear(creditCardInformationDtoRequest.getExpiryYear());
        creditCardInformationDtoRequest.setCardHolderName(creditCardInformationDtoRequest.getCardHolderName());
        creditCardInformationDtoRequest.setUser(user);

        creditCardInformationRepository.save(creditCardInformation);
        AddCreditCardInformationResponse addCreditCardInformationResponse = new AddCreditCardInformationResponse();
        addCreditCardInformationResponse.setMessage("credit card added successfully");
        return addCreditCardInformationResponse;
    }

    @Override
    public CreditCardInformationUpdateResponse updateCreditCardInformationByUserId(CreditCardInformationUpdateRequest creditCardInformationUpdateRequest) {
            CreditCardInformation foundCreditCardInformation = creditCardInformationRepository.findCreditCardInformationById(creditCardInformationUpdateRequest.getUser().getUserId());
            CreditCardInformationUpdateResponse creditCardInformationUpdateResponse = new CreditCardInformationUpdateResponse();
            if (foundCreditCardInformation != null) {
                if (creditCardInformationUpdateRequest.getCardType() != null) {
                    foundCreditCardInformation.setCardType(creditCardInformationUpdateRequest.getCardType());
                }
                if (creditCardInformationUpdateRequest.getCardNumber() != null) {
                    foundCreditCardInformation.setCardNumber(creditCardInformationUpdateRequest.getCardNumber());
                }
                if (creditCardInformationUpdateRequest.getCvv() != null) {
                    foundCreditCardInformation.setCvv(creditCardInformationUpdateRequest.getCvv());
                }
                if (creditCardInformationUpdateRequest.getExpiryMonth() != null) {
                    foundCreditCardInformation.setExpiryMonth(creditCardInformationUpdateRequest.getExpiryMonth());
                }
                if (creditCardInformationUpdateRequest.getExpiryYear() != null) {
                    foundCreditCardInformation.setExpiryYear(creditCardInformationUpdateRequest.getExpiryYear());
                }
                if (creditCardInformationUpdateRequest.getCardHolderName() != null) {
                    foundCreditCardInformation.setCardHolderName(creditCardInformationUpdateRequest.getCardHolderName());
                }
                creditCardInformationRepository.save(foundCreditCardInformation);
            }
            CreditCardInformationUpdateResponse creditCardInformationResponse = new CreditCardInformationUpdateResponse();
            creditCardInformationResponse.setMessage("credit card updated successfully");
            return creditCardInformationResponse;
    }

    @Override
    public CreditCardInformationDtoResponse getCreditCardInformationBy_BillingInformation(GetCreditCardInformation getCreditCardInformation) {
        User user = userRepository.findUserByEmailAddressAndPassword(getCreditCardInformation.getUser().getEmailAddress(), getCreditCardInformation.getUser().getPassword());
        CreditCardInformation foundCreditCardInformation = creditCardInformationRepository.findCreditCardInformationById(user.getUserId());
        creditCardInformationRepository.delete(foundCreditCardInformation);

        CreditCardInformationDtoResponse creditCardInformationDtoResponse = getCreditCardInformationDtoResponse(foundCreditCardInformation);

        return creditCardInformationDtoResponse;
    }

    private static CreditCardInformationDtoResponse getCreditCardInformationDtoResponse(CreditCardInformation foundCreditCardInformation) {
        CreditCardInformationDtoResponse creditCardInformationDtoResponse = new CreditCardInformationDtoResponse();
        creditCardInformationDtoResponse.setCardNumber(foundCreditCardInformation.getCardNumber());
        creditCardInformationDtoResponse.setExpiryYear(foundCreditCardInformation.getExpiryYear());
        creditCardInformationDtoResponse.setCardType(foundCreditCardInformation.getCardType());
        creditCardInformationDtoResponse.setCvv(foundCreditCardInformation.getCvv());
        creditCardInformationDtoResponse.setCardHolderName(foundCreditCardInformation.getCardHolderName());
        creditCardInformationDtoResponse.setExpiryMonth(foundCreditCardInformation.getExpiryMonth());
        return creditCardInformationDtoResponse;
    }


}
