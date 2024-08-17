package com.semicolon.services.serviceInterface;

import com.semicolon.dto.request.*;
import com.semicolon.dto.response.*;

public interface CreditCardInformationService {
    AddCreditCardInformationResponse addCreditCardInformation(CreditCardInformationDtoRequest creditCardInformationDtoRequest);
    CreditCardInformationUpdateResponse updateCreditCardInformationByUserId(CreditCardInformationUpdateRequest creditCardInformationUpdateRequest);
    CreditCardInformationDtoResponse getCreditCardInformationBy_BillingInformation(GetCreditCardInformation getCreditCardInformation);
}
